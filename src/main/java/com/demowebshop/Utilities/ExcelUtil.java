package com.demowebshop.Utilities;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtil {
	private static Workbook workbook;
	private static Sheet sheet;
	
	public static void loadExcel(String filePath, String sheetName) throws IOException {
		FileInputStream fis = new FileInputStream(filePath);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(sheetName);
		if(sheet == null) {
			throw new RuntimeException("Sheet not found "+sheetName);
		}
	}
	
	public static String getCellData(int rowNum, int colNum) { 
		Row row =sheet.getRow(rowNum);
		if(row==null)
			return "";
		Cell cell = sheet.getRow(rowNum).getCell(colNum);
		if(cell==null)
			return "";
		return cell.toString().trim();
	}
	
	public static int getRowCount() {
		return sheet.getPhysicalNumberOfRows();
	}
	
	public static int getColumnCount() {
		return sheet.getRow(0).getPhysicalNumberOfCells();
	}
   
}