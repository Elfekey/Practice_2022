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

public class easyMaintainableTestDataFromExcel {
	//Verry important test data file can't have spaces !!!!!!!!!very very important 
	//Verry important if there are many columns with the same name it'll get the value in the last column in the right
	//#####you have to provide you test data file name here with it's excetention###
	//##you have to provide test sheet name here if you have more than one sheet## and want to use the one instead of the first one
	//#if you didn't give the sheet neame it'll use the first sheet automatically 
	//#if you didn't type a column name it'll get the data from the column number 2 physically starting count from 1.2.3 ect>>>
	//Globals
	private XSSFWorkbook workbook;
	private XSSFSheet sheet;
	private	XSSFRow row ;
	private XSSFCell cell ;
	private String testDataFulePath;
	private String sheetNameOfTheData ;
	//String sheetname = "Sheet2";//##you have to provide test sheet name here if you have more than one sheet##
	private String TestDataFileName ="/TestData.xlsx"; //#####you have to provide you test data file name here with it's excetention###
	//String columnName="Value";//to search by column name
	//String rowName="Password_1";//to search by row name or data name you want
	private int rowNumber;
	private int columnNumber;

	//##First Constructor Wity Sheet name ##if the sheet name is provided the sheet will be the provided one
	public easyMaintainableTestDataFromExcel(String sheetNameFromUser) {//String sheetName
		testDataFulePath =System.getProperty("user.dir"); //get the project pathx 
		try {
			//if we gonna change the folder or the test data file name we have to change it here also  /Excel/TestData.xlsx
			workbook = new XSSFWorkbook(testDataFulePath+TestDataFileName);
			sheet = workbook.getSheet(sheetNameFromUser);
			sheetNameOfTheData =sheetNameFromUser;
			System.out.println("you are getting data from sheet  : "+sheetNameOfTheData); 

		}
		catch (Exception e) {
			e.getStackTrace();
			System.out.println(e.getMessage());
			System.out.println(	e.getCause());
			e.printStackTrace();
		}
	}

	//##First Constructor Without Sheet name ##if the sheet name not provided the sheet will be first sheet always
	public easyMaintainableTestDataFromExcel() {
		testDataFulePath =System.getProperty("user.dir"); //get the project pathx 
		try {
			//if we gonna change the folder or the test data file name we have to change it here also  /Excel/TestData.xlsx
			workbook = new XSSFWorkbook(testDataFulePath+"/TestData.xlsx");
			sheetNameOfTheData = workbook.getSheetName(0);
			sheet = workbook.getSheet(sheetNameOfTheData);
			//here we try to geet the sheet name from code in constructor
			System.out.println("you are getting data from sheet  : "+sheetNameOfTheData); 
			//now when we create new object the sheet name will come from the index 0 first sheet name !!
		}
		catch (Exception e) {
			e.getStackTrace();
			System.out.println(e.getMessage());
			System.out.println(	e.getCause());
			e.printStackTrace();

		}

	}



	// main ok method with TestDataName And columnName
	//@Test
	public String getDataFromExcellByeRowNameAndColumnName(String TestDataName,String columnName  ) {//String TestDataName,String columnName  String
		//will get by colum name first then convert to row name
		try
		{	
			//##  here we try to geet the sheet name from code in constructor look at the constructor !! ##
			//getAnyDataFromExcelModule o = new getAnyDataFromExcelModule();

			//the module where we give name and get number of the column 
			//the column number maybe device data name or environment name
			columnNumber =	getColumnNumberByItsName(columnName);
			//the module where we give name and get number of the Row 
			//#########the below is the row name !!!#############
			//rowNumber = getRowNumberByItsName(rowName);//needed data name
			rowNumber = getRowNumberByItsName(TestDataName);

			row = sheet.getRow(rowNumber);//here will provice the row number by name 
			//the column number maybe device data name or environment name
			cell=row.getCell(columnNumber);//here will provide the column number   by name

			// this the step where we get the specific test data we need from the excell file
			String testDataNeeded=	getTheDataFromTheExcelByColumn(cell);
			//System.out.println("testDataNeeded "+testDataNeeded);
			return  testDataNeeded;
		}
		catch (Exception e) {
			e.getStackTrace();
			System.out.println(e.getMessage());
			System.out.println(	e.getCause());
			e.printStackTrace();
			return "No value Matched from you data file";
		}


	}

	// main ok method with TestDataName Only if there's only one column for values
	public String getDataFromExcellByeRowNameAndColumnName(String TestDataName) {//String TestDataName  String
		//will get by colum name first then convert to row name
		try
		{	
			//##  here we try to geet the sheet name from code in constructor look at the constructor !! ##
			//getAnyDataFromExcelModule o = new getAnyDataFromExcelModule();

			//here it's fixed column number 
			columnNumber =	1;
			//the module where we give name and get number of the Row 
			//#########the below is the row name !!!#############
			//rowNumber = getRowNumberByItsName(rowName);//needed data name
			rowNumber = getRowNumberByItsName(TestDataName);

			row = sheet.getRow(rowNumber);//here will provice the row number by name 
			//the column number maybe device data name or environment name
			cell=row.getCell(columnNumber);//here will provide the column number   by name
			System.out.println("the column number you'll get data from is column Number :"+columnNumber);

			// this the step where we get the specific test data we need from the excell file
			String testDataNeeded=	getTheDataFromTheExcelByColumn(cell);
			//System.out.println("testDataNeeded "+testDataNeeded);
			return  testDataNeeded;
		}
		catch (Exception e) {
			e.getStackTrace();
			System.out.println(e.getMessage());
			System.out.println(	e.getCause());
			e.printStackTrace();
			return "No value Matched from you data file";
		}


	}



	//ok
	private int getColumnNumberByItsName(String ColumnName) {

		//getting the row number where we'll search by it's name
		int columnNumber = -1;
		//this is must be the first row index 0 to see the last column number
		row=sheet.getRow(0);//we get this row to use if below
		int lastColumnIndex = row.getLastCellNum();
		//Printing last column index 
		//System.out.println("The Last Column Index = :"+lastColumnIndex);
		//row=sheet.getRow(0);
		for (int i =0;i<lastColumnIndex;i++) {//here it's ok to make it < cause  getLastRowNum physical number not index number  number 
			if(row.getCell(i).getStringCellValue().trim().equals(ColumnName)) {
				columnNumber=i;
			}
		}
		//printing the column number where yout data is 
		System.out.println("the column number you'll get data from is column Number :"+(columnNumber+1));
		return columnNumber;
	}
	//ok
	private int getRowNumberByItsName(String RowName) {
		// Searching by rowname and get the value from next column
		int lastRowIndex = sheet.getLastRowNum();
		//Printing last Row index
		//System.out.println("The Last Row Index Number = : "+lastRowIndex);
		//to be failed in the beginning
		int rowNumber=-1;
		for (int i = 0; i <=lastRowIndex ;i++) {//here we must make it <= cause  getLastRowNum return index number 
			if(sheet.getRow(i).getCell(0).getStringCellValue().trim().equals(RowName)) {
				//if(sheet.getRow(i).getCell(0).getRawValue().toString().trim().equals(RowName)) {
				rowNumber = i;
			}
		}
		//printing row number 
		System.out.println("the Row number you'll get data from is Row Number :"+(rowNumber+1));
		return rowNumber;
	}

	//gettin back restul with test data needed depend on it's type
	private String getTheDataFromTheExcelByColumn(XSSFCell Cell) {

		if (Cell.getCellType() == CellType.STRING) {
			//return cell.getStringCellValue();
			//System.out.println(Cell.getStringCellValue());//we use when the method is void 
			return cell.getStringCellValue();
		}
		else if (Cell.getCellType() == CellType.NUMERIC || Cell.getCellType() == CellType.FORMULA) {
			//convert the double to int to remove .0
			int convert = (int)Cell.getNumericCellValue();
			String cellValueToString = String.valueOf(convert);
			//String cellValueToString = String.valueOf(Cell.getNumericCellValue());
			if (HSSFDateUtil.isCellDateFormatted(Cell)) {
				DateFormat dt = new SimpleDateFormat("dd/MM/yy");
				//dt = new SimpleDateFormat("dd-MM-yy");//or maybe one ths format
				Date date = Cell.getDateCellValue();
				cellValueToString = dt.format(date);
			}

			//return cellValueToString;
			//System.out.println(cellValueToString);//we use when the method is void
			return cellValueToString;
		}

		else if (Cell.getCellType()== CellType.BLANK) {
			//return "Blank";
			//System.out.println("Blank");//we use when the method is void
			return "Blank";
		}
		else {
			//	return String.valueOf(cell.getBooleanCellValue());
			//System.out.println(String.valueOf(Cell.getBooleanCellValue())); //we use when the method is void
			return String.valueOf(cell.getBooleanCellValue());
		}

	}

}
