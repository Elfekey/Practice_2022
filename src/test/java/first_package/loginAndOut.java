package first_package;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class loginAndOut  extends base{



	public void logout(WebDriver driver) {
		//wait elemeent 
		wait = new WebDriverWait(driver, 20);//###must write this code inside the method idk y

		//  //*[@title='View my customer account']  assert on account name   after sign in and to sign out 
		//WebElement loggedin = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@title='View my customer account']"))).size() >0;
		//Boolean  loggedin = driver.findElement(By.xpath("//*[@title='View my customer account']")).isDisplayed();
		Boolean  loggedin = driver.findElements(By.xpath("//*[@title='View my customer account']")).size()>0;
		if (loggedin) {
			System.out.println("You are logged in already and now logging out");
			//   //*[@title='Log me out']
			WebElement logout_btn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@title='Log me out']")));
			logout_btn.click();
		}
		else
		{
			System.out.println("You need to login first to logout");
		}
	}
	
	public void logIn(WebDriver driver,String username,String password) {
		//wait elemeent 
		wait = new WebDriverWait(driver, 20);//###must write this code inside the method idk y

		//  //*[@title='View my customer account']  assert on account name   after sign in and to sign out 
		//WebElement loggedin = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@title='View my customer account']"))).size() >0;
		//Boolean  loggedin = driver.findElement(By.xpath("//*[@title='View my customer account']")).isDisplayed();
		Boolean  login_btn_check = driver.findElements(By.cssSelector(".login")).size()>0;
		if (login_btn_check) {
			WebElement login_btn = driver.findElement(By.cssSelector(".login"));
		login_btn.click();
		//#email
		WebElement email_username = driver.findElement(By.cssSelector("#email"));
		Actions act = new Actions(driver);
		act.moveToElement(email_username).build().perform();
		email_username.sendKeys(getFullEmail());
		
		//Password
		//#passwd
				WebElement email_password = driver.findElement(By.cssSelector("#passwd"));
				email_password.sendKeys(getPasswd());
				
		//  //a[contains(text(),'Sign in')]						
				WebElement login_Btn = driver.findElement(By.xpath("//a[contains(text(),'Sign in')]"));
				login_Btn.click();
				
				//check logged in
				Boolean loggedin = false;
			   // loggedin = driver.findElement(By.xpath("//*[@title='View my customer account']")).isDisplayed();
				//Assert.assertTrue(loggedin);
				Assert.assertEquals(driver.findElement(By.xpath("//*[@title='View my customer account']")).isDisplayed(), true);
		
		
		}
		else
		{
			System.out.println("You are already logged in please logout to login again");
			//calling logout method
			logout(driver);
		}
	}

}
