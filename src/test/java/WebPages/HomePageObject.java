package WebPages;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageObject extends PageBase{
	
	@FindBy(css="input[id='session_key'][autocomplete='username']")
	private WebElement emailTextBox;
	@FindBy(css="input[id='session_password'][autocomplete='current-password']")
	private WebElement passwordTextBox;
	@FindBy(css="button[class='sign-in-form__submit-button']")
	private WebElement signInButton;
	
	private String parentWindowHandle;
	private Set<String> allWindowHandles;

	public HomePageObject(WebDriver driverInstance, String baseUrl) {
		super(driverInstance, baseUrl);
	}
	
	public HomePageObject navigate() {
		
		String url = "/home";
		Navigate(url);
		return this;
	}

	public String getPageUrl() {

		return getCurrentUrl();
		
	}
	
	public HomePageObject inputEmail(String email) {
		
		emailTextBox.sendKeys(email);
		return this;
		
	}
	
	public HomePageObject inputPassword(String password) {
		
		passwordTextBox.sendKeys(password);
		return this;
		
	}
	
	public HomePageObject clickSignInButton() {
		this.signInButton.click();
		return this;
	}
	
	public HomePageObject getParentWindow() {
		
		this.parentWindowHandle = driver.getWindowHandle();
		return this;
	}
	
	public HomePageObject getAllWindows() {
		
		this.allWindowHandles = driver.getWindowHandles();
		return this;
	}

	public String handleNewWindow() {

		for(String handle : allWindowHandles) {
			driver.switchTo().window(handle);
		}
		return driver.getCurrentUrl();
	}
	

}
