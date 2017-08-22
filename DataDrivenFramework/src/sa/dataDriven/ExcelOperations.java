package sa.dataDriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelOperations {
	
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	

	public static void openExcelForReading(String fileName) throws FileNotFoundException, IOException{
		workbook = new XSSFWorkbook(new FileInputStream(new File(fileName)));
	}
	
	public static void loadSheet(int sheetNum){
		sheet = workbook.getSheetAt(sheetNum);
	}
	
	public static String readFromExcel(int rowNum, int colNum){
		try{
			return workbook.getSheetAt(0).getRow(rowNum).getCell(colNum).getStringCellValue();
		}catch(NullPointerException n){
			return "";
		}
	}
	
	public static Object[][] readAll(){
		
		Object[][] data = new Object[3][2];
		for(Row row:sheet)
			for(Cell cell:row)
				data[row.getRowNum()][cell.getColumnIndex()]=cell.getStringCellValue();		
		
		return data;
	}
	
	public static void closeWorkbook() throws IOException{
		workbook.close();
	}
	
	public static void main(String[] args) throws Exception {

		openExcelForReading("./ExcelSheet/Test.xlsx");
		loadSheet(0);
		System.out.println(readFromExcel(0,0));
		closeWorkbook();
		
	}
	
	

}
