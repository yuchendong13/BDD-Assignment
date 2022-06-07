package A4.G2.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SuccessPage {

    public SuccessPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how= How.ID, using = "purchaseNotification")
    private WebElement purchaseNotification;

    public String purchaseConfirmationNotification() {return this.purchaseNotification.getText();}
}