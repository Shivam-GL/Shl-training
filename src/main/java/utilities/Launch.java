package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Launch {
	private WebDriver driver;

	@BeforeMethod
	public void initWebDriver() {
		switch (Constants.BROWSER) {
		case "Chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case "Firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;

		case "InternetExplorer":
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			break;
		}
	}

	@AfterMethod
	public void quitDriver() {
		driver.quit();
	}

	public WebDriver getWebDriver() {
		return driver;
	}
}