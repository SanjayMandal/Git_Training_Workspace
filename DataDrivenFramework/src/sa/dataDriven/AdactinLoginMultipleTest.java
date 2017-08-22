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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AdactinLoginMultipleTest {
	
	static WebDriver driver;
	
	@BeforeClass
	void beforeClass() throws FileNotFoundException, IOException{
	openHotelApp();
	ExcelOperations.openExcelForReading("./ExcelSheet/Test.xlsx");
	ExcelOperations.loadSheet(0);
	}
	@DataProvider(name="loginData")
	Object[][] dataProvider() throws IOException{
		return ExcelOperations.readAll();
	}
	@Test(dataProvider="loginData")
	void main(String usernameData, String passwordData) throws FileNotFoundException, IOException {
			
			login(usernameData, passwordData);
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
