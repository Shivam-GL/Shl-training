package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.BaseClass;

public class HomePage extends BaseClass{
	WebDriver driver;
	
	@FindBy (xpath="//button[@class=\"_2AkmmA _29YdH8\"]")
	WebElement modalClosebtn;
	
	@FindBy (xpath="//input[@placeholder=\"Search for products, brands and more\"]")
	WebElement productSearchBox;
	
	@FindBy (xpath="//button[@class=\"vh79eN\"]")
	WebElement searchBtn;
	
	@FindBy(xpath="//*[text()=\"Electronics\"]")
	WebElement hoverTo;
	
	@FindBy(xpath="//*[text()=\"Compact & Bridge Cameras\"]")
	WebElement clickTo;
	
	
	public HomePage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void closeModal() {
		clickBtn(modalClosebtn);
	}
	
	public void searchProduct(String productName) {
		enterInput(productSearchBox,productName);
		clickBtn(searchBtn);
		
	}
	
	public void hoverActions() {
		hoverAndClick(hoverTo);
		clickBtn(clickTo);
	}

}
