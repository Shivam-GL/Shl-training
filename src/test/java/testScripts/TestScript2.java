package testScripts;



import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.ComparePage;
import pages.HomePage;

import utilities.Constants;
import utilities.Launch;


public class TestScript2 extends Launch {
	WebDriver driver;
	HomePage homepage;
	ComparePage comparePage;
	@BeforeMethod
	public void initBrowser() {
		//fetching driver
		driver=getWebDriver();
		// initializing page objects
		homepage=new HomePage(driver);
		comparePage=new ComparePage(driver);

	}

	
	@Test
	public void test1() {
		homepage.closeModal();
		homepage.hoverActions();
		comparePage.addToCompare(3);
		comparePage.getMinPrice();
	}
}
