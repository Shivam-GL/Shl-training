package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import utilities.BaseClass;
import utilities.ProductDetails;



public class ProductSearchPage extends BaseClass {


	WebDriver driver;
	String star;
	String rating;
	int highestRating=0;
	String highestRatingString;
	int currentRating;


	@FindBy (xpath="//div[@data-id]//span[contains(text(),'(')]")
	List<WebElement> productRating;

	@FindBy(xpath="//div[@data-id]//div//a//div//div[2]//div//div//input")
	List<WebElement> addToCompare;

	ProductDetails product;
	ArrayList<WebElement> highestRatedProduct;


	public ProductSearchPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		AjaxElementLocatorFactory factory=new AjaxElementLocatorFactory(driver,100);
		PageFactory.initElements(factory, this);
		highestRatedProduct=new ArrayList<WebElement>();
	}

	public void getProducts() {
		getHighestCurrentRating();
		highestRatedProduct=(ArrayList<WebElement>) driver.findElements(By.xpath("//span[contains(text(),'"+highestRatingString+"')]"));
		for(WebElement highestRating:highestRatedProduct) {
			System.out.println(highestRating.findElement(By.xpath("./parent::div/preceding-sibling::a[1]")).getText());
			System.out.println(highestRating.findElement(By.xpath("./preceding-sibling::span")).getText());
			System.out.println(highestRatingString);
		}

	}

	//function to get the highest product rating 
	public void getHighestCurrentRating() {
		for(WebElement prod:productRating) {
			String currentratingString;
			rating=prod.getText();
			currentratingString= rating.replaceAll("\\p{P}","").replaceAll(",","");
			currentRating=Integer.parseInt(currentratingString);
			if(currentRating>highestRating) {
				highestRating=currentRating;
				highestRatingString=rating;
				
			}
		}
	}
}
