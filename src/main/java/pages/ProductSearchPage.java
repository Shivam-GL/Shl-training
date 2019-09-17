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
import utilities.WaitExpectedConditions;

public class ProductSearchPage extends BaseClass {


	WebDriver driver;
	String star;
	String review;
	int highestRating=0;
	int currentRating;
	
	
	@FindBy (xpath="//div[@data-id]")
	List<WebElement> products;

	ProductDetails product;
	ArrayList<ProductDetails> productDetails;


	public ProductSearchPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		AjaxElementLocatorFactory factory=new AjaxElementLocatorFactory(driver,100);
		PageFactory.initElements(factory, this);
		productDetails=new ArrayList<ProductDetails>();
	}

	public ArrayList<ProductDetails> getProducts() {

		for(WebElement prod:products) {
			setCurrentRating(prod);
			if (productDetails.size()==0) {
				highestRating=currentRating;
				addProductToList(prod,currentRating);
			}
			else if(currentRating>highestRating) {
				productDetails.clear();
				highestRating=currentRating;
				addProductToList(prod,currentRating);
			}
			
			else if(currentRating==highestRating) {
				
				addProductToList(prod,highestRating);
			}
			
		}
		
		return productDetails;
	}
	
	//function to add product to list
	public void addProductToList(WebElement prod,int currentRating) {
		product=new ProductDetails();
		product.setRatings(currentRating);
		//enter star rating
		try {
		star = prod.findElement(By.xpath(".//div[@class=\"hGSR34\"]")).getText();
		star=star.replaceAll("\"","");
		product.setStar(Float.parseFloat(star));
		}
		catch(Exception e) {
			product.setStar(0);
		}
		//enter name
		product.setPrdoname(prod.findElement(By.xpath("div/a[2]")).getText());
		// adding product to list
		
		productDetails.add(product);
	}
	
	
	//function to set the product rating as current rating
	public void setCurrentRating(WebElement prod) {
		try {
			
			review=prod.findElement(By.xpath(".//span[@class=\"_38sUEc\"]")).getText();
			review= review.replaceAll("\\p{P}","").replaceAll(",","");
			currentRating=Integer.parseInt(review);
			
		}
		catch(Exception e) {
			currentRating=0;
			product.setRatings(currentRating);
		}
		
		
	}

}
