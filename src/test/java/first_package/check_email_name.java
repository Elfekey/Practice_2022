package first_package;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class check_email_name extends base {

	//checking if user exist of not and provide another user if it's exists
	//@Test (priority = 1)
	public void checkuserName(WebDriver driver,String email) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		//first tap on login button 
		WebElement login_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='login']")));
		login_btn.click();

		//go to our element to register
		WebElement register_email = driver.findElement(By.cssSelector("#email_create"));//this id but css selector
		Actions action = new Actions(driver);
		action.moveToElement(register_email).perform();
		//typing email
		register_email.sendKeys(getFullEmail());
		//click on create button
		WebElement create_btn = driver.findElement(By.id("SubmitCreate"));
		create_btn.click();

		//#create_account_error
		//Boolean isPresent = driver.findElements(By.xpath("//*[@id=\"create_account_error\"]/ol")).size() > 0;
		//boolean err_create_account = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#create_account_error"))).isDisplayed();
		Thread.sleep(4000);
		boolean err_create_account = driver.findElements(By.cssSelector("#create_account_error")).size() > 0;
		if (err_create_account) {
			System.out.println("there's an issue with the account name");	
			//here login with another account name automatically and update it everywhere
			//if the error exist then it'll call the method to get another email name 
			checkuserName( driver, another_email_name());

		}
		else {
			System.out.println("Continue to Register method");
		}

	}


	//create another email name if it's not vaild called in check email_name method
	//@Test // String   String email
	public String  another_email_name() {
		String new_email_name ; 
		//Random rand = new Random(); 	selected = rand.nextInt(100);
		Random r = new Random();
		int random_in= r.nextInt(100);

		System.out.println("The number is >>>>"+random_in);
		//converting the integer to string ///Integer.toString(random_in)
		new_email_name = getEmail().concat(Integer.toString(random_in));
		new_email_name = new_email_name.concat(getDotcom());
         setFullEmail(new_email_name);
			return new_email_name;
		//System.out.println(new_email_name);
	}



}
