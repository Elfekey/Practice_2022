package first_package;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class registerPersonalData extends base {
	//all the register steps are here !!

	//rest of register filling personal data  steps
	//@Test (priority = 1)
	public void register_new_user(WebDriver driver, WebDriverWait wait) {
		//WebDriverWait wait = new WebDriverWait(driver, 20);//###must write this code inside the method idk y
		//filling data 
		//Gender #id_gender1  //label[@for='id_gender1']
		WebElement gender =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[@for='id_gender1']")));//(By.xpath("//label[@for=\"id_gender1\"]"));//"//*[@id_gender1]");//this id but css selector
		gender.click();

		//#customer_firstname 
		WebElement f_name = driver.findElement(By.cssSelector("#customer_firstname"));//this id but css selector
		f_name.sendKeys(getFName());

		//##customer_lastname
		WebElement l_name = driver.findElement(By.cssSelector("#customer_lastname"));//this id but css selector
		l_name.sendKeys(getLName());
		//#email
		WebElement e_mail = driver.findElement(By.cssSelector("#email"));//this id but css selector
		if(e_mail.getText() ==null) {
			e_mail.sendKeys(getFullEmail());	 
		}
		else
		{
			System.out.println("the Email data was autoa filled from the system let's continue ><\"");
		}

		//#passwd
		WebElement password = driver.findElement(By.cssSelector("#passwd"));//this id but css selector
		password.sendKeys(getPasswd());
		////*[@id='days']
		Select day = new Select(driver.findElement(By.xpath("//*[@id='days']")));
		day.selectByIndex(17);

		////*[@id='months']
		Select month = new Select(driver.findElement(By.xpath("//*[@id='months']")));
		month.selectByIndex(1);
		////*[@id='years']
		Select year = new Select(driver.findElement(By.xpath("//*[@id='years']")));
		year.selectByValue("1996");
		////input[@name="address1"]
		WebElement address_1 = driver.findElement(By.xpath("//input[@name='address1']"));
		address_1.sendKeys(getFName()+","+getLName()+",");
		////input[@name='city']
		WebElement city = driver.findElement(By.xpath("//input[@name='city']"));
		city.sendKeys(getCity_s());
		//-----------------------------------------------till here
		//#id_state  State         id_state
		Select state = new Select(driver.findElement(By.xpath("//*[@id='id_state']")));
		//state.selectByIndex(2);
		//value 
		state.selectByVisibleText("Colorado");
		//#postcode
		WebElement postcode = driver.findElement(By.cssSelector("#postcode"));
		postcode.sendKeys(getPostcode_s());
		//#id_country
		Select country = new Select(driver.findElement(By.cssSelector("#id_country")));
		country.selectByIndex(1);

		//  #phone_mobile
		WebElement mobile = driver.findElement(By.cssSelector("#phone_mobile"));
		mobile.sendKeys(getMobile_s());

		////*[@value='My address' and @name='alias']
		WebElement last_my_email = driver.findElement(By.xpath("//*[@value='My address' and @name='alias']"));
		last_my_email.clear();
		last_my_email.sendKeys(getFullEmail());

		//register btn   //span[contains(text(),'Regis')]
		WebElement register_btn = driver.findElement(By.xpath("//span[contains(text(),'Regis')]"));
		register_btn.click();
		
		//check logged in
		Boolean loggedin = driver.findElement(By.xpath("//*[@title='View my customer account']")).isDisplayed();
		Assert.assertTrue(loggedin, "the loggin failed");




	}

}



