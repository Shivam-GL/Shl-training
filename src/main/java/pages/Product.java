package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import utilities.BaseClass;
import utilities.WaitExpectedConditions;

public class Product extends BaseClass
{
	WebDriver driver;
	public Product(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	/**
	 *  For printing in the result
	 * 
	 */
	public void print_Product() {
		waitCondition(WaitExpectedConditions.PRESENCE_OF_ELEMENT, By.xpath("//span[contains(text(),'Ratings')]"), 10);

		List<WebElement> lstdrp = driver.findElements(By.xpath("//span[contains(text(),'Ratings')]"));
		int highest_rating = 0;
		String finded_string = "";
		for (WebElement element : lstdrp) {
			String s = element.getText();
			String b = s.split(" ")[0];
			int ratings = Integer.parseInt(b.replaceAll(",", ""));
			if (ratings >= highest_rating) {
				highest_rating = ratings;
				finded_string = b;
			}
		}

		String name = driver
				.findElement(
						By.xpath("//span[contains(text(),'" + finded_string + "')]/ancestor::a/div[2]/div[1]/div[1]"))
				.getText();
		String rating = driver
				.findElement(By.xpath(
						"//span[contains(text(),'" + finded_string + "')]/ancestor::a/div[2]/div[1]/div[2]/span/div"))
				.getText();
		System.out.println("Mobile Name:   " + name);
		System.out.println("Mobile rating:   " + rating);

	}
}
