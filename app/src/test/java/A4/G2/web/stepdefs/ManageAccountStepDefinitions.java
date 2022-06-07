package A4.G2.web.stepdefs;

import A4.G2.web.pages.HomePage;
import A4.G2.web.pages.ManageAccountPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ManageAccountStepDefinitions {

    private WebDriver driver;
    private ManageAccountPage manageAccountPage;
    private HomePage homePage;

    @Given("Driver set up for manage account page")
    public void driverSetUpForManageAccountPage() {
        driver = Hooks.getDriver();
        manageAccountPage = new ManageAccountPage(driver);
        homePage = new HomePage(driver);
    }

    @Given("User is logged in")
    public void userIsLoggedIn() {
        driver.get("http://localhost:8080/manage-account/testing");
        driver.get("http://localhost:8080");
    }

    @Given("I start on the home page")
    public void iStartOnTheHomePage() {
        driver.get("http://localhost:8080/home");
    }

    @When("I press the manage account button")
    public void iPressTheManageAccountButton() {
        homePage.clickManageAccountButton();
    }

    @Then("I should see the manage account page")
    public void iShouldSeeTheManageAccountPage() {
        assertTrue(driver.getCurrentUrl().contains("manage-account"));
    }

    @Given("I am currently on the manage account page")
    public void iAmCurrentlyOnTheManageAccountPage() {
        driver.get("http://localhost:8080/manage-account");
    }

    @When("I enter {string} in the new username field")
    public void iEnterInTheNewUsernameField(String string) {
        manageAccountPage.insertNewUsername(string);
    }

    @And("I press the submit username button")
    public void iPressTheSubmitUsernameButton() {
        manageAccountPage.clickSubmitUsernameButton();
    }

    @Then("I should see the invalid username message")
    public void iShouldSeeTheInvalidUsernameMessage() {
        assertTrue(manageAccountPage.getUsernameErrorMessage().contains("Invalid username"));
    }

    @Then("I should see the new current username")
    public void iShouldSeeTheNewCurrentUsername() {
        assertTrue(manageAccountPage.getCurrentUsername().contains("user3"));
    }

    @When("I enter {string} as current password field")
    public void iEnterAsCurrentPasswordField(String string) {
        manageAccountPage.insertCurrentPassword(string);
    }

    @When("I enter {string} as new password field")
    public void iEnterAsNewPasswordField(String string) {
        manageAccountPage.insertNewPassword(string);
    }

    @When("I enter {string} as retyped new password field")
    public void iEnterAsRetypedNewPasswordField(String string) {
        manageAccountPage.insertRetypedNewPassword(string);
    }

    @And("I press the submit password button")
    public void iPressTheSubmitPasswordButton() {
        manageAccountPage.clickSubmitPasswordButton();
    }

    @Then("I should see the invalid password message")
    public void iShouldSeeTheInvalidPasswordMessage() {
        assertTrue(manageAccountPage.getPasswordErrorMessage().contains("Invalid password"));
    }

    @Then("I should see the password changed message")
    public void iShouldSeeThePasswordChangedMessage() {
        assertTrue(manageAccountPage.getPasswordSuccessMessage().contains("Password changed successfully"));
    }

    @When("I enter {string} in shipping address field")
    public void iEnterInShippingAddressField(String string) {
        manageAccountPage.insertNewShippingAddress(string);
    }

    @And("I press the submit shipping details button")
    public void iPressTheSubmitShippingDetailsButton() {
        manageAccountPage.clickSubmitShippingButton();
    }

    @Then("I should see the new address as my shipping address")
    public void iShouldSeeTheNewAddressAsMyShippingAddress() {
        assertTrue(manageAccountPage.getShippingAddress().contains("8, Rollers Avenue, Paper town"));
    }

    @When("I enter {string} in shipping preference field")
    public void iEnterInShippingPreferenceField(String string) {
        manageAccountPage.insertNewShippingPreference(string);
    }

    @Then("I should see the new preference as my shipping preference")
    public void iShouldSeeTheNewPreferenceAsMyShippingPreference() {
        assertTrue(manageAccountPage.getShippingPreference().contains("Only available on weekends"));
    }

    @When("I press delete button in the shipping details section")
    public void iPressDeleteButtonInTheShippingDetailsSection() {
        manageAccountPage.clickDeleteShippingDetailsButton();
    }

    @Then("Shipping details should be cleared in the page")
    public void shippingDetailsShouldBeClearedInThePage() {
        assertTrue(!manageAccountPage.getShippingAddress().contains("90, Farmer Street, Beach Villa"));
        assertTrue(!manageAccountPage.getShippingPreference().contains("Delivery after 5pm"));
    }

    @When("I enter {string} in the card number field")
    public void iEnterInTheCardNumberField(String string) {
        manageAccountPage.insertNewCardNumber(string);
    }

    @And("I enter {string} in the card holder field")
    public void iEnterInTheCardHolderField(String string) {
        manageAccountPage.insertNewCardHolder(string);
    }

    @And("I enter {string} in the cvv field")
    public void iEnterInTheCvvField(String string) {
        manageAccountPage.insertNewCVV(string);
    }

    @And("I enter {string} in the expiry year field")
    public void iEnterInTheExpiryYearField(String string) {
        manageAccountPage.insertNewYear(string);
    }

    @And("I press the submit payment details button")
    public void iPressTheSubmitPaymentDetailsButton() {
        manageAccountPage.clickSubmitPaymentButton();
    }

    @Then("I should see invalid payment credentials")
    public void iShouldSeeInvalidPaymentCredentials() {
        assertTrue(manageAccountPage.getPaymentErrorMessage().contains("Invalid payment details"));
    }

    @Then("I should see new payment credentials")
    public void iShouldSeeNewPaymentCredentials() {
        assertTrue(manageAccountPage.getCurrentCardNumber().contains("0123456789111111"));
        assertTrue(manageAccountPage.getCurrentCardHolder().contains("Antonio Cruise"));
        assertTrue(manageAccountPage.getCurrentCVV().contains("120"));
        assertTrue(manageAccountPage.getCurrentYear().contains("10/26"));
    }

    @When("I press the delete button in the payment details section")
    public void iPressTheDeleteButtonInThePaymentDetailsSection() {
        manageAccountPage.clickDeletePaymentDetailsButton();
    }

    @Then("Payment details should be cleared in the page")
    public void paymentDetailsShouldBeClearedInThePage() {
        assertTrue(!manageAccountPage.getCurrentCardNumber().contains("1234432156788765"));
        assertTrue(!manageAccountPage.getCurrentCardHolder().contains("Pablo Manolas"));
        assertTrue(!manageAccountPage.getCurrentCVV().contains("12/24"));
        assertTrue(!manageAccountPage.getCurrentYear().contains("234"));
    }
}
