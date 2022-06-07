package A4.G2.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SignupPage {

    public SignupPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how= How.ID, using ="name")
    private WebElement userName;

    @FindBy(how=How.ID, using="password")
    private WebElement password;

    @FindBy(how=How.ID, using="retypedPassword")
    private WebElement retypedPassword;

    @FindBy(how=How.NAME, using="checkbox")
    private WebElement termsAccepted;

    @FindBy(how=How.ID, using="submitbtn")
    private WebElement submitButton;

    @FindBy(how=How.ID, using="error")
    private WebElement error;

    @FindBy(how=How.ID, using="message")
    private WebElement message;

    public void insertUserName(String userName){
        this.userName.sendKeys(userName);
    }

    public void insertPassword(String password){
        this.password.sendKeys(password);
    }

    public void insertRetypedPassword(String password){
        this.retypedPassword.sendKeys(password);
    }

    public void clickSignup(){
        this.submitButton.click();
    }

    public void clickConditions() {
        this.termsAccepted.click();
    }

    public String getErrorMessage() { return this.error.getText(); }

    public String getMessage(){
        return this.message.getText();
    }
}
