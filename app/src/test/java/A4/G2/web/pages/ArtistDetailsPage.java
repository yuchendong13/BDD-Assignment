package A4.G2.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ArtistDetailsPage {

	public ArtistDetailsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how=How.ID, using="shareArtistButton")
	private WebElement shareArtistButton;

	@FindBy(how=How.ID, using ="generatedArtistLink")
	private WebElement generatedArtistLink;

	public void clickShare(){
		this.shareArtistButton.click();
	}

	public String getGeneratedArtistLink(){
		return this.generatedArtistLink.getText();
	}



}