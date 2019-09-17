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
		private String browerName = Constants.BROWSER;
		
		
@BeforeClass
public  void initWebDriver() {
			  switch(browerName) {
				case "Chrome": WebDriverManager.chromedriver().setup();
							   driver = new ChromeDriver();
							   break;
							   
				case "Firefox": WebDriverManager.firefoxdriver().setup();
								driver=new FirefoxDriver();
								break;
							   
				case "InternetExplorer": WebDriverManager.iedriver().setup();
										 driver=new InternetExplorerDriver();
										 break;
				}
		  }

/*@AfterClass
public void quitDriver() {
	driver.quit();
}
*/
public WebDriver getWebDriver() {
	return driver;
}
		
}
