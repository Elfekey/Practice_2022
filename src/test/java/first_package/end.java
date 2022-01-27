package first_package;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class end {
	
	
	public void closeEverything(WebDriver driver) throws InterruptedException {
		Thread.sleep(7000);
		System.out.println("everything now Done# ");
		driver.quit();
	}
	
}
