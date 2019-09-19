package utilities;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcel {

	private FileOutputStream fileOutputStream;
	private XSSFWorkbook workbook;
	private XSSFRow row;
	private XSSFSheet sheet;
	private String filename;

	public WriteExcel() {
		filename = Constants.EXCELPATH;
		workbook = new XSSFWorkbook();
		sheet = workbook.createSheet("FirstSheet");  
	}

	//entering data in excel
	public void createExcel(String url,String browser) {

		try {
			row = sheet.createRow(0);
			row.createCell(0).setCellValue("URL");
			row.createCell(1).setCellValue("Browser");
			row = sheet.createRow(1);
			row.createCell(0).setCellValue(url);
			row.createCell(1).setCellValue(browser);
			fileOutputStream = new FileOutputStream(filename);
			workbook.write(fileOutputStream);
			fileOutputStream.close();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
