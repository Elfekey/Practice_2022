package first_package;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class base {
	//globas to use in  everything below 
	ChromeOptions option;
	WebDriver driver;
	WebDriverWait wait ;
	private String url = "http://automationpractice.com/index.php" ;//"http://automationpractice.com/index.php";
	private static String email="heydudeHi";
	private static String dotcom = "@123.com";
	private  static String fullemail =email.concat(dotcom);
	private String fname="Likoo";
	private String lname="Elaswad";
	private String passwd ="12345656";
	private String city_s ="Cairo";	
	private String postcode_s ="11511";
	private String mobile_s ="01002314059";
	//Setter and getter
	//url 
	public void setUrl (String url) {
		this.url=url;
	}
	public String getUrl() {
		return  this.url;
	}
	//Email
	public void setEmail (String emai) {
		email=emai;
	}
	public String getEmail () {
		return  email;
	}
	//dotcom
	public void setDotcom (String dtcom) {
		dotcom = dtcom;
	}
	public String getDotcom () {
		return  dotcom;
	}
	//FullEmail
	public void setFullEmail (String fulemail) {
		fullemail =fulemail;
	}
	public String getFullEmail () {
		return  fullemail;
	}
	//fname
	public void setFName (String fname) {
		this.fname=fname;
	}
	public String getFName () {
		return  this.fname;
	}
	//lname
	public void setLName (String lname) {
		this.lname=lname;
	}
	public String getLName () {
		return  this.lname;
	}
	//passwd
	public void setPasswd (String passwd) {
		this.passwd=passwd;
	}
	public String getPasswd () {
		return  this.passwd;
	}
	//city_s
	public void setCity_s (String city_s) {
		this.city_s=city_s;
	}
	public String getCity_s () {
		return  this.city_s;
	}
	//poscode_s
	public void setPostcode_s (String poscode_s) {
		this.postcode_s=poscode_s;
	}
	public String getPostcode_s () {
		return  this.postcode_s;
	}
	//mobile_s
	public void setMobile_s (String mobile_s) {
		this.mobile_s=mobile_s;
	}
	public String getMobile_s () {
		return  this.mobile_s;
	}

	//-----------------------------------------------------------------------------------

	//setup system configurations 
	//ChromeOptions option ,WebDriver driver,  String url
	
	public void setupAllThings() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\SayedH3\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		option = new ChromeOptions();
		option.addArguments("--lang=en-GB");
		driver = new ChromeDriver(option);

	}

	//opennning url
	//WebDriver driver,  String url

	public void openUrl(String url) {

		driver.get(url);
		driver.manage().window().maximize();
	}



}
