package testScripts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.AmazonFinalPage;
import pages.AmazonHomepage;
import pages.ProductPage;
import pages.SearchResultPage;
import utilities.Constants;
import utilities.Launch;

public class TestScript3 extends Launch
{
	WebDriver driver;
	AmazonHomepage homepage;
	SearchResultPage resultPage;
	ProductPage page;
	AmazonFinalPage finalPage;
	@BeforeClass
	public void openBrowser() 
	{
		initWebDriver();
		driver= getWebDriver();
		driver.get(Constants.URL);
		homepage = new AmazonHomepage(driver);
		resultPage= new SearchResultPage(driver);
		page=new ProductPage(driver);
		finalPage=new AmazonFinalPage(driver);
	}
	
	@Test
	public void test3()
	{
		homepage.enter_Input(Constants.search_term);
		resultPage.clickbtn();
		page.hoverAction();
		page.findProduct();
		finalPage.knowReview();
	}
	
}
