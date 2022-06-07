package A4.G2.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how= How.ID, using="login")
    private WebElement loginButton;

    @FindBy(how= How.ID, using="signup")
    private WebElement signupButton;

    @FindBy(how= How.ID, using="manage-account")
    private WebElement manageAccountButton;

    public void clickLoginNavButton(){
        this.loginButton.click();
    }

    public void clickSignupNavButton() { this.signupButton.click(); }

    public void clickManageAccountButton() { this.manageAccountButton.click(); }
}
