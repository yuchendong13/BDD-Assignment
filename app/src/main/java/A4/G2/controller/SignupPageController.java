package A4.G2.controller;

import A4.G2.service.Gallery;
import A4.G2.model.users.User;
import A4.G2.service.account.ILoginDetailsManager;
import A4.G2.service.account.LoginDetailsManager;
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
@SessionAttributes({"loggedInUser", "termsAndConditions"})
public class SignupPageController {

    @Autowired
    Gallery gallery;

    @RequestMapping(value="/signup", method = RequestMethod.GET)
    public String showSignupPage(ModelMap model) throws IOException {
        gallery.initiate();

        model.put("termsAndConditions", gallery.getTermsAndConditions());
        return "signup";
    }

    @RequestMapping(value="/signup", method = RequestMethod.POST)
    public String showWelcomePage(ModelMap model, @RequestParam String name, @RequestParam String password,
                                  @RequestParam String retypedPassword,
                                  @RequestParam(defaultValue = "false") boolean checkbox){

        ILoginDetailsManager loginDetailsManager = new LoginDetailsManager(gallery);

        if (!name.matches(".*\\w.*")) {
            model.put("errorMessage", "Invalid Credentials: Username must contain at least one character");
            return "signup";
        } else if (loginDetailsManager.checkUsernameTaken(name)) {
            model.put("errorMessage", "Invalid Credentials: Username taken");
            return "signup";
        }

        int passwordSecure = loginDetailsManager.checkPasswordSecure(password, retypedPassword);

        if (passwordSecure == -1) {
            model.put("errorMessage", "Invalid Credentials: Password is less that 6 chars");
            return "signup";
        } else if (passwordSecure == -2) {
            model.put("errorMessage", "Invalid Credentials: Password must contain at least one capital letter");
            return "signup";
        } else if (passwordSecure == -3) {
            model.put("errorMessage", "Invalid Credentials: Password must contain at least one digit");
            return "signup";
        }

        if (passwordSecure == 0) {
            model.put("errorMessage", "Invalid Credentials: Retyped password does not match");
            return "signup";
        }

        if (!checkbox) {
            model.put("errorMessage", "Invalid Credentials: You must accept terms and conditions to create an account");
            return "signup";
        }

        User newUser = new User(name, password, "placeholder_email", "placeholder_email",
                "placeholder_address", new Date(1990, 6, 3));

        gallery.addUser(newUser);

        model.put("loggedInUser", newUser);

        return "home";
    }
}
