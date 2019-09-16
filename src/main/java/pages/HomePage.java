package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.BaseClass;
import utilities.WaitExpectedConditions;

public class HomePage extends BaseClass{
	WebDriver driver;
	
	
	@FindBy(xpath=("//input[@class='LM6RPg']"))
	WebElement search_box;
	@FindBy(xpath=("//button[@class='vh79eN']"))
	WebElement search_btn;
	
	
	
	public HomePage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void remove_login_popup() 
	{
		escbutton();
	}
	public void enter_input(String search_term)
	{
		enterInput(search_box,search_term);
		
	}
	public void clck_searchbtn()
	{
		clickBtn(search_btn);
	}
	public void print()
	{
		waitCondition(WaitExpectedConditions.PRESENCE_OF_ELEMENT, By.xpath("//span[@class='_38sUEc']"), 10);
		
		 List<WebElement> lstdrp=driver.findElements(By.xpath("//span[@class='_38sUEc']/child::span/child::span[1]"));
		 int highest_rating=0;
		 String finded_string="";
		 for(WebElement element:lstdrp)
		 {
		String s=element.getText();
		String b=s.split(" ")[0];
		 int ratings=Integer.parseInt(b.replaceAll(",",""));
		 if(ratings>=highest_rating)
		 {
			 highest_rating=ratings;
			 finded_string=b;
		 }
		 else
			 continue;
		 }
		 
		 String name=driver.findElement(By.xpath("//span[contains(text(),'"+finded_string+"')]/../../../../*[@class='_3wU53n']")).getText();
			String rating=driver.findElement(By.xpath("//span[contains(text(),'"+finded_string+"')]/../../../..//div[@class='hGSR34']")).getText();
			System.out.println("Mobile Name:   "+name);
			System.out.println("Mobile rating:   "+rating);
			 
			 //Element Name of the mobile//span[contains(text(),'3,24,964')]/../../../../*[@class='_3wU53n']
			 //element of star rating//span[contains(text(),'3,24,964')]/../../.././/div[@class='hGSR34']
	}
	
}
