package testScripts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.Camera_Product;
import pages.Comparision;
import pages.HomePage;
import pages.Product;
import pages.Second_Secenario_Workpage;
import utilities.Constants;
import utilities.Launch;


public class TestScript1 extends Launch {

	WebDriver driver;
	HomePage homepage;
	Second_Secenario_Workpage workpage;
	Product page;
	Camera_Product product;
	Comparision newpage;

	@BeforeMethod
	public void initBrowser() 
	{
		driver = getWebDriver();
		homepage = new HomePage(driver);
		workpage=new Second_Secenario_Workpage(driver);
		page=new Product(driver);
		product=new Camera_Product(driver);
		newpage=new Comparision(driver);
	}

	/**For First Secenario
	 * 
	 */
	@Test
	public void test1() 
	{
		driver.get(Constants.URL);
		homepage.remove_Login_Popup();
		homepage.enter_Input(Constants.search_term);
		homepage.clck_Searchbtn();
		page.print_Product();
		

	}

	/**For Second Secenario
	 * 
	 */
	@Test
	public void test2() 
	{
		driver.get(Constants.URL);
		workpage.remove_Login_Popup();
		workpage.open_Camera();
		product.compare(3);
		newpage.check(3);
		newpage.product_Wanted(3);
	}
}
