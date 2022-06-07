package A4.G2.controller;

import A4.G2.model.Payment;
import A4.G2.model.users.ShippingDetails;
import A4.G2.model.users.User;
import A4.G2.service.Gallery;
import A4.G2.service.account.*;
import A4.G2.service.payment.InvalidPaymentException;
import A4.G2.service.payment.PaymentVerifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.io.IOException;
import java.util.Date;

@Controller
@SessionAttributes("loggedInUser")
public class ManageAccountController {

    @Autowired
    Gallery gallery;

    @RequestMapping(value="/manage-account", method = RequestMethod.GET)
    public String showSignupPage(ModelMap model){
        return "manage-account";
    }

    @RequestMapping(value="/manage-account/username", method = RequestMethod.POST)
    public String changeAccountUsername(ModelMap model, @RequestParam String newUsername) throws IOException {
        gallery.initiate();
        ILoginDetailsManager loginDetailsManager = new LoginDetailsManager(gallery);

        if (!newUsername.matches(".*\\w.*")) {
            model.put("usernameErrorMessage", "Invalid username: Username must contain at least one char");
            return "manage-account";
        }

        try {
            loginDetailsManager.changeUsername((User) model.get("loggedInUser"), newUsername);
        } catch (UsernameTakenException e) {
            model.put("usernameErrorMessage", "Invalid username: Username is already taken");
            return "manage-account";
        }

        return "manage-account";
    }

    @RequestMapping(value="/manage-account/password", method = RequestMethod.POST)
    public String changeAccountPassword(ModelMap model, @RequestParam String currentPassword, @RequestParam String newPassword,
                                        @RequestParam String retypedPassword) throws IOException {
        gallery.initiate();
        ILoginDetailsManager loginDetailsManager = new LoginDetailsManager(gallery);

        try {
            loginDetailsManager.changePassword((User) model.get("loggedInUser"), currentPassword, newPassword,
                    retypedPassword);
        } catch (WeakPasswordException | IncorrectPasswordException e) {
            if (e instanceof IncorrectPasswordException) {
                if (e.getMessage().contains("old")) {
                    model.put("passwordErrorMessage", "Invalid password: Current password incorrect");
                } else {
                    model.put("passwordErrorMessage", "Invalid password: New and retyped passwords don't match");
                }
            } else {
                if (e.getLocalizedMessage().contains("digit")) {
                    model.put("passwordErrorMessage", "Invalid password: Password must contain at least one digit");
                } else if (e.getMessage().contains("capital")) {
                    model.put("passwordErrorMessage", "Invalid password: Password must contain at least one capital letter");
                } else {
                    model.put("passwordErrorMessage", "Invalid password: Password must contain at least 6 characters");
                }
            }
            return "manage-account";
        }

        model.put("passwordSuccessMessage", "Password changed successfully");
        return "manage-account";
    }

    @RequestMapping(value="/manage-account/shipping", method = RequestMethod.POST)
    public String changeShippingDetails(ModelMap model, @RequestParam String address, @RequestParam String preferences)
            throws IOException {

        gallery.initiate();
        IShippingDetailsManager shippingDetailsManager = new ShippingDetailsManager();

        if (address.matches(".*\\w.*")) {
            shippingDetailsManager.modifyShippingAddress((User) model.get("loggedInUser"), address);
        }

        if (preferences.matches(".*\\w.*")) {
            shippingDetailsManager.modifyShippingPreferences((User) model.get("loggedInUser"), preferences);
        }

        return "manage-account";
    }

    @RequestMapping(value="/manage-account/shipping/delete", method = RequestMethod.GET)
    public String deleteShippingDetails(ModelMap model)
            throws IOException {

        gallery.initiate();
        IShippingDetailsManager shippingDetailsManager = new ShippingDetailsManager();

        User loggedInUser = (User) model.get("loggedInUser");

        shippingDetailsManager.modifyShippingAddress(loggedInUser, "");
        shippingDetailsManager.modifyShippingPreferences(loggedInUser, "");

        return "manage-account";
    }

    @RequestMapping(value="/manage-account/payment", method = RequestMethod.POST)
    public String changePaymentDetails(ModelMap model, @RequestParam String cardNumber, @RequestParam String cardHolder,
                                        @RequestParam String cvv, @RequestParam String year) throws IOException {

        gallery.initiate();

        try {
            PaymentVerifier.verifyPayment(cardNumber, cardHolder, year, cvv);
        } catch (InvalidPaymentException e) {
            model.put("paymentErrorMessage", "Invalid payment details provided");
            return "manage-account";
        }

        User loggedInUser = (User) model.get("loggedInUser");

        Payment newPaymentDetails = new Payment(cardNumber, cardHolder, year, cvv);
        loggedInUser.modifyPayment(newPaymentDetails);

        return "manage-account";
    }

    @RequestMapping(value="/manage-account/payment/delete", method = RequestMethod.GET)
    public String deletePaymentDetails(ModelMap model)
            throws IOException {

        gallery.initiate();

        User loggedInUser = (User) model.get("loggedInUser");

        loggedInUser.deletePaymentDetails();

        return "manage-account";
    }



    /**
     * Test endpoint to simulate a user log in.
     */
    @RequestMapping(value="/manage-account/testing", method = RequestMethod.GET)
    public String testManageAccountPage(ModelMap model) throws IOException {
        gallery.galleryReinitiate();
        LoginDetailsManager loginDetailsManager = new LoginDetailsManager(gallery);

        User user1 = loginDetailsManager.loginUser("user1", "Password123");
        model.put("loggedInUser", user1);

        return "populate";
    }
}
