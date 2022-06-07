package A4.G2.web.stepdefs;

import A4.G2.web.pages.LoginPage;
import A4.G2.web.pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginStepDefinitions {
    private WebDriver driver;
    private LoginPage loginPage;
    private HomePage homePage;

    @Given("Driver set up for login page")
    public void driverSetUpForLoginPage() {
        driver = Hooks.getDriver();
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
    }

    @Given("I am on the home page")
    public void iAmOnTheHomePage() {
        driver.get("http://localhost:8080/home");
    }

    @When("I press the login button")
    public void iPressTheLoginButton() {
        homePage.clickLoginNavButton();
    }

    @Then("I should see the login page")
    public void iShouldSeeTheLoginPage() {
        assertTrue(driver.getCurrentUrl().contains("login"));
    }

    @Given("I visit the login page")
    public void iVisitTheLoginPage() {
        driver.get("http://localhost:8080/login");
    }

    @When("I enter {string} as user name field")
    public void iEnterAsUserNameField(String string) {
        loginPage.insertUserName(string);
    }

    @When("I enter {string} as password field")
    public void iEnterAsPasswordField(String string) {
        loginPage.insertPassword(string);
    }

    @When("I press the submit button")
    public void iPressTheSubmitButton() {
        loginPage.clickLogin();
    }

    @Then("I should see the incorrect credentials message")
    public void iShouldSeeTheIncorrectCredentialsMessage() {
        assertTrue(loginPage.getErrorMessage().contains("Invalid Credentials"));
    }

    @Then("I should see the welcome page")
    public void iShouldSeeTheWelcomePage() {
        assertTrue(loginPage.getMessage().contains("Welcome user1"));
    }

}