package testScripts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.Product;
import utilities.Constants;
import utilities.Launch;


public class TestScript1 extends Launch {

	WebDriver driver= getWebDriver();;
	HomePage homepage = new HomePage(driver);
	Product page=new Product(driver);
	
	/**
	 * Initializing browser and opening url
	 */
	public void openBrowser() 
	{
		initWebDriver();
		driver.get(Constants.URL);
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
