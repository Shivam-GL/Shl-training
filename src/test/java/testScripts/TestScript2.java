package testScripts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.Camera_Product;
import pages.Comparision;
import pages.Second_Secenario_Workpage;
import utilities.Constants;
import utilities.Launch;

public class TestScript2 extends Launch{
	
	WebDriver driver= getWebDriver();
	Second_Secenario_Workpage workpage=new Second_Secenario_Workpage(driver);;
	Camera_Product product=new Camera_Product(driver);;
	Comparision newpage=new Comparision(driver);;

	
	public void initBrowser() 
	{
		initWebDriver();
		driver.get(Constants.URL);
	}

	@Test
	public void test2() 
	{
		
		workpage.remove_Login_Popup();
		workpage.open_Camera();
		product.compare(3);
		newpage.check(3);
		newpage.product_Wanted(3);
	}
	
}
