package A4.G2.web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class AddArtPage {

    public AddArtPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.ID, using = "title")
    private WebElement title;

    @FindBy(how = How.ID, using = "description")
    private WebElement description;

    @FindBy(how = How.ID, using = "artType")
    private WebElement artType;

    @FindBy(how = How.ID, using = "artistName")
    private WebElement artistName;

    @FindBy(how = How.ID, using = "fileOfImage")
    private WebElement image;

    @FindBy(how = How.ID, using = "dimensions")
    private WebElement dimensions;

    @FindBy(how = How.ID, using = "buyNowPrice")
    private WebElement buyNowPrice;

    @FindBy(how = How.ID, using = "auctionStartPrice")
    private WebElement auctionStartPrice;

    @FindBy(how = How.ID, using = "auctionReservePrice")
    private WebElement auctionReservePrice;

    @FindBy(how = How.ID, using = "auctionTimeRemaining")
    private WebElement auctionTimeRemaining;

    @FindBy(how = How.ID, using = "addArtBtn")
    private WebElement addArtButton;

    @FindBy(how = How.ID, using = "submitNewArtBtn")
    private WebElement submitNewArtButton;

    @FindBy(how = How.ID, using = "message")
    private WebElement message;

    @FindBy(how = How.ID, using = "errorMessage")
    private WebElement errorMessage;

    public void insertTitle(String title) {
        this.title.sendKeys(title);
    }

    public void insertDescription(String description) {
        this.description.sendKeys(description);
    }

    public void insertDimension(String dimensions) {
        this.dimensions.sendKeys(dimensions);
    }

    public void selectArtType(String artType) {
        this.artType.click();
        List<WebElement> l = this.artType.findElements(By.cssSelector("option"));
        WebElement optionElement = l.get(Integer.parseInt(artType));
        if (optionElement == null) {
            // optionally throw error
            return;
        }
        optionElement.click();
    }

    public void insertArtistName(String name) {
        this.artistName.sendKeys(name);
    }

    public void insertImage(String imageFile) {
        this.image.sendKeys(imageFile);
    }

    public void insertBuyNowPrice(String buyNowPrice) {
        this.buyNowPrice.sendKeys(buyNowPrice);
    }
    public void insertAuctionStartPrice(String auctionStartPrice) {
        this.auctionStartPrice.sendKeys(auctionStartPrice);
    }

    public void insertAuctionReservePrice(String auctionReservePrice) {
        this.auctionReservePrice.sendKeys(auctionReservePrice);
    }

    public void insertAuctionTimeRemaining(String auctionTimeRemaining) {
        this.auctionTimeRemaining.sendKeys(auctionTimeRemaining);
    }

    public void clickSubmit() {
        this.submitNewArtButton.click();
    }

    public String getMessage() {
        return this.message.getText();
    }

    public String getErrorMessage(){
        return this.errorMessage.getText();
    }
}
