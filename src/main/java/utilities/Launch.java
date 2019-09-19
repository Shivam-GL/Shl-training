package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


import io.github.bonigarcia.wdm.WebDriverManager;


public class Launch {
	private WebDriver driver;
	private String browserName;

	@BeforeClass
	public  void initWebDriver()throws Exception{
		//if browser-name is not read from excel get it from constants file
		browserName=(browserName==null)?Constants.BROWSER:browserName;
		
		switch(browserName) {
		case "Chrome": WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		break;

		case "Firefox": WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		break;

		case "InternetExplorer": WebDriverManager.iedriver().setup();
		driver=new InternetExplorerDriver();
		break;
		
		default: throw new Exception("pass valid browser name");
		}
	}

	@AfterClass
	public void quitDriver() {
		driver.quit();
	}

	public WebDriver getWebDriver() {
		return driver;
	}
	public void goToUrl(String Url) {
		driver.get(Url);
		driver.manage().window().maximize();
	}
	
	
	public void setBroswerName(String browser) {
		browserName=browser;
	}
}
