package A4.G2.web.stepdefs;

import A4.G2.web.pages.ShippingDetailsPage;
import A4.G2.web.pages.SuccessPage;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import A4.G2.web.pages.ArtDetailsPage;
import A4.G2.web.pages.ArtistDetailsPage;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShippingDetailsStepDefinitions {

    private ShippingDetailsPage shippingDetailsPage;

    private ArtDetailsPage artDetailsPage;

    private SuccessPage successPage;
    private WebDriver driver;

    @Given("Driver set up for shipping details page")
    public void driverSetUpForArtistDetailsPage() {
        driver = Hooks.getDriver();
        this.artDetailsPage = new ArtDetailsPage(driver);
        this.shippingDetailsPage= new ShippingDetailsPage(driver);
        this.successPage = new SuccessPage(driver);
    }

    @Then("I want to enter my shipping details.")
    public void iWantToEnterMyShippingDetails() {
        shippingDetailsPage.insertAddress("92 Narnia Land, London, England");
    }

    @Given("I have clicked the buy now of an artwork")
    public void iHaveEnteredMyShippingDetails() {
        driver.get("http://localhost:8080/shipping");

    }

    @When("I click on the submit button")
    public void iClickOnTheSubmitButton() {
        shippingDetailsPage.clickSubmit();
    }

    @Then("I want a confirmation of my purchase.")
    public void iWantAConfirmationOfMyPurchase() {
        driver.get("http://localhost:8080/success");
        Assertions.assertEquals("http://localhost:8080/success", driver.getCurrentUrl());
    }

    @Given("That I'm on the art details page")
    public void thatIMOnTheArtDetailsPage() {
        driver.get("http://localhost:8080/art-details");
        this.artDetailsPage.clickLogin();
        this.artDetailsPage.insertAge("21");
    }

    @When("When I click buy now on a artwork")
    public void whenIClickBuyNowOnAArtwork() {
        artDetailsPage.clickBuyNow();
    }

    @Then("I want to be able to enter my shipping details")
    public void iWantToBeAbleToEnterMyShippingDetails() {
        driver.get("http://localhost:8080/shipping");
        Assertions.assertEquals("http://localhost:8080/shipping", driver.getCurrentUrl());
    }
}
