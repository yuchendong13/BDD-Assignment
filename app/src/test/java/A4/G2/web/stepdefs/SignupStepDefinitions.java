package A4.G2.web.stepdefs;

import A4.G2.web.pages.SignupPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import A4.G2.web.pages.HomePage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SignupStepDefinitions {

    private WebDriver driver;
    private SignupPage signupPage;
    private HomePage homePage;

    @Given("Driver set up for signup page")
    public void driverSetUpForSignupPage() {
        driver = Hooks.getDriver();
        signupPage = new SignupPage(driver);
        homePage = new HomePage(driver);
    }

    @Given("I am currently on the home page")
    public void iAmCurrentlyOnTheHomePage() {
        driver.get("http://localhost:8080/home");
    }

    @When("I press the signup button")
    public void iPressTheSignupButton() {
        homePage.clickSignupNavButton();
    }

    @Then("I should see the signup page")
    public void iShouldSeeTheSignupPage() {
        assertTrue(driver.getCurrentUrl().contains("signup"));
    }

    @Given("I visit the signup page")
    public void iVisitTheSignupPage() {
        driver.get("http://localhost:8080/signup");
    }

    @When("I enter {string} as new account user name field")
    public void iEnterAsNewAccountUserNameField(String string) {
        signupPage.insertUserName(string);
    }

    @When("I enter {string} as new account password field")
    public void iEnterAsNewAccountPasswordField(String string) {
        signupPage.insertPassword(string);
    }

    @When("I enter {string} as new account retyped password field")
    public void iEnterAsNewAccountRetypedPasswordField(String string) {
        signupPage.insertRetypedPassword(string);
    }

    @When("I tick {string} for terms and conditions")
    public void iTickForTermsAndConditions(String string) {
        boolean termsAccepted = Boolean.valueOf(string);
        if (termsAccepted) {
            signupPage.clickConditions();
        }
    }

    @When("I press the signup submit button")
    public void iPressTheSignupSubmitButton() {
        signupPage.clickSignup();
    }

    @Then("I should see the invalid credentials message")
    public void iShouldSeeTheInvalidCredentialsMessage() {
        assertTrue(signupPage.getErrorMessage().contains("Invalid Credentials"));
    }

    @Then("I should see the welcome page for the created account")
    public void iShouldSeeTheWelcomePageForTheCreatedAccount() {
        assertTrue(signupPage.getMessage().contains("Welcome user2"));
    }
}
