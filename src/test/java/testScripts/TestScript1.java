package testScripts;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import pages.HomePage;
import pages.ProductSearchPage;
import utilities.Constants;
import utilities.Launch;


public class TestScript1 extends Launch{

	WebDriver driver;
	HomePage homepage;

	ProductSearchPage productsearchpage;

	@BeforeMethod
	public void initBrowser() {
		//fetching driver
		driver=getWebDriver();
		goToUrl(Constants.URL);
		// initializing page objects
		homepage=new HomePage(driver);
		productsearchpage=new ProductSearchPage(driver);
	}

	@Test
	public void test1(Method method) {
		homepage.closeModal();
		homepage.searchProduct("earphones");
		method.getName();
		productsearchpage.getProducts();

	}
}
