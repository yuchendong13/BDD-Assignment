package A4.G2.web.stepdefs;

import A4.G2.web.pages.ArtGalleryPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ArtGalleryDefinitions {
    private WebDriver driver;
    private ArtGalleryPage artGalleryPage;

    @Given("Driver set up for virtual gallery page")
    public void driver_set_up_for_virtual_gallery_page() {
        driver = Hooks.getDriver();
        artGalleryPage = new ArtGalleryPage(driver);
    }

    @Given("I access virtual gallery page")
    public void i_access_virtual_gallery_page() {
        driver.get("http://localhost:8080/art-gallery");
    }

    @Then("I should see title and photo of all the artworks")
    public void i_should_see_title_and_photo_of_artworks() throws Throwable{
        List<String> titles = Arrays.asList("Title", "Art 1", "Art 2", "Art 3");
        List<String> images = Arrays.asList("src/test/java/A4/G2/model/artwork/testImage.png",
                "src/test/java/A4/G2/model/artwork/testImage1.png",
                "src/test/java/A4/G2/model/artwork/testImage2.png",
                "src/test/java/A4/G2/model/artwork/testImage3.png");
        this.artGalleryPage.checkArtworks(titles, images);
    }

    @Then("I should see title, photo, and sale type of all the artworks on sale")
    public void i_should_see_details_of_artworks_on_sale() throws Throwable{
        List<String> titles = Arrays.asList("Art 1", "Art 2");
        List<String> images = Arrays.asList("src/test/java/A4/G2/model/artwork/testImage1.png",
                "src/test/java/A4/G2/model/artwork/testImage2.png");
        List<String> ids = Arrays.asList("1", "2");
        List<String> saleTypes = Arrays.asList("Auction", "Buy Now");
        List<Double> prices = Arrays.asList(1.0, 2.0);
        this.artGalleryPage.checkArtworksOnSale(titles, images, saleTypes, prices);
    }

    @Then("I should see photo only of all the artworks")
    public void i_should_see_photo_only_of_artworks() throws Throwable{
        List<String> images = Arrays.asList("src/test/java/A4/G2/model/artwork/testImage.png",
                "src/test/java/A4/G2/model/artwork/testImage1.png",
                "src/test/java/A4/G2/model/artwork/testImage2.png",
                "src/test/java/A4/G2/model/artwork/testImage3.png");
        this.artGalleryPage.checkArtworksImage(images);
    }
}
