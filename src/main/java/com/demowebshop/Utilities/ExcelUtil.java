package com.demowebshop.Utilities;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.FileInputStream;

public class ExcelUtil {

    private static HSSFWorkbook workbook;
    private static HSSFSheet sheet;

    public static void setExcelFile(String filePath, String sheetName){
        try{
            FileInputStream fis = new FileInputStream(filePath);
            workbook = new HSSFWorkbook(fis);
            sheet = workbook.getSheet(sheetName);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static int getRowCount(){
        return sheet.getLastRowNum();
    }

    public static int getColumnCount(){
        return sheet.getRow(0).getLastCellNum();
    }

    public static String getExcelData(int rowNum, int colNum){
        return sheet.getRow(rowNum).getCell(colNum).toString();
    }
}