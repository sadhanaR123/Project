package genericLibrary;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/***
 * 
 * @author Arpitha
 *
 */

public class ExcelLib {
	static String excelPath = "./src/test/resources/Book1.xlsx";
	
	/**
	 * This method is used to read string data from an excel file
	 * @param sheetname provide the sheet name where you have the test data
	 * @param rowNum provide the row number where you have test data
	 * @param cellNum provide the cell num which you want to read
	 * @return it returns the data in that respective sheet , row cell in the form of string
	 */
	public static String readStringData(String sheetname, int rowNum, int cellNum)  {
		Workbook workbook = null;
		try {
			File absPath = new File(excelPath);
			FileInputStream fis = new FileInputStream(absPath);
			workbook = WorkbookFactory.create(fis);
		}catch(FileNotFoundException e) {
			
		}catch (EncryptedDocumentException e) {
			// TODO: handle exception
		}catch (IOException e) {
			// TODO: handle exception
		}
		return workbook.getSheet(sheetname).getRow(rowNum).getCell(cellNum).getStringCellValue();
		
	}
	public static double readNumberData(String sheetname, int rowNum, int cellNum)  {
		Workbook workbook = null;
		try {
			File absPath = new File(excelPath);
			FileInputStream fis = new FileInputStream(absPath);
			workbook = WorkbookFactory.create(fis);
		}catch(FileNotFoundException e) {
			
		}catch (EncryptedDocumentException e) {
			// TODO: handle exception
		}catch (IOException e) {
			// TODO: handle exception
		}
		return workbook.getSheet(sheetname).getRow(rowNum).getCell(cellNum).getNumericCellValue();
	}
	public static boolean readBooleanData(String sheetname, int rowNum, int cellNum)  {
		Workbook workbook = null;
		try {
			File absPath = new File(excelPath);
			FileInputStream fis = new FileInputStream(absPath);
			workbook = WorkbookFactory.create(fis);
		}catch(FileNotFoundException e) {
			
		}catch (EncryptedDocumentException e) {
			// TODO: handle exception
		}catch (IOException e) {
			// TODO: handle exception
		}
		return workbook.getSheet(sheetname).getRow(rowNum).getCell(cellNum).getBooleanCellValue();
	}
	public static Date readDateData(String sheetname, int rowNum, int cellNum) {
		Workbook workbook = null;
		try {
			File absPath = new File(excelPath);
			FileInputStream fis = new FileInputStream(absPath);
			workbook = WorkbookFactory.create(fis);
		}catch(FileNotFoundException e) {
			
		}catch (EncryptedDocumentException e) {
			// TODO: handle exception
		}catch (IOException e) {
			// TODO: handle exception
		}
		return  (Date) workbook.getSheet(sheetname).getRow(rowNum).getCell(cellNum).getDateCellValue();
	
	}
	
	public static String[][] readMultipleData(String sheetName) {
		Workbook workbook = null;
		try {
			File absPath = new File(excelPath);
			FileInputStream fis = new FileInputStream(absPath);
			workbook = WorkbookFactory.create(fis);
		}catch(FileNotFoundException e) {
			
		}catch (EncryptedDocumentException e) {
			// TODO: handle exception
		}catch (IOException e) {
			// TODO: handle exception
		}
		int phyRowCount = workbook.getSheet(sheetName).getPhysicalNumberOfRows();
		int phyCellCount = workbook.getSheet(sheetName).getRow(0).getPhysicalNumberOfCells();
		
		String[][] sarr = new String [phyRowCount][phyCellCount];
		
		for(int i=0;i<phyRowCount;i++) {
			for(int j=0;j<phyCellCount;j++) {
				sarr[i][j]=workbook.getSheet(sheetName).getRow(i).getCell(j).getStringCellValue();
			}
		}
		return sarr;
}	

		
}