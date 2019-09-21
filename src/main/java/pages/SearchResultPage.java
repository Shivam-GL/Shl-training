package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.BaseClass;

public class SearchResultPage extends BaseClass
{
	WebDriver driver;
	
	@FindBy(xpath = ("//span[contains(text(),'Smartphones')]"))
	WebElement search_term;
	
	
	public SearchResultPage(WebDriver driver) 
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickbtn()
	{
		clickBtn(search_term);
	}
	
	
	
}
