package sa.pageClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {

	static WebDriver driver;
	
	
	static void openBrowser(){
		System.setProperty("webdriver.gecko.driver","./Drivers/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	static void navigateToUrl(){
		driver.get("http://www.adactin.com/HotelApp/index.php");
	}
}
