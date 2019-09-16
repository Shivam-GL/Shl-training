package utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {
	
	WebDriver driver;
	
	public BaseClass(WebDriver driver) {
		this.driver=driver;
	}
	public void clickBtn(WebElement button) {
		 button.click();
	}
	public void enterInput(WebElement inputField,String inputValue) {
		inputField.sendKeys(inputValue);
	}
	public void clearText(WebElement inputField) {
		inputField.clear();
	}
	//public WebElement find-element(String)
	
	public void Scroll() {
		 JavascriptExecutor js=(JavascriptExecutor)driver;
		 js.executeScript("window.scrollBy(0,1000)");
	}
	public void escbutton()
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
		public WebElement waitCondition(WaitExpectedConditions conditions,By locator,int timeOut) {
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
