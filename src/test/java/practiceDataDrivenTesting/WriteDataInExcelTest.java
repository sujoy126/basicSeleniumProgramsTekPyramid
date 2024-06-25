	package practiceDataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataInExcelTest {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("D:\\SUJOY_Qspider\\TekPyramidDocometsAPP\\testScriptData.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		
		Sheet sh = book.getSheet("org");
		Row row = sh.getRow(1);
		  Cell cell = row.createCell(4);
		  cell.setCellType(CellType.STRING);
		  cell.setCellValue("pass");
		  
		  FileOutputStream fos = new FileOutputStream("D:\\\\SUJOY_Qspider\\\\TekPyramidDocometsAPP\\\\testScriptData.xlsx");
		  book.write(fos);
		  book.close();
		  System.out.println("=====Executed======");
		  
		  
	}

}
