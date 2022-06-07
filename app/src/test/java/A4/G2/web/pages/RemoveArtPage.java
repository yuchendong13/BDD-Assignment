package A4.G2.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.Collection;

public class RemoveArtPage {
    public RemoveArtPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.ID, using = "idToRemove")
    private WebElement removeId;

    @FindBy(how = How.ID, using = "submitItToBeRemove")
    private WebElement submitButton;

    @FindBy(how = How.ID, using = "backToGallery")
    private WebElement backToGalleryButton;

    @FindBy(how = How.ID, using = "message")
    private WebElement message;

    @FindBy(how = How.ID, using = "errorMessage")
    private WebElement errorMessage;


    public void insertIdToRemove(String idToRemove) {
        this.removeId.sendKeys(idToRemove);
    }

    public String getMessage() {
        return this.message.getText();
    }

    public void clickSubmit() {
        submitButton.click();
    }

    public String getErrorMessage() {
        return this.errorMessage.getText();
    }

    public void clickBackToGallery() {
        backToGalleryButton.click();
    }
}
