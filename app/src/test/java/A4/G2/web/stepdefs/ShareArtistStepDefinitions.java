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
import A4.G2.web.pages.ArtistDetailsPage;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShareArtistStepDefinitions {

	private ArtistDetailsPage artistDetailsPage;
	private WebDriver driver;

	@Given("Driver set up for artist details page")
	public void driverSetUpForArtistDetailsPage() {
		driver = Hooks.getDriver();
		this.artistDetailsPage = new ArtistDetailsPage(driver);
	}

	@Given("I access an artist's profile page")
	public void iAccessAnArtistSProfilePage() {
		driver.get("http://localhost:8080/artist-details");
	}

	@When("I click on the share artist button")
	public void iClickOnTheShareArtistButton() {
		artistDetailsPage.clickShare();
	}

	@Then("I want to generate a link of the artist profile to share")
	public void iWantToGenerateALinkOfTheArtistProfileToShare() {
		String url = driver.getCurrentUrl();
		String link = artistDetailsPage.getGeneratedArtistLink();
		assertEquals(url, link);
	}
}
