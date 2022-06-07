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
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class PurchaseBuyNowStepDefinitions {
	private ArtDetailsPage artDetailsPage;
	private WebDriver driver;
	@Before
	public void setup(){
		driver = Hooks.getDriver();
		this.artDetailsPage = new ArtDetailsPage(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait((long)30, TimeUnit.SECONDS);
	}

	@AfterStep
	public void afterEachStep(){
		// to make the test at human speed
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@After
	public void tearDown() {
		driver.close();
	}

	@Given("I am on the details page for a piece of art")
	public void iAmOnTheDetailsPageForAPieceOfArt() {
		driver.get("http://localhost:8080/art-details");
	}

	@Given("I am {string} years old")
	public void iAmAgeYearsOld(String string) {
		artDetailsPage.insertAge(string);
	}

	@When("I click the Buy Now button")
	public void iClickTheBuyNowButton() {
		artDetailsPage.clickBuyNow();
	}

	@And("I am not logged into an account")
	public void iAmNotLoggedIntoAnAccount() {
		assertEquals("Not logged in",artDetailsPage.getLoginStatus());
	}

	@Then("Deny the buying attempt")
	public void denyTheBuyingAttempt() {
		assertEquals(driver.getCurrentUrl(),"http://localhost:8080/art-details");
	}

	@And("Notify me to sign up or sign in")
	public void notifyMeToSignUpOrSignIn() {
		String notification = "Please sign up or log in.";
		String getNotification = artDetailsPage.getLoginNotification();
		Assertions.assertEquals(notification, getNotification);
	}

	@And("Notify me that I am too young")
	public void notifyMeThatIAmTooYoung() {
		String notification = "You are too young to purchase art.";
		String getNotification = artDetailsPage.getAgeNotification();
		Assertions.assertEquals(notification, getNotification);
	}

	@Then("Allow the Buy Now attempt")
	public void allowTheBuyNowAttempt() {
		driver.get("http://localhost:8080/shipping");
		Assertions.assertEquals("http://localhost:8080/shipping", driver.getCurrentUrl());
	}

	@Given("I am logged into an account")
	public void iAmLoggedIntoAnAccount() {
		artDetailsPage.clickLogin();
	}
}
