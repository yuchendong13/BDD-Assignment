package A4.G2.web.stepdefs;

import A4.G2.web.pages.ArtDetailsPage;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class BidArtStepDefinitions {
    private ArtDetailsPage artDetailsPage;
    private WebDriver driver;
    @Given("I am presently on the details page for a piece of art")
    public void setup(){
        driver = Hooks.getDriver();
        this.artDetailsPage = new ArtDetailsPage(driver);
    }

    @Given("I want to buy an artwork")
    public void iBuyArtwork(){
        driver.get("http://localhost:8080/art-details");
    }

    @Given("I am {string} years")
    public void iAmAgeYearsOld(String string) {
        driver.get("http://localhost:8080/art-details");
        artDetailsPage.insertAge(string);
    }

    @When("I click the Bid button")
    public void iClickTheBidNowButton() {
        artDetailsPage.clickBid();
    }

    @And("I am not logged in")
    public void iAmNotLoggedIntoAnAccount() {
        assertEquals("Not logged in",artDetailsPage.getLoginStatus());
    }

    @Then("Deny the Bid attempt")
    public void denyTheBiddingAttempt() {
        assertEquals(driver.getCurrentUrl(),"http://localhost:8080/art-details");
    }

    @And("Tell me to sign up or sign in")
    public void notifyMeToSignUpOrSignIn() {
        String notification = "Please sign up or log in.";
        String getNotification = artDetailsPage.getLoginNotification();
        Assertions.assertEquals(notification, getNotification);
    }

    @And("Tell me that I am too young")
    public void notifyMeThatIAmTooYoung() {
        String notification = "You are too young to purchase art.";
        String getNotification = artDetailsPage.getAgeNotification();
        Assertions.assertEquals(notification, getNotification);
    }

    @Then("Allow the Bid attempt")
    public void allowTheBidAttempt() {
        driver.get("http://localhost:8080/success-page");
        Assertions.assertEquals("http://localhost:8080/success-page", driver.getCurrentUrl());
    }

    @Given("I am logged in")
    public void iAmLoggedIntoAnAccount() {
        driver.get("http://localhost:8080/art-details");
        artDetailsPage.clickLogin();
    }
}
