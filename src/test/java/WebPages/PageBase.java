package WebPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public abstract class PageBase {

	protected WebDriver driver;
	protected String baseUrl;
	
	protected PageBase(WebDriver driverInstance, String baseUrl) {
		
		this.driver = driverInstance;
		PageFactory.initElements(driver, this);
		this.baseUrl = baseUrl;
	}
	
	protected void Navigate(String url) {
		
		driver.navigate().to(this.baseUrl+url);
	}
	
	protected Select getSelect(WebElement element) {
		
		return new Select(element);
	}
	
	protected String getCurrentUrl() {
		
		return driver.getCurrentUrl();
		
	}
}
