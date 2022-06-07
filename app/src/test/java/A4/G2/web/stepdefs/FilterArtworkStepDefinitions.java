package A4.G2.web.stepdefs;

import A4.G2.web.pages.ArtGalleryPage;
import A4.G2.web.pages.PricePage;
import A4.G2.web.pages.SaleTypePage;
import A4.G2.web.pages.TimePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

public class FilterArtworkStepDefinitions {
    private WebDriver driver;
    private ArtGalleryPage artGalleryPage;
    private SaleTypePage saleTypePage;
    private PricePage priceRangePage;
    private TimePage timeRangePage;

    @Given("Driver set up for art gallery page")
    public void driverSetUpForArtGalleryPage() {
        driver = Hooks.getDriver();
        artGalleryPage = new ArtGalleryPage(driver);
        saleTypePage = new SaleTypePage(driver);
        priceRangePage = new PricePage(driver);
        timeRangePage = new TimePage(driver);
    }

    @And("Gallery populated with test artwork")
    public void galleryPopulatedWithTestArtwork() {
        driver.get("http://localhost:8080/art-gallery/populate-testing");
    }

    @Given("I am currently on the art gallery page")
    public void iAmCurrentlyOnTheArtGalleryPage() {
        driver.get("http://localhost:8080/art-gallery");
    }

    @When("I select the buy now filter option")
    public void iSelectTheBuyNowFilterOption() {
        artGalleryPage.selectBuyNowFilterOption();
    }

    @When("I press the filter by sale type button")
    public void iPressTheFilterBySaleTypeButton() {
        artGalleryPage.clickFilterSaleButton();
    }

    @Then("I should see all the art pieces with a buy now")
    public void iShouldSeeAllTheArtPiecesWithABuyNow() {
        List<String> titles = Arrays.asList("Art 2", "Art 4", "Art 6", "Art 8");
        artGalleryPage.checkAllBuyNowPiecesDisplayed(titles);
    }

    @When("I select the auction filter option")
    public void iSelectTheAuctionFilterOption() {
        artGalleryPage.selectAuctionFilterOption();
    }

    @Then("I should see all the art pieces on auction")
    public void iShouldSeeAllTheArtPiecesOnAuction() {
        List<String> titles = Arrays.asList("Art 1", "Art 5", "Art 7", "Art 9");
        artGalleryPage.checkAllAuctionPiecesDisplayed(titles);
    }

    @When("I select the painting filter option")
    public void iSelectThePaintingFilterOption() {
        artGalleryPage.selectPaintingFilterOption();
    }

    @And("I press the filter by art type button")
    public void iPressTheFilterByArtTypeButton() {
        artGalleryPage.clickFilterArtOption();
    }

    @Then("I should see all the painting art pieces")
    public void iShouldSeeAllThePaintingArtPieces() {
        List<String> titles = Arrays.asList("Title", "Art 1", "Art 4", "Art 5");
        artGalleryPage.checkAllPaintingArtDisplayed(titles);
    }

    @When("I select the print filter option")
    public void iSelectThePrintFilterOption() {
        artGalleryPage.selectPrintFilterOption();
    }

    @Then("I should see all the print art pieces")
    public void iShouldSeeAllThePrintArtPieces() {
        List<String> titles = Arrays.asList("Art 2", "Art 6", "Art 7");
        artGalleryPage.checkAllPrintArtDisplayed(titles);
    }

    @When("I select the sculpture filter option")
    public void iSelectTheSculptureFilterOption() {
        artGalleryPage.selectSculptureFilterOption();
    }

    @Then("I should see all the sculpture art pieces")
    public void iShouldSeeAllTheSculptureArtPieces() {
        List<String> titles = Arrays.asList("Art 3", "Art 8", "Art 9");
        artGalleryPage.checkAllSculptureArtDisplayed(titles);
    }

    @Given("I am currently on the buy now art gallery page")
    public void iAmCurrentlyOnTheBuyNowArtGalleryPage() {
        driver.get("http://localhost:8080/art-gallery");
        artGalleryPage.selectBuyNowFilterOption();
        artGalleryPage.clickFilterSaleButton();
    }

    @When("I set the minimum price to {int}")
    public void iSetTheMinimumPriceTo(int i) {
        saleTypePage.insertMinimumPrice(i);
    }

    @When("I set the maximum price to {int}")
    public void iSetTheMaximumPriceTo(int i) {
        saleTypePage.insertMaximumPrice(i);
    }

    @And("I press the filter by price button")
    public void iPressTheFilterByPriceButton() {
        saleTypePage.clickFilterByPriceButton();
    }

    @Then("I should see all the art pieces with a buy now lower than the max price")
    public void iShouldSeeAllTheArtPiecesWithABuyNowLowerThanTheMaxPrice() {
        List<String> titles = Arrays.asList("Art 2", "Art 4");
        priceRangePage.checkAllInPriceRangeDisplayed(titles);
    }

    @Then("I should see all the art pieces with a buy now greater than the min price")
    public void iShouldSeeAllTheArtPiecesWithABuyNowGreaterThanTheMinPrice() {
        List<String> titles = Arrays.asList("Art 6", "Art 8");
        priceRangePage.checkAllInPriceRangeDisplayed(titles);
    }

    @Then("I should see all the art pieces with a buy now between the min and the max price")
    public void iShouldSeeAllTheArtPiecesWithABuyNowBetweenTheMinAndTheMaxPrice() {
        List<String> titles = Arrays.asList("Art 8");
        priceRangePage.checkAllInPriceRangeDisplayed(titles);
    }

    @Given("I am currently on the auction art gallery page")
    public void iAmCurrentlyOnTheAuctionArtGalleryPage() {
        driver.get("http://localhost:8080/art-gallery");
        artGalleryPage.selectAuctionFilterOption();
        artGalleryPage.clickFilterSaleButton();
    }

    @When("I select the lower than option")
    public void iSelectTheLowerThanOption() {
        saleTypePage.selectLessThanTimeRemainingOption();
    }

    @And("I set the hour to {int}")
    public void iSetTheHourTo(int i) {
        saleTypePage.insertHour(i);
    }

    @And("I set the minutes to {int}")
    public void iSetTheMinutesTo(int i) {
        saleTypePage.insertMinute(i);
    }

    @And("I press the filter by time button")
    public void iPressTheFilterByTimeButton() {
        saleTypePage.clickFilterByTimeButton();
    }

    @Then("I should see all the art pieces on auction with less than {int} hour remaining")
    public void iShouldSeeAllTheArtPiecesOnAuctionWithLessThanHourRemaining(int i) {
        List<String> titles = Arrays.asList("Art 1", "Art 5");
        timeRangePage.checkAllInTimeRangeDisplayed(titles);
    }

    @When("I select the higher than option")
    public void iSelectTheHigherThanOption() {
        saleTypePage.selectMoreThanTimeRemainingOption();
    }

    @Then("I should see all the art pieces on auction with more than {int} hours remaining")
    public void iShouldSeeAllTheArtPiecesOnAuctionWithMoreThanHoursRemaining(int arg0) {
        List<String> titles = Arrays.asList("Art 9");
        timeRangePage.checkAllInTimeRangeDisplayed(titles);
    }
}
