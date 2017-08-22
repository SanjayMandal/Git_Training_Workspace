package sa.dataDriven;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;






import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AdactinLoginTest {
	
	static WebDriver driver;
	
	@BeforeClass
	void beforeClass() throws FileNotFoundException, IOException{
	openHotelApp();
	ExcelOperations.openExcelForReading("./ExcelSheet/Test.xlsx");
	}

	@Test
	void main() throws FileNotFoundException, IOException {
			ExcelOperations.loadSheet(0);
			login(ExcelOperations.readFromExcel(0, 0),ExcelOperations.readFromExcel(0, 1));
			Assert.assertTrue(isExist("username_show"));
			ExcelOperations.closeWorkbook();
	}
	@Test
	void main1() throws FileNotFoundException, IOException {
	ExcelOperations.loadSheet(0);
	login(ExcelOperations.readFromExcel(1, 0),ExcelOperations.readFromExcel(1, 1));
	Assert.assertTrue(isExist("username_show"));
	ExcelOperations.closeWorkbook();
	}
	@Test
	void main2() throws FileNotFoundException, IOException {
		ExcelOperations.loadSheet(0);
		login(ExcelOperations.readFromExcel(2, 0),ExcelOperations.readFromExcel(2, 1));
		Assert.assertTrue(isExist("username_show"));
		ExcelOperations.closeWorkbook();
		
	}
	
	boolean isExist(String inputID){
	try{
		WebElement element = driver.findElement(By.id(inputID));
		return true;
	}catch(NoSuchElementException e){
		return false;
	}
	}	
	public static void openHotelApp()
	{
		System.setProperty("webdriver.gecko.driver","./Drivers/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	public static void login(String username, String password){
		driver.get("http://www.adactin.com/HotelApp/index.php");
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("login")).click();
	}

	}
