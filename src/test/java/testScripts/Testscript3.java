package testScripts;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utilities.Launch;
import utilities.ReadExcel;
import utilities.WriteExcel;

public class Testscript3 extends Launch{
	private WriteExcel write;
	private ReadExcel read;
	
 /**
  * setting up excel file
  */
 @BeforeTest	
	public void setupExcel()  {
	 // creating excel file
	  write=new WriteExcel();
	  //entering data in excel
	  write.createExcel("https://www.flipkart.com","Chrome");
	  //reading excel
	  read=new ReadExcel();
	  //getting browser-name from excel
	  setBroswerName(read.getBrowser());
 }
  @Test
 public void test1() {
	  goToUrl(read.getUrl());
  }
}
