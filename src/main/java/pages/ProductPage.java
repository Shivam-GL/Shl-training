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
	@FindBy(xpath = ("(((((((//span[contains(text(),'stars')])[1])/ancestor::a)//parent::span)//parent::div)//parent::div)//parent::div//a[@class])[1]"))
	WebElement starProduct;
	@FindBy(xpath = ("//a[contains(text(),'Price: Low to High')]"))
	WebElement selectMenuOption;
	
	public ProductPage(WebDriver driver) 
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void hoverAction()
	{
		waitCondition(WaitExpectedConditions.PRESENCE_OF_ELEMENT,By.xpath("//span[contains(text(),'Featured')]"),10);
		clickBtn(Featured);
		waitCondition(WaitExpectedConditions.PRESENCE_OF_ELEMENT,By.xpath("//a[contains(text(),'Price: Low to High')]"), 10);
		clickBtn(selectMenuOption);
		driver.manage().window().maximize();
		
	}
	public void findProduct()
	{
		String winHandleBefore = driver.getWindowHandle();
		waitCondition(WaitExpectedConditions.PRESENCE_OF_ELEMENT,By.xpath("(((((((//span[contains(text(),'stars')])[1])/ancestor::a)//parent::span)//parent::div)//parent::div)//parent::div//a[@class])[1]"), 20);
		Scroll_Click(starProduct);
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		}
	}
	

}
