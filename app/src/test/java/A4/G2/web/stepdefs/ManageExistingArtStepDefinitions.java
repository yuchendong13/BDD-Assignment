package A4.G2.web.stepdefs;

import A4.G2.web.pages.ArtGalleryPage;
import A4.G2.web.pages.RemoveArtPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ManageExistingArtStepDefinitions {
    private WebDriver driver;
    private RemoveArtPage removeArtPage;

    private ArtGalleryPage galleryPage;


    @Given("Driver set up for remove art page")
    public void driverSetUpForRemoveArtPage() {
        driver = Hooks.getDriver();
        removeArtPage = new RemoveArtPage(driver);
        galleryPage  = new ArtGalleryPage(driver);
    }

    @Given("I am on the remove art page")
    public void iAmOnTheRemoveArtPage() {
        driver.get("http://localhost:8080/remove-art");
    }


    @When("I enter {string} as remove id field")
    public void iEnterAsRemoveIdField(String string) {
        removeArtPage.insertIdToRemove(string);
    }

    @And("I click on the Submit Id to Remove button")
    public void iClickOnTheSubmitIdToRemoveButton() {
        removeArtPage.clickSubmit();
    }
    @When("I press the back to gallery button")
    public void iPressTheBackToGalleryButton() {
        removeArtPage.clickBackToGallery();
    }


        @Then("I should see art successfully remove message")
    public void iShouldSeeArtSuccessfullyRemoveMessage() {
        assertTrue(removeArtPage.getMessage().contains("Art titled: \"Title\" successfully removed"));
    }


    @Then("I should see remove art error")
    public void iShouldSeeRemoveArtError() {
        assertTrue(removeArtPage.getErrorMessage().contains("Invalid ID please try again"));
    }


    @Then("I should see the gallery page")
    public void iShouldSeeTheGalleryPage() {
        assertTrue(driver.getCurrentUrl().contains("art-gallery"));
    }
}

