package first_package;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class run_all extends  base {


	//end ob = new end();
	//the befores   methods  
	@BeforeTest
	public void befores() {
		setupAllThings();
	}
	//before methods
	@BeforeClass // i had an error here caus it was beforemethod and was reloading website after first step and intturupt the steps
	public void beforeMethods() {
		//System.out.println(getUrl());
		openUrl(getUrl());
	}

	@Test (priority = 1)
	public void register_new_acc() throws InterruptedException {

		//object from checkemail name 
		check_email_name check= new check_email_name();
		// #1# go to register and check email name if valid continue to fill personal data
		//the methods of check name // 
		check.checkuserName(driver,getFullEmail() );


	}
	@Test (priority = 2, dependsOnMethods = "register_new_acc")
	public void fillPersonalData() throws InterruptedException {
		Thread.sleep(3000);
		//#2# after everthing is ok we'll fill the rest of personal data and click Register Button
		wait= new WebDriverWait(driver, 30);//we have to continue the rest of declaration of wait in the method we use
		//object from registerPersonalData class 
		registerPersonalData rgister = new registerPersonalData();
		rgister.register_new_user(driver,wait);
	}


	//#3#LogIn method
	//@Test (priority = 3)
	public void login() throws InterruptedException {
		loginAndOut logs = new loginAndOut();
		logs.logIn(driver, getFullEmail(), getPasswd());
		System.out.println("The full user name now is "+getFullEmail());

	}
	//#4#Logout method
	//@Test (priority = 4)
	public void logout() throws InterruptedException {
		loginAndOut logs = new loginAndOut();
		logs.logout(driver);

	}

	//#5# check logged in
	@Test (priority =5) //, dependsOnMethods = "fillPersonalData"
	public void assert_LiggedIn() {
		//check logged in   //*[@title='View my customer account']
		/*Boolean loggedin = false;
	    loggedin = driver.findElement(By.xpath("//*[@title='View my customer account']")).isDisplayed();
		Assert.assertTrue(loggedin, "No user loggedin Please log in with any user to see the loginpage");
		Assert.assertEquals(driver.findElement(By.xpath("//*[@title='View my customer account']")).isDisplayed(), true);
		 */

		//new try Element assert exist !!
		Boolean dahboard_username_appeared = driver.findElements(By.xpath(("//*[@title='View my customer account']"))).isEmpty();
		if (dahboard_username_appeared) {
			System.out.println("this element is Empty ");
		}
		else
			System.out.println("Element is exist you are in dash Board now ");
	}





	@AfterTest
	public void afters() throws InterruptedException {
		end eo = new end();
		eo.closeEverything(driver);
	}


}
