package WebPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LinkedInFeedPageObject extends PageBase{

	@FindBy(css="div[class='profile-rail-card__actor-link t-16 t-black t-bold']")
	private WebElement nameText;
	
	public LinkedInFeedPageObject(WebDriver driverInstance, String baseUrl) {
		super(driverInstance, baseUrl);
		// TODO Auto-generated constructor stub
	}
	
	public LinkedInFeedPageObject Navigate() {
		
		String url = "/feed";
		Navigate(url);
		return this;
	}
	
	public String getUserName() {
		
		return nameText.getText();
	}

}
