package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;




public class ReadExcel {
	File file;
	FileInputStream fileInputStream;
	XSSFWorkbook workbook;
	XSSFRow row;
	XSSFCell cell;
    XSSFSheet sheet;
    
	public int no_of_rows;
	
	public ReadExcel() {
		try {
			this.file=new File(Constants.EXCELPATH);
			this.fileInputStream=new FileInputStream(file);
			this.workbook=new XSSFWorkbook(fileInputStream);
			this.sheet=workbook.getSheet("FirstSheet");
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//getting number of rows in excel sheet
	public int count_row() {
		return (sheet.getLastRowNum()-sheet.getFirstRowNum());	
	}
	
	//getting url from excel
	public String getUrl() {
					row=sheet.getRow(1);
					cell=row.getCell(0);
					String url=cell.getStringCellValue();
					return url;		
	}
	
	//getting browser from excel
	public String getBrowser() {
		row=sheet.getRow(1);
		cell=row.getCell(1);
		String browser=cell.getStringCellValue();
		return browser;		
}
	
}
