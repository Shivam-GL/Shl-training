package testScripts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.AmazonHomePage;
import utilities.Constants;
import utilities.Launch;

public class Testscript4 extends Launch{
  private WebDriver driver;
  private AmazonHomePage homepage;
  @BeforeMethod
	public void initBrowser() {
		//fetching driver
		driver=getWebDriver();
		goToUrl(Constants.URL2);
		// initializing page objects
		homepage=new AmazonHomePage(driver);
		
	}

	@Test
	public void test1() {
		
		homepage.searchProduct("mobile");
		homepage.selectCategory();
		homepage.sortBy();
		homepage.getstarvalue();
	}
}
