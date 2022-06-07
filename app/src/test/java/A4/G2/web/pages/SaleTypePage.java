package A4.G2.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SaleTypePage {

    public SaleTypePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how=How.ID, using="sales")
    private WebElement sales;

    @FindBy(how= How.ID, using ="min")
    private WebElement minPrice;

    @FindBy(how=How.ID, using="max")
    private WebElement maxPrice;

    @FindBy(how= How.ID, using ="hour")
    private WebElement hour;

    @FindBy(how=How.ID, using="minute")
    private WebElement minute;

    @FindBy(how=How.ID, using="higher")
    private WebElement higherTimeRadioButton;

    @FindBy(how=How.ID, using="lower")
    private WebElement lowerTimeRadioButton;

    @FindBy(how=How.ID, using="submitTimeBtn")
    private WebElement submitTimeButton;

    @FindBy(how=How.ID, using="submitPriceBtn")
    private WebElement submitPriceButton;

    public void insertMinimumPrice(int i) {
        this.minPrice.sendKeys(i + "");
    }

    public void insertMaximumPrice(int i) {
        this.maxPrice.sendKeys(i + "");
    }

    public void clickFilterByPriceButton() {
        this.submitPriceButton.click();
    }

    public void selectLessThanTimeRemainingOption() {
        this.lowerTimeRadioButton.click();
    }

    public void selectMoreThanTimeRemainingOption() { this.higherTimeRadioButton.click(); }

    public void insertHour(int hour) {
        this.hour.sendKeys(hour + "");
    }

    public void insertMinute(int minute) {
        this.minute.sendKeys(minute + "");
    }

    public void clickFilterByTimeButton() {
        this.submitTimeButton.click();
    }
}
