package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import logs.CreateLog;
import utilities.BaseClass;
import utilities.WaitExpectedConditions;
public class Comparision extends BaseClass 
{
	WebDriver driver;
	CreateLog log=new CreateLog();
	public Comparision(WebDriver driver) 
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	
	/**For Checking weather three elements were selected or not
	 * 
	 * @param number::No. elements that has to be selected
	 */
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

	/**For Calculating the minimum price among the comparision
	 * 
	 * @param number::the no of items that will be compared
	 * @return::the index value of that item which has lowest value 
	 */
	public int minimum_Price(int number)
	{
		String first_price=waitCondition(WaitExpectedConditions.PRESENCE_OF_ELEMENT,By.xpath("(//div[@class='row'][2]//div[contains(text(),'₹')][1])[1]"), 10).getText();
		String fnew_price=first_price.substring(1);
		int min=Integer.parseInt(fnew_price.replace(",",""));
		int index=1;
		for(int x=2;x<=number;x++)
		{
			String price=waitCondition(WaitExpectedConditions.PRESENCE_OF_ELEMENT,By.xpath("(//div[@class='row'][2]//div[contains(text(),'₹')][1])["+x+"]"), 10).getText();
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

	/**Finally printing in log result
	 * 
	 * @param number::index of the item which has lowest value
	 */
	public void product_Wanted(int number)
	{
		int index=minimum_Price(number);
		String product_name=driver.findElement(By.xpath("(//div[@class='row']//a)["+index+"]")).getText();
		String price=driver.findElement(By.xpath("(//div[@class='row'][2]//div[contains(text(),'₹')][1])["+index+"]")).getText();
		log.writeLog("Product name: ", product_name);
		log.writeLog("Product price: ", price);
	}

}
