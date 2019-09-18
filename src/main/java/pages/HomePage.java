package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BaseClass;

public class HomePage extends BaseClass {
	WebDriver driver;

	@FindBy(xpath = ("//*[contains(@title, 'Search for products, brands and more')]"))
	WebElement search_box;
	@FindBy(xpath = ("//*[contains(@title, 'Search for products, brands and more')]//following::button"))
	WebElement search_btn;

	public HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	/**
	 * For removing the pop-up
	 * 
	 */
	public void remove_Login_Popup() {
		escButton();
	}

	/**
	 * For Entering the input in the search box
	 * 
	 * @param search_term: text to enter
	 */
	public void enter_Input(String search_term) {
		enterInput(search_box, search_term);

	}

	/**
	 * For clicking the search button
	 * 
	 */
	public void clck_Searchbtn() {
		clickBtn(search_btn);
	}
}