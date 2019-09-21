package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.BaseClass;

public class AmazonFinalPage extends BaseClass
{
	WebDriver driver;
	
	@FindBy(xpath = ("//span[contains(text(),'customer reviews')]"))
	WebElement reviews;
	
	public AmazonFinalPage(WebDriver driver) 
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void knowReview()
	{
		
		clickBtn(reviews);
	}
	
	
}
