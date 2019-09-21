package testScripts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.Product;
import utilities.Constants;
import utilities.Launch;


public class TestScript1 extends Launch {

	WebDriver driver;
	HomePage homepage;
	Product page;
	
	/**
	 * Initializing browser and opening url
	 */
	@BeforeClass
	public void openBrowser() 
	{
		initWebDriver();
		driver = getWebDriver();
		driver.get(Constants.URL);
		homepage = new HomePage(driver);
		page=new Product(driver);
	}

	/**For First Secenario
	 * 
	 */
	@Test
	public void test1() 
	{
		
		homepage.remove_Login_Popup();
		homepage.enter_Input(Constants.search_term);
		homepage.clck_Searchbtn();
		page.print_Product();
		

	}
}
