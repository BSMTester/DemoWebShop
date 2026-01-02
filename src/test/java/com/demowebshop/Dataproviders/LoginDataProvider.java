package com.demowebshop.Dataproviders;
import com.demowebshop.Utilities.ExcelUtil;
import org.testng.annotations.DataProvider;

public class LoginDataProvider { 
			
    @DataProvider (name = "LoginData")
<<<<<<< HEAD
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
=======
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
>>>>>>> 4cf719d2bf9ed07b09d96325dff101b54744939f
        return data;
        }
    }