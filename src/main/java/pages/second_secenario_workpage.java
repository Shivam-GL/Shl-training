package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import utilities.BaseClass;
import utilities.WaitExpectedConditions;

public class second_secenario_workpage extends BaseClass
{
	WebDriver driver;
	
	
	public second_secenario_workpage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}

	public void remove_login_popup() 
	{
		escbutton();
	}
	public void open_camera()
	{
		Actions actions = new Actions(driver);
		// .//span[contains(text(),'Electronics')]
		// Compact & Bridge Cameras
		WebElement menuOption = driver.findElement(By.xpath(".//span[contains(text(),'Electronics')]"));
		actions.moveToElement(menuOption).perform();
		WebElement selectMenuOption=waitCondition(WaitExpectedConditions.PRESENCE_OF_ELEMENT,By.xpath("//*[text()='Compact & Bridge Cameras']"), 10);
		
		selectMenuOption.click();
	}
	public void compare(int i)
	{
		for(int x=1;x<=i;x++)
		{
			waitCondition(WaitExpectedConditions.ELEMENT_TO_BE_CLICKABLE,By.xpath("(//span[text()='Add to Compare'])["+x+"]"), 10).click();
			
		}
		driver.findElement(By.xpath("//span[text()='COMPARE']")).click();
	}
	public void check(int number)
	{
		waitCondition(WaitExpectedConditions.PRESENCE_OF_ELEMENT,By.xpath("//div[@title='Remove Product']"), 10);
		List<WebElement> lst=driver.findElements(By.xpath("//div[@title='Remove Product']"));
		int count_compare=lst.size();
		if(count_compare==number)
			System.out.println("correctly compared");
		else
			System.out.println("Incorrectly compared");
	}
	public int minimum_price(int number)
	{
		int min=99999;
		int index=0;
		for(int x=1;x<=number;x++)
		{
			String price=waitCondition(WaitExpectedConditions.PRESENCE_OF_ELEMENT,By.xpath("(//div[@class='_1vC4OE'])["+x+"]"), 10).getText();
			String new_price=price.substring(1);
			int i=Integer.parseInt(new_price.replace(",",""));
			if(i<min)
			{
				min=i;
				index=x;
			}
			
		}
		return index;
	}
	public void product_wanted(int number)
	{
		int index=minimum_price(number);
		String product_name=driver.findElement(By.xpath("(//div[@class='row']//a)["+index+"]")).getText();
		String price=driver.findElement(By.xpath("(//div[@class='_1vC4OE'])["+index+"]")).getText();
		//xpath of minimum element=(//div[@class='row']//a)[3]
		System.out.println("Product name: "+product_name);
		System.out.println("Product price: "+price);
	}
	
}
