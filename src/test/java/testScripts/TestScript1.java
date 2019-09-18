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

public class TestScript1 extends Launch{

	WebDriver driver;
	HomePage homepage;

	ProductSearchPage productsearchpage;
	ArrayList<ProductDetails> details;

	@BeforeMethod
	public void initBrowser() {
		//fetching driver
		driver=getWebDriver();
		// initializing page objects
		homepage=new HomePage(driver);
		productsearchpage=new ProductSearchPage(driver);
	}

	@Test
	public void test1() {
		homepage.closeModal();
		homepage.searchProduct("earphones");
		productsearchpage.getProducts();

	}
}
