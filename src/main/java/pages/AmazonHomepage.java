package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.BaseClass;

public class AmazonHomepage extends BaseClass
{
	WebDriver driver;
	
	@FindBy(xpath = ("//input[contains(@id,'twotabsearchtextbox')]"))
	WebElement search_box;
	@FindBy(xpath = ("//span[contains(@id,'nav-search-submit-text')]//following::input"))
	WebElement search_btn;

	
	
	public AmazonHomepage(WebDriver driver) 
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	/**
	 * For Entering the input in the search box
	 * 
	 * @param search_term: text to enter
	 */
	public void enter_Input(String search_term) {
		enterInput(search_box, search_term);
		clickBtn(search_btn);

	}

	
}
