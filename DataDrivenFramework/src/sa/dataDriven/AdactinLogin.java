package sa.dataDriven;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;




import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdactinLogin {
	
	static WebDriver driver;

	@Test
	void main() throws FileNotFoundException, IOException {
		openHotelApp();
		ExcelOperations.openExcelForReading("./ExcelSheet/Test.xlsx");
		ExcelOperations.loadSheet(0);
		for(int rowNum =0; rowNum<3; rowNum++)
		{
			login(ExcelOperations.readFromExcel(rowNum, 0),ExcelOperations.readFromExcel(rowNum, 1));
		}
		ExcelOperations.closeWorkbook();
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
