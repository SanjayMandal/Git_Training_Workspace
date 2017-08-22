package sa.keywordDriven;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class TestRunner {
	
	@BeforeClass
	void beforeClass() throws Exception {
	Action.initDriver();
	ExcelOperations.openExcelForReading("./ExcelSheet/Test.xlsx");
	ExcelOperations.loadSheet(0);
	}
	@Test
	void test() throws FileNotFoundException, IOException{
		for(int rowNum=0; rowNum<7;rowNum++){
			if((ExcelOperations.readFromExcel(rowNum, 2)).equalsIgnoreCase("EnterText"))
				Action.EnterText(ExcelOperations.readFromExcel(rowNum, 0),ExcelOperations.readFromExcel(rowNum, 1),ExcelOperations.readFromExcel(rowNum, 3));
			else if((ExcelOperations.readFromExcel(rowNum, 2)).equalsIgnoreCase("CLick"))
				Action.click(ExcelOperations.readFromExcel(rowNum, 0),ExcelOperations.readFromExcel(rowNum, 1));
			else if((ExcelOperations.readFromExcel(rowNum, 2)).equalsIgnoreCase("Select"))
				Action.Select(ExcelOperations.readFromExcel(rowNum, 0),ExcelOperations.readFromExcel(rowNum, 1),ExcelOperations.readFromExcel(rowNum, 3));
			
		}
	}
}
