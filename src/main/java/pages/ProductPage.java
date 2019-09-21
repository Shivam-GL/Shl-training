package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.BaseClass;
import utilities.WaitExpectedConditions;

public class ProductPage extends BaseClass
{
	WebDriver driver;
	
	@FindBy(xpath = ("//span[contains(text(),'Featured')]"))
	WebElement Featured;
	@FindBy(xpath = ("((((((//span[contains(text(),'stars')])[1])/ancestor::a)//parent::span)//parent::div)//parent::div)//parent::div//a"))
	WebElement starProduct;
	
	public ProductPage(WebDriver driver) 
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void hoverAction()
	{
		moveToElement_ByAction(Featured);
		WebElement selectMenuOption=waitCondition(WaitExpectedConditions.PRESENCE_OF_ELEMENT,By.xpath("//a[contains(text(),'Price: Low to High')]"), 10);
		clickBtn(selectMenuOption);
	}
	public void findProduct()
	{
		clickBtn(starProduct);
	}
	

}
