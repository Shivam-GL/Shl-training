package testScripts;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import org.testng.annotations.Test;

import jxl.write.WriteException;
import utilities.Constants;
import utilities.Launch;
import utilities.ReadWriteExcel;

public class TestScript4 extends Launch  
{
	ReadWriteExcel readWrite = new ReadWriteExcel();;
	WebDriver driver;
	
	
	
	@Test
	public void test4() throws WriteException, IOException
	{
		readWrite.createExl("output.xls", "SheetExcel");
		readWrite.headerName("URL,BROWSER");
		readWrite.excelInput("https://www.facbook.com,Chrome", 1);
		Constants.URL = readWrite.readExcelCellData("output.xls", "SheetExcel", 1, 0);
		Constants.BROWSER = readWrite.readExcelCellData("output.xls", "SheetExcel", 1, 1);
		initWebDriver();
		driver= getWebDriver();
		driver.get(Constants.URL);
		
		
	}
	
}
