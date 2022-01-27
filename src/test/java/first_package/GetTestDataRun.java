package first_package;

import org.testng.annotations.Test;

public class GetTestDataRun {

	@Test
	public void testDataGetWithSecondConstructorWithSheetName() {
	//Verry important test data file can't have spaces !!!!!!!!!very very important 
		//Verry important if there are many columns with the same name it'll get the value in the last column in the right
		easyMaintainableTestDataFromExcel o2 = new easyMaintainableTestDataFromExcel("sec");//getting data from sheet #sec#
		///getting data by column 2 !! by typing it's name
		String result = o2.getDataFromExcellByeRowNameAndColumnName("username_1","and_current");//getting data wtih row and col 2
		System.out.println("sec_username_1_col  ||> 3 : "+result);
		///getting data by column 1 !! by typing it's name
		result = o2.getDataFromExcellByeRowNameAndColumnName("username_1","and_retro");//getting data wtih row and col 1
		System.out.println("username_1_col 1 assigned  : "+result);
		//getting data by default column 1 !!
		result = o2.getDataFromExcellByeRowNameAndColumnName("password");
		System.out.println("password_col 1  : "+result);
		result = o2.getDataFromExcellByeRowNameAndColumnName("password2");
		System.out.println("password2_col 1  : "+result);
		result = o2.getDataFromExcellByeRowNameAndColumnName("date");
		System.out.println("date_col 1 default :in date type "+result);
		result = o2.getDataFromExcellByeRowNameAndColumnName("date","and_current");
		System.out.println("date_col 2 assigned :in date type  "+result);
		System.out.println("____________________________________________________________________");
	
	}
	@Test
	//by default it'll get data from first sheet
	public void testDataGetWithFirstConstructorWithOutSheetName() {
	//Verry important test data file can't have spaces !!!!!!!!!very very important 
		//Verry important if there are many columns with the same name it'll get the value in the last column in the right
		easyMaintainableTestDataFromExcel o2 = new easyMaintainableTestDataFromExcel();//getting data from sheet #sec#
		///getting data by column 2 !! by typing it's name
		String result = o2.getDataFromExcellByeRowNameAndColumnName("userr1","IOS");//getting data wtih row and col 2
		System.out.println("defalt sheet1_userr1_col  ||> 2 : "+result);
		///getting data by column 1 !! by typing it's name
		result = o2.getDataFromExcellByeRowNameAndColumnName("userr1","Value");//getting data wtih row and col 1
		System.out.println("userr1_col 1 assigned  : "+result);
		//getting data by default column 1 !!
		result = o2.getDataFromExcellByeRowNameAndColumnName("password");
		System.out.println("password_col 1 default  : "+result);
		result = o2.getDataFromExcellByeRowNameAndColumnName("password2");
		System.out.println("password2_col 1 default : "+result);
		result = o2.getDataFromExcellByeRowNameAndColumnName("date");
		System.out.println("date_col 1 default :in date type "+result);
		result = o2.getDataFromExcellByeRowNameAndColumnName("date","IOS");
		System.out.println("date_col 2 assigned :in date type  "+result);
		System.out.println("____________________________________________________________________");
		
	
	}
}
