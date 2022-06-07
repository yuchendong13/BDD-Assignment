package A4.G2.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.Collection;


public class EditArtPage {

    public EditArtPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.ID, using = "editTitle")
    private WebElement editTitle;

    @FindBy(how = How.ID, using = "editDescription")
    private WebElement editDescription;

    @FindBy(how = How.ID, using = "editDimensions")
    private WebElement editDimensions;
    @FindBy(how = How.ID, using = "editSubmit")
    private WebElement editSubmitBtn;
    @FindBy(how = How.ID, using = "message")
    private WebElement message;

    @FindBy(how = How.ID, using = "artDetailButton")
    private WebElement artDetailButton;

    @FindBy(how=How.ID, using = "errorMessage")
    private WebElement errorMessage;


    public void insertNewTitle(String string) {
        editTitle.clear();
        editTitle.sendKeys(string);
    }

    public void clickSubmit() {
        editSubmitBtn.click();
    }

    public String getMessage() {
        return this.message.getText();
    }

    public void clickGoBackToArtDetail() {
        artDetailButton.click();
    }

    public void insertNewDescription(String string) {
        editDescription.clear();
        editDescription.sendKeys(string);
    }

    public void insertNewDimensions(String string) {
        editDimensions.clear();
        editDimensions.sendKeys(string);
    }

    public String getErrorMessage() {
        return this.errorMessage.getText();
    }
}
