package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BaseClass;
import utilities.WaitExpectedConditions;

public class Second_Secenario_Workpage extends BaseClass
{
	WebDriver driver;
	@FindBy(xpath=(".//span[contains(text(),'Electronics')]"))
	WebElement menuOption;

	public Second_Secenario_Workpage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);

	}

	/**For removing the login pop up launched after opening website
	 * 
	 */
	public void remove_Login_Popup() 
	{
		escButton();
	}

	/**For opening camera as designated in scenario
	 * 
	 */
	public void open_Camera()
	{
		actions(menuOption);
		WebElement selectMenuOption=waitCondition(WaitExpectedConditions.PRESENCE_OF_ELEMENT,By.xpath("//*[text()='Compact & Bridge Cameras']"), 10);
		selectMenuOption.click();
	}

	


	
}
