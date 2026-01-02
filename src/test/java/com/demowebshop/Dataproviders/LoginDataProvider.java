package com.demowebshop.Dataproviders;

import com.demowebshop.Utilities.ExcelUtil;
import org.testng.annotations.DataProvider;

public class LoginDataProvider {

    @DataProvider (name = "LoginData")
    public static Object[][] getLoginData(){
         String XLPath = System.getProperty("user.dir") + "/src/test/Resources/TestData/Test Data of DemoWebShop.xls";
        ExcelUtil.setExcelFile(XLPath, "Login Data");
        int rowCount = ExcelUtil.getRowCount();
        int colCount = ExcelUtil.getColumnCount();
        String[][] data = new String[rowCount][colCount];
        for(int i = 1; i<=rowCount; i++){
            for(int j=0;j<colCount;j++){
                data[i-1][j] = ExcelUtil.getExcelData(i, j);
            }
        } 
        return data;
    }
}
