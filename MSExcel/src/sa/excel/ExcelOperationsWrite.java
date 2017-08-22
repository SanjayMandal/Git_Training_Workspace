package sa.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelOperationsWrite {

	public static void main(String[] args) throws InvalidFormatException, IOException {
		
		/*XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet();
		Row row = sheet.createRow(0);
		Cell cell = row.createCell(0);
		cell.setCellValue("My Edited Cell");
		//fis.close();
	
		FileOutputStream fos = new FileOutputStream(new File ("./ExcelSheet/Test.xlsx"));
		workbook.write(fos);
	*/			
		FileInputStream fis = new FileInputStream(new File("./ExcelSheet/Test.xlsx"));
		XSSFWorkbook workbook1 = new XSSFWorkbook(fis);
		XSSFSheet sheet1 = workbook1.getSheetAt(0);
		Row row1 = sheet1.getRow(0);
		Cell cell1 = row1.createCell(2);
		cell1.setCellValue("My Edited Cell");
		// fis.close();

		FileOutputStream fos = new FileOutputStream(new File("./ExcelSheet/Test.xlsx"));
		workbook1.write(fos);
		
		workbook1.close();
		
	}

}
