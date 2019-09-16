package testScripts;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.second_secenario_workpage;
import utilities.BaseClass;
import utilities.Constants;
import utilities.Launch;
import utilities.PageObjectManager;
import utilities.WaitExpectedConditions;

public class TestScript1 extends Launch {

	WebDriver driver;
	HomePage homepage;
	second_secenario_workpage workpage;
	@BeforeMethod
	public void initBrowser() {
		driver = getWebDriver();
		homepage = new HomePage(driver);
		workpage=new second_secenario_workpage(driver);
	}

	@Test
	public void test1() {
		driver.get(Constants.URL);
		homepage.remove_login_popup();
		homepage.enter_input(Constants.search_term);
		homepage.clck_searchbtn();
		homepage.print();

	}

	@Test
	public void test2() {
		driver.get(Constants.URL);
		workpage.remove_login_popup();
		workpage.open_camera();
		workpage.compare(3);
		workpage.check(3);
		workpage.product_wanted(3);
	}
}
