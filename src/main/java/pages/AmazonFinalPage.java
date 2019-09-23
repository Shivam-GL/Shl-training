package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import logs.CreateLog;
import utilities.BaseClass;
import utilities.WaitExpectedConditions;

public class AmazonFinalPage extends BaseClass
{
	WebDriver driver;
	CreateLog log;
	String five;
	String four;
	String three;
	String two;
	String one;
	
	
	@FindBy(xpath = ("//span[contains(text(),'customer reviews')]"))
	WebElement reviews;
	@FindBy(xpath = ("(//table[@id='histogramTable']//tr)[1]"))
	WebElement fiveStar;
	@FindBy(xpath = ("(//table[@id='histogramTable']//tr)[2]"))
	WebElement fourStar;
	@FindBy(xpath = ("(//table[@id='histogramTable']//tr)[3]"))
	WebElement threeStar;
	@FindBy(xpath = ("(//table[@id='histogramTable']//tr)[4]"))
	WebElement twoStar;
	@FindBy(xpath = ("(//table[@id='histogramTable']//tr)[5]"))
	WebElement oneStar;
	
	
	public AmazonFinalPage(WebDriver driver) 
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		log = new CreateLog(); 
	}
	
	public void knowReview()
	{
		waitCondition(WaitExpectedConditions.PRESENCE_OF_ELEMENT,By.xpath("//span[contains(text(),'customer reviews')]"), 10);
		clickBtn(reviews);
		waitCondition(WaitExpectedConditions.PRESENCE_OF_ELEMENT,By.xpath("(//table[@id='histogramTable']//tr)[1]"), 10);
		five=fiveStar.getText();
		four=fourStar.getText();
		three=threeStar.getText();
		two=twoStar.getText();
		one=oneStar.getText();
		
		
		log.writeLog("Five Star",five );
		log.writeLog("Four Star",four );
		log.writeLog("Three Star",three );
		log.writeLog("Two Star",two );
		log.writeLog("One Star",one );
		
	}
	
	
}
