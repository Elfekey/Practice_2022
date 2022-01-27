package first_package;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class getAnyDataFromExcelModule {
	//Globals
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	XSSFRow row ;
	XSSFCell cell ;
	 String testDataFulePath;
	String sheetname = "Sheet1";
	String columnName="IOS";//to search by column name
	String rowName="user_name_tc7";
	 int rowNumber;
	 int columnNumber;

	//if the sheet name is provided the sheet will be the provided one
	public getAnyDataFromExcelModule() {//String sheetName
		testDataFulePath =System.getProperty("user.dir"); //get the project pathx 
		try {
			//if we gonna change the folder or the test data file name we have to change it here also  /Excel/TestData.xlsx
			workbook = new XSSFWorkbook(testDataFulePath+"/Excel/TestData.xlsx");
			sheet = workbook.getSheet(sheetname);
			
		}
		catch (Exception e) {
			e.getStackTrace();
			System.out.println(e.getMessage());
			System.out.println(	e.getCause());
			e.printStackTrace();
		}
	}
/*
	//if the sheet name not provided the sheet will be first sheet always
	public getAnyDataFromExcelModule() {
		testDataFulePath =System.getProperty("user.dir"); //get the project pathx 
		try {
			//if we gonna change the folder or the test data file name we have to change it here also  /Excel/TestData.xlsx
			workbook = new XSSFWorkbook(testDataFulePath+"/TestData.xlsx");
			String firstSheetName = workbook.getSheetName(0);
			sheet = workbook.getSheet(firstSheetName);
			//here we try to geet the sheet name from code in constructor
			System.out.println(firstSheetName); 
			//now when we create new object the sheet name will come from the index 0 first sheet name !!
		}
		catch (Exception e) {
			e.getStackTrace();
			System.out.println(e.getMessage());
			System.out.println(	e.getCause());
			e.printStackTrace();

		}

	}
*/




// main ok method
	@Test
	public void getDataFromExcell() {//String
		//will get by colum name first then convert to row name
		try
		{	
			//##  here we try to geet the sheet name from code in constructor look at the constructor !! ##
			//getAnyDataFromExcelModule o = new getAnyDataFromExcelModule();

			//##the below code will be implemented in another method for  easy maintainaability##
			/*
			//getting the row number where we'll search by it's name
			int columnNumber = -1;
			//this is must be the first row index 0 to see the last column number
			row=sheet.getRow(0);//we get this row to use if below
			int lastColumnIndex = row.getLastCellNum();
			System.out.println("ccccccccccccc"+lastColumnIndex);
			//row=sheet.getRow(0);
			for (int i =0;i<lastColumnIndex;i++) {
				if(row.getCell(i).getStringCellValue().trim().equals("IOS")) {
					columnNumber=i;
				}
			}
			System.out.println(columnNumber);
			 */


			//##the below code will be implemented in another method for  easy maintainaability##
			// Searching by rowname and get the value from next column
			/*
			int lastRowIndex = sheet.getLastRowNum();
			System.out.println("ssssssss"+lastRowIndex);
			//to be failed in the beginning
			int rowNumber=-1;
			for (int i = 0; i <lastRowIndex ;i++) {
				if(sheet.getRow(i).getCell(0).getStringCellValue().trim().equals("user_name_tc6")) {
					rowNumber = i;
				}
			}
			 */
			//the module where we give name and get number of the column 
			//the column number maybe device data name or environment name
			columnNumber =	getColumnNumberByItsName(columnName);
			//the module where we give name and get number of the Row 
			rowNumber = getRowNumberByItsName(rowName);

            
			row = sheet.getRow(rowNumber);//here will provice the row number by name 
			//the column number maybe device data name or environment name
			cell=row.getCell(columnNumber);//here will provide the column number   by name




			/*
			int colNum= -1;//to be out of bound firstly
			row = sheet.getRow(0);
			//cell= row.getCell(1);//working good with column number
			for(int i=0;i<row.getLastCellNum();i++) {

				if (row.getCell(i).getStringCellValue().trim().equals("and")) {
					colNum = i;
				}
				row =sheet.getRow(3);
				cell =row.getCell(colNum);
			} */




			if (cell.getCellType() == CellType.STRING) {
				//return cell.getStringCellValue();
				System.out.println(cell.getStringCellValue());//we use when the method is void 
				//return cell.getStringCellValue();
			}
			else if (cell.getCellType() == CellType.NUMERIC || cell.getCellType() == CellType.FORMULA) {
				//convert the double to int to remove .0
				int convert = (int)cell.getNumericCellValue();
				String cellValueToString = String.valueOf(convert);

				if (HSSFDateUtil.isCellDateFormatted(cell)) {
					DateFormat dt = new SimpleDateFormat("dd/MM/yy");
					Date date = cell.getDateCellValue();
					cellValueToString = dt.format(date);
				}

				//return cellValueToString;
				System.out.println(cellValueToString);//we use when the method is void
				// return cellValueToString;
			}

			else if (cell.getCellType()== CellType.BLANK) {
				//return "Blank";
				System.out.println("Blank");//we use when the method is void
				//return "Blank";
			}
			else {
				//	return String.valueOf(cell.getBooleanCellValue());
				System.out.println(String.valueOf(cell.getBooleanCellValue())); //we use when the method is void
				//return String.valueOf(cell.getBooleanCellValue());
			}
		}
		catch (Exception e) {
			e.getStackTrace();
			System.out.println(e.getMessage());
			System.out.println(	e.getCause());
			e.printStackTrace();
			//return "No value Matched from you data file";
		}


	}

//ok
	public int getColumnNumberByItsName(String ColumnName) {

		//getting the row number where we'll search by it's name
		int columnNumber = -1;
		//this is must be the first row index 0 to see the last column number
		row=sheet.getRow(0);//we get this row to use if below
		int lastColumnIndex = row.getLastCellNum();
		System.out.println("The Last Colun Index = :"+lastColumnIndex);
		//row=sheet.getRow(0);
		for (int i =0;i<lastColumnIndex;i++) {
			if(row.getCell(i).getStringCellValue().trim().equals(ColumnName)) {
				columnNumber=i;
			}
		}
		System.out.println("the column number you'll get data from is column Number :"+columnNumber);
		return columnNumber;
	}
//ok
	public int getRowNumberByItsName(String RowName) {
		// Searching by rowname and get the value from next column
		int lastRowIndex = sheet.getLastRowNum();
		System.out.println("The Last Row Index Number = : "+lastRowIndex);
		//to be failed in the beginning
		int rowNumber=-1;
		for (int i = 0; i <lastRowIndex ;i++) {
			if(sheet.getRow(i).getCell(0).getStringCellValue().trim().equals(RowName)) {
				rowNumber = i;
			}
		}
		return rowNumber;
	}

	/* 
	public String getDataFromExcell(String ColumnName , String RowName ) {
		try {
			//the module where we give name and get number of the column 
			//the column number maybe device data name or environment name
			columnNumber =	getColumnNumberByItsName(columnName);
			//the module where we give name and get number of the Row 
			rowNumber = getRowNumberByItsName(rowName);
			
			row = sheet.getRow(rowNumber);//here will provice the row number by name 
			//the column number maybe device data name or environment name
			cell=row.getCell(columnNumber);//here will provide the column number   by name
            String resultOfSearchingModule = gettingDataDueToItsKind();
            return resultOfSearchingModule;
		
		}
		catch (Exception e) {
			e.getStackTrace();
			System.out.println(e.getMessage());
			System.out.println(	e.getCause());
			e.printStackTrace();
			return "Err";
		}


	}
	/* 
	public String gettingDataDueToItsKind() {
	try {
		
		if (cell.getCellType() == CellType.STRING) {
			//return cell.getStringCellValue();
			//System.out.println(cell.getStringCellValue());//we use when the method is void 
			return cell.getStringCellValue();
		}
		else if (cell.getCellType() == CellType.NUMERIC || cell.getCellType() == CellType.FORMULA) {
			//convert the double to int to remove .0
			int convert = (int)cell.getNumericCellValue();
			String cellValueToString = String.valueOf(convert);

			if (HSSFDateUtil.isCellDateFormatted(cell)) {
				DateFormat dt = new SimpleDateFormat("dd/MM/yy");
				Date date = cell.getDateCellValue();
				cellValueToString = dt.format(date);
			}

			//return cellValueToString;
			//System.out.println(cellValueToString);//we use when the method is void
			 return cellValueToString;
		}

		else if (cell.getCellType()== CellType.BLANK) {
			//return "Blank";
			//System.out.println("Blank");//we use when the method is void
			return "Blank";
		}
		else {
			//	return String.valueOf(cell.getBooleanCellValue());
		//	System.out.println(String.valueOf(cell.getBooleanCellValue())); //we use when the method is void
			return String.valueOf(cell.getBooleanCellValue());
		}
	}
		catch (Exception e) {
			e.getStackTrace();
			System.out.println(e.getMessage());
			System.out.println(	e.getCause());
			e.printStackTrace();
			return "No value Matched from you data file";
		}
	}
	
	
	*/
}
