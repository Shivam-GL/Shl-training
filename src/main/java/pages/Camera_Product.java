package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import utilities.BaseClass;
import utilities.WaitExpectedConditions;

public class Camera_Product extends BaseClass
{
	WebDriver driver;
	public Camera_Product(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	/**For selecting the first three camera for comparision
	 *  
	 * @param i::No.of elements that has to be compared
	 */
	public void compare(int i)
	{
		
		for(int x=1;x<=i;x++)
		{
			waitCondition(WaitExpectedConditions.ELEMENT_TO_BE_CLICKABLE,By.xpath("(//span[text()='Add to Compare'])["+x+"]"), 10);
			driver.findElement(By.xpath("(//span[text()='Add to Compare'])["+x+"]")).click();
		}
		driver.findElement(By.xpath("//span[text()='COMPARE']")).click();
	}
}
