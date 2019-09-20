package testScripts;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utilities.Constants;
import utilities.Launch;
import utilities.ReadExcel;
import utilities.WriteExcel;

public class Testscript3 extends Launch{
	private WriteExcel write;
	private ReadExcel read;
	String sheetName = "FirstSheet";
 /**
  * setting up excel file
  */
 @BeforeTest	
	public void setupExcel()  {
	 // creating excel file
	  write=new WriteExcel(Constants.EXCELPATH);
	  //entering data in excel
	  write.createExcel();
	  write.enterExcelData(Constants.EXCELPATH,sheetName, 0,0, "URL");
	  write.enterExcelData(Constants.EXCELPATH,sheetName, 0,1, "BROWSER");
	  write.enterExcelData(Constants.EXCELPATH,sheetName, 1,0, "https://www.flipkart.com");
	  write.enterExcelData(Constants.EXCELPATH,sheetName, 1,1, "Chrome");
	  
	  //reading excel
	  read=new ReadExcel();
	  //getting browser-name from excel
	 setBroswerName(read.readData(Constants.EXCELPATH,sheetName, 1,1));
 }
  @Test
 public void test1() {
	  System.out.println(read.readData(Constants.EXCELPATH,sheetName, 1,0));
	 goToUrl(read.readData(Constants.EXCELPATH,sheetName, 1,0));
  }
}
