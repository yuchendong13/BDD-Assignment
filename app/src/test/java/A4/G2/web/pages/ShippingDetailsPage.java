package A4.G2.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ShippingDetailsPage {

    public ShippingDetailsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how=How.ID, using="address")
    private WebElement address;

    @FindBy(how=How.ID, using="submit")
    private WebElement submit;

    public void clickSubmit(){
        this.submit.click();
    }

    public String getAddress(){
        return this.address.getText();
    }

    public void insertAddress(String address){
        this.address.sendKeys(address);
    }



}