package first_package;


import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class trying_switch_frame {
	ChromeOptions option;
	WebDriver driver;
	//WebDriverWait wait = new WebDriverWait(driver, 30);
	
	
	@BeforeTest
public void setupAllThings() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\SayedH3\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		 option = new ChromeOptions();
		option.addArguments("--lang=en-GB");
		 driver = new ChromeDriver(option);

}
	
	
	@BeforeMethod
public void openUrl() {
	driver.get("https://play.google.com/store?hl=en&tab=w8");
	driver.manage().window().maximize();
}
	
	
	@Test
	public void operations() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver,30 );
		//WebElement search_bar =wait.until(ExpectedConditions.elementToBeClickable(By.id("gbqfq")));
		WebElement search_bar = driver.findElement(By.id("gbqfq"));
		search_bar.sendKeys("youtube");
		search_bar.sendKeys(Keys.RETURN);
		//new step
		//WebElement search_result =driver.findElement(By.xpath("//*[@href='/store/apps/details?id=com.google.android.youtube' and  @class='poRVub' ]"));
		WebElement search_result =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@href='/store/apps/details?id=com.google.android.youtube' and  @class='poRVub' ]")));
		search_result.click();
	      //scroll to element
		
		WebElement video_image = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label='Play trailer' and @class='MMZjL lgooh  ']")));
		// to move to the element
		//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", video_image);
		Actions action = new Actions(driver);
		action.moveToElement(video_image).perform();
		Thread.sleep(3000);
		video_image.click();
		
		//switching to a frame to use it's content !! we can see when we click right click there's a word named ##"reload frame" !!!!!!###"
		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='YALzif']"));
		driver.switchTo().frame(iframe);
		//now click on the content inside the frame !!
		WebElement play_button  = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label='Play']")));
		play_button.click();
		//Thread.sleep(21000);
		//to pause video  title="Pause (k)"
		//WebElement pause_button = driver.findElement(By.xpath("//button[@aria-label='Pause (k)']"));
		//play_button.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@AfterTest
	public void closeEverything() throws InterruptedException {
		Thread.sleep(7000);
		driver.quit();
}	
}
