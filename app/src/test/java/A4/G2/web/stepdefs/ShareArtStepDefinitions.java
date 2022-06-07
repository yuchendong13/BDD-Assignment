package A4.G2.web.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import A4.G2.web.pages.ArtDetailsPage;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShareArtStepDefinitions {
	private ArtDetailsPage artDetailsPage;
	private WebDriver driver;

	@Given("Driver set up for art details page")
	public void driverSetUpForArtDetailsPage() {
		driver = Hooks.getDriver();
		this.artDetailsPage = new ArtDetailsPage(driver);
	}

	@Given("I access an art details page")
	public void iAccessAnArtDetailsPage() {
		driver.get("http://localhost:8080/art-details");
	}

	@When("I click on the share button")
	public void iClickOnTheShareButton() {
		artDetailsPage.clickShare();
	}

	@Then("I want to generate a link of the art piece to share")
	public void iWantToGenerateALinkOfTheArtPieceToShare() {
		String url = driver.getCurrentUrl();
		String link = artDetailsPage.getGeneratedLink();
		assertEquals(url, link);
	}
}
