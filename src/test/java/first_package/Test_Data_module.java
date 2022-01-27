package first_package;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class Test_Data_module {
	//Globals
	XSSFWorkbook  wrokbook;
	XSSFSheet sheet;
	String testDataPath;
	
	//constructor
	public Test_Data_module() {
		try {

		testDataPath = System.getProperty("user.dir"); //get the project pathx 
		System.out.println("user dir is >>"+testDataPath);  
		wrokbook = new XSSFWorkbook(testDataPath+"/Excel/TestData.xlsx");
		// this not dynamic way  C:/Users/SayedH3/eclipse-workspace/Excel/TestData.xlsx
		sheet = wrokbook.getSheet("Sheet1");
		}
		catch (Exception e) {
			e.getStackTrace();
			System.out.println(e.getMessage());
			System.out.println(	e.getCause());
			e.printStackTrace();
		}
	
	}
	
	
	
	//@Test
	public void getRowCount() {

		try {

			testDataPath = System.getProperty("user.dir"); //get the project pathx 
			System.out.println("user dir is >>"+testDataPath);  
			wrokbook = new XSSFWorkbook(testDataPath+"/Excel/TestData.xlsx");
			// this not dynamic way  C:/Users/SayedH3/eclipse-workspace/Excel/TestData.xlsx
			sheet = wrokbook.getSheet("Sheet1");
			//sheet.getLastRowNum();
			//sheet.getWorkbook();
			sheet.getPhysicalNumberOfRows();
			//System.out.println("last row num "+sheet.getLastRowNum()); //3 this index number 
			//System.out.println("getWorkbook"+sheet.getWorkbook()); //result >/xl/workbook.xml - Content Type: application/vnd.openxmlformats-officedocument.spreadsheetml.sheet.main+xml
			System.out.println("getPhysicalNumberOfRows"+sheet.getPhysicalNumberOfRows());  // 4  this not index number 
		}
		catch (Exception e) {
			e.getStackTrace();
			System.out.println(e.getMessage());
			System.out.println(	e.getCause());
			e.printStackTrace();
		}
	}

	//@Test
	public void getCellDataNum() {

		
		try {
		
			//geeting data of specific cell String data
			String cellData=sheet.getRow(0).getCell(0).getStringCellValue();
			System.out.println(cellData);
			//--------------------
			//getting number from cell data
			Double  cellDataNum = sheet.getRow(0).getCell(1).getNumericCellValue();
			System.out.println(cellDataNum);

		
			System.out.println("Test>>>>"+sheet.getPhysicalNumberOfRows());
			
		}
		catch (Exception e) {
			e.getStackTrace();
			System.out.println(e.getMessage());
			System.out.println(	e.getCause());
			e.printStackTrace();
		}
	}
	
	@Test
public void run () {
Test_Data_module mod = new Test_Data_module();
mod.getCellDataNum();
}
}
