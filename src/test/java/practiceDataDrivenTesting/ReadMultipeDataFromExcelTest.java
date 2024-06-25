package practiceDataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadMultipeDataFromExcelTest {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("D:\\SUJOY_Qspider\\TekPyramidDocometsAPP\\testScriptData.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		
		Sheet sh = book.getSheet("Sheet1");
		int lastRow = sh.getLastRowNum();
		
		for(int i=1; i<=lastRow; i++) {
		  Row row = sh.getRow(i);
		 String  column1Data =  row.getCell(0).toString();
		 String  column2Data = row.getCell(1).toString();
		 
		 System.out.println(column1Data+ "\t " + column2Data);
		 book.close();
		}
		 
	}

}
