package A4.G2.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class PricePage {

    public PricePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how= How.ID, using="sales")
    private WebElement sales;

    public void checkAllInPriceRangeDisplayed(List<String> titles) {
        for (String title:titles) {
            assertTrue(sales.getText().contains(title));
        }
    }
}
