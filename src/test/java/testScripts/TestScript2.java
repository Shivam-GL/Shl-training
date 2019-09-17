package testScripts;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductSearchPage;
import utilities.Constants;
import utilities.Launch;
import utilities.ProductDetails;

public class TestScript2 extends Launch {
	WebDriver driver;
	HomePage homepage;
	@BeforeMethod
	public void initBrowser() {
		//managing driver
		driver=getWebDriver();
		driver.get(Constants.URL);
		driver.manage().window().maximize();
		// initializing page objects
		homepage=new HomePage(driver);
		
	}
	
	@Test
	public void test1() {
		homepage.closeModal();
		homepage.hoverActions();
		
	}
}
