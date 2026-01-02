package com.demowebshop.Dataproviders;
import com.demowebshop.Utilities.ExcelUtil;
import org.testng.annotations.DataProvider;

public class LoginDataProvider { 
			
    @DataProvider (name = "LoginData")
     public Object[][]  getLoginData() throws Exception{
      String XLPath =  "D:\\Git Projects\\DemoWebShop\\src\\test\\Resources\\TestData\\Test Data of DemoWebShop.xlsx";
    	String XLSheet = "LoginData";
        ExcelUtil.loadExcel(XLPath, XLSheet);
        int rows = ExcelUtil.getRowCount();
        int columns = ExcelUtil.getColumnCount();
        Object[][] data = new Object[rows-1][columns];
        for(int i=1;i<rows;i++) {
        	for(int j=0;j<columns;j++) {
        		data[i-1][j] = ExcelUtil.getCellData(i, j);
        // 	System.out.println(data[i-1][j]);
        	}
        }
        return data;
        }
    }