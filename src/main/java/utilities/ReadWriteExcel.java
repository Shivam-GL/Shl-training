package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;


public class ReadWriteExcel 
{
	  
	   WritableWorkbook workBook;
	   WritableSheet sheet;
	   public void createExl(String fileName,String sheetName)throws WriteException, IOException
	   {
		   workBook = Workbook.createWorkbook(new File(fileName));
		   sheet = workBook.createSheet(sheetName, 0);
		   
		   
	   }
	   public void headerName(String headerValues) throws RowsExceededException, WriteException
	   {
		 String[]  header = headerValues.split(",");
		 int colLength=header.length;
		 for(int x=0;x<colLength;x++)
		 {
			 Label enterText=new Label(x,0,header[x]);
			 sheet.addCell(enterText);
		 }
		    
	   }
	   public void excelInput(String valuesInput, int rowNum) throws RowsExceededException, WriteException, IOException
	   {
		   String[] value=valuesInput.split(",");
		   int colLength=value.length;
		   for(int x=0;x<colLength;x++)
		   {
			   Label enterText=new Label(x,rowNum,value[x]);
			   sheet.addCell(enterText);
		   }
		   workBook.write();
           workBook.close();
	   }
	   public String readExcelCellData(String filePath,String sheetName, int rowNum,int cellNum) throws IOException
	   {
		   
		   File path=new File(filePath);
		   FileInputStream f=new FileInputStream(path);
		   HSSFWorkbook wb=new HSSFWorkbook(f);
		   HSSFSheet sheet=wb.getSheet(sheetName);
		   HSSFRow row=sheet.getRow(rowNum);
		   return row.getCell(cellNum).getStringCellValue();  
		   
	   }
	}	

