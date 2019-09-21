package testScripts;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import org.testng.annotations.Test;

import jxl.write.WriteException;
import utilities.Constants;
import utilities.Launch;
import utilities.ReadWriteExcel;

public class TestScript5 extends Launch  
{
	ReadWriteExcel readWrite = new ReadWriteExcel();;
	WebDriver driver;
	
	
	
	@Test
	public void test5() throws WriteException, IOException
	{
		readWrite.createExl("newoutput.xls", "SheetExcel");
		readWrite.headerName("URL,BROWSER");
		readWrite.excelInput("https://www.facbook.com,Chrome", 1);
		String url = readWrite.readExcelCellData("newoutput.xls", "SheetExcel", 1, 0);
		String browser = readWrite.readExcelCellData("newoutput.xls", "SheetExcel", 1, 1);
		System.out.println(url);
		System.out.println(browser);
		
		
		
	}
	
}
