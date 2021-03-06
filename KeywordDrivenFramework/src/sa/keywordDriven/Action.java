package sa.keywordDriven;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Action {
	
	static WebDriver driver;
	
	static void initDriver(){
		System.setProperty("webdriver.gecko.driver","./Drivers/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("http://www.adactin.com/HotelApp/index.php");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public static void EnterText(String locatorType, String locator, String actionValue){
		switch(locatorType){
		case "id":
			driver.findElement(By.id(locator)).sendKeys(actionValue);
			break;
		case "xpath":
			driver.findElement(By.xpath(locator)).sendKeys(actionValue);
			break;
		default:
			driver.findElement(By.name(locator)).sendKeys(actionValue);
				
		}
	}
	
	static void click(String locatorType, String locator){
		switch(locatorType){
		case "id":
			driver.findElement(By.id(locator)).click();
			break;
		case "xpath":
			driver.findElement(By.xpath(locator)).click();
			break;
		default:
			driver.findElement(By.name(locator)).click();
				
		}
	}
	
	static void Select(String locatorType, String locator, String actionValue){
		
		switch(locatorType){
		case "id":
			new Select(driver.findElement(By.id(locator))).selectByValue(actionValue);
			break;
		case "xpath":
			new Select(driver.findElement(By.id(locator))).selectByValue(actionValue);
			break;
		default:
			new Select(driver.findElement(By.id(locator))).selectByValue(actionValue);
			break;
				
		}
	}
}
