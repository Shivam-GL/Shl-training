package utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {
	
	WebDriver driver;
	Logger log;
	
	public BaseClass(WebDriver driver) {
		this.driver=driver;
	}
	
	/**For Clicking any button
	 * 
	 * @param button:: WebElement needed
	 */
	public void clickBtn(WebElement button) {
		 button.click();
	}
	
	/**For sending input to any field
	 * 
	 * @param inputField::WebElement
	 * @param inputValue::Value that has to be sent to that webelement
	 */
	public void enterInput(WebElement inputField,String inputValue) {
		inputField.sendKeys(inputValue);
	}
	
	/**For clearing text out of  any field
	 * 
	 * @param inputField::WebElement from where the txt has to be cleared
	 */
	public void clearText(WebElement inputField) {
		inputField.clear();
	}
	
	/**For Scrolling the window downside
	 * 
	 */
	public void Scroll() {
		 JavascriptExecutor js=(JavascriptExecutor)driver;
		 js.executeScript("window.scrollBy(0,1000)");
	}
	
	/**For Clicking the escape button to remove the pop-up
	 * 
	 */
	public void escButton()
	{
		Robot robot;
		try {
			robot = new Robot();
			robot.keyPress(KeyEvent.VK_ESCAPE);
			 robot.keyRelease(KeyEvent.VK_ESCAPE);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * For Actions to mouse hovering
	 * @param req::WebElement
	 */
	public void actions(WebElement req)
	{
		Actions actions = new Actions(driver);
		actions.moveToElement(req).perform();
	}
	
	/**For wait at any moment required
	 * 
	 * @param conditions::condition that is required
	 * @param locator::exactly where to we require wait
	 * @param timeOut::no of seconds required
	 * @return
	 */
	public WebElement waitCondition(WaitExpectedConditions conditions,By locator,int timeOut) 
	{
		WebDriverWait wait=new WebDriverWait(driver,timeOut);
		WebElement wb = null;
		switch (conditions)
		{
		case PRESENCE_OF_ELEMENT:
							wb= wait.until(ExpectedConditions.presenceOfElementLocated(locator));
							break;
		case ELEMENT_TO_BE_CLICKABLE: 
							wb=wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
						  break;	
		}
		return wb;
	}
	
	
	
}
