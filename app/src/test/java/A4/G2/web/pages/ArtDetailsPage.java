package A4.G2.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ArtDetailsPage {

	public ArtDetailsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how=How.ID, using="loginButton")
	private WebElement loginButton;

	@FindBy(how=How.ID, using="shareButton")
	private WebElement shareButton;

	@FindBy(how=How.ID, using ="generatedLink")
	private WebElement generatedLink;

	@FindBy(how=How.ID, using ="buyNowButton")
	private WebElement buyNowButton;

	@FindBy(how=How.ID, using ="loginStatus")
	private WebElement loginStatus;

	@FindBy(how=How.ID, using ="loginNotification")
	private WebElement loginNotification;

	@FindBy(how=How.ID, using ="ageField")
	private WebElement ageField;

	@FindBy(how=How.ID, using ="ageNotification")
	private WebElement ageNotification;

	@FindBy(how=How.ID, using ="bidButton")
	private WebElement bidButton;


	public void clickLogin(){
		this.loginButton.click();
	}

	public void clickShare(){
		this.shareButton.click();
	}

	public String getGeneratedLink(){
		return this.generatedLink.getText();
	}

	public void clickBuyNow(){
		this.buyNowButton.click();
	}

	public void clickBid(){
		this.bidButton.click();
	}

	public String getLoginStatus(){
		return this.loginStatus.getText();
	}

	public String getLoginNotification(){
		return this.loginNotification.getText();
	}

	public void insertAge(String age){
		this.ageField.sendKeys(age);
	}

	public String getAgeNotification(){
		return this.ageNotification.getText();
	}

}