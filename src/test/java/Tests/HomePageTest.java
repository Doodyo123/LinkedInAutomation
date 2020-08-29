package Tests;

import org.junit.Assert;
import org.testng.annotations.Test;

import WebPages.HomePageObject;

import FileReader.ExcelReader;


public class HomePageTest extends LinkedInTestBase{
	
	// I want to be able to navigate to the home page of linkedin
	@Test
	public void canOpenHomePage() {
		
		String expectedUrl = "https://www.linkedin.com/home";
		
		HomePageObject homePage = new HomePageObject(driver, baseUrl);
		String currentUrl = homePage.navigate().getPageUrl();
		
		// Added thread sleep for display purposes only
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Assert.assertEquals(expectedUrl, currentUrl);
	}
	
	// I want to be able to login
	// and verify the user's name
	@Test
	public void canSignIn() {
		String expectedName = "Derick Ho";
		
		String email;
		String password;
		try {
			email = ExcelReader.getValue("email");
			password = ExcelReader.getValue("password");
			
			HomePageObject homePage = new HomePageObject(driver, baseUrl);
			
			String actualName = homePage
			.navigate()
			.inputEmail(email)
			.inputPassword(password)
			.getParentWindow()
			.clickSignInButton()
			.getAllWindows()
			.handleNewWindow();
			
			Assert.assertEquals(expectedName, actualName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
