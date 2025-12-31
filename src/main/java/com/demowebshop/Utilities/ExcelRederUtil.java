package com.demowebshop.Utilities;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelRederUtil {

    public static Object[][] getExcelData(String fileFath, String sheetName){
        Object[][] data = null;
        try(FileInputStream fis = new FileInputStream(fileFath);
        Workbook workbook = new HSSFWorkbook(fis)) {
            Sheet sheet = workbook.getSheet(sheetName);
            int rows = sheet.getPhysicalNumberOfRows();
            int cols = sheet.getRow(0).getPhysicalNumberOfCells();
            data =new Object[rows-1][cols];

            for(int i = 1; i<rows;i++) {
                Row row = sheet.getRow(i);
                for (int j = 0; j < cols; j++) {
                    data[i - 1][j] = row.getCell(j).toString();
                }
            }
        }catch(IOException e){
            e.printStackTrace();
            }
        return data;
    }
}
