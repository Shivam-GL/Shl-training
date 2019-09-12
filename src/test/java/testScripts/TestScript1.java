package testScripts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import pages.HomePage;
import utilities.Constants;
import utilities.Launch;
import utilities.PageObjectManager;

public class TestScript1 extends Launch{
	
	WebDriver driver;
	HomePage homepage;
	PageObjectManager pageobjectmanager;

@BeforeMethod
public void initBrowser() {
	driver=getWebDriver();
	driver.get(Constants.URL);
	pageobjectmanager = new PageObjectManager(driver);
}
	
@Test
  public void test1() {
	 System.out.println("test"); 
	homepage=pageobjectmanager.getHomePage();
  }
}
