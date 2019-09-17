package utilities;

import org.openqa.selenium.WebDriver;

import pages.HomePage;
import pages.ProductSearchPage;

public class PageObjectManager {

	private WebDriver driver;
	private HomePage homePage;
	private ProductSearchPage productSearchPage;
	
	public PageObjectManager(WebDriver driver) {
		 this.driver = driver;
	}
	
	public HomePage getHomePage() {
		return (homePage==null)?homePage=new HomePage(driver):homePage;
	}
	
	public ProductSearchPage getProductSearchPage() {
		return (productSearchPage==null)?productSearchPage=new ProductSearchPage(driver):productSearchPage;
	}
	
}
