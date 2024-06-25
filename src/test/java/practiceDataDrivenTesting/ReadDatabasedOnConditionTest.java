package practiceDataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDatabasedOnConditionTest {
	public static void main(String[] args) throws IOException {
		
	 String	ExpectedTestId = "tc_100";
	 String data1 = "";
	 String data2 ="";
	 String data3= "";
	 
	 boolean flag = false;
		FileInputStream fis  = new FileInputStream("D:\\SUJOY_Qspider\\TekPyramidDocometsAPP\\testScriptData.xlsx");
		 Workbook book = WorkbookFactory.create(fis);
		Sheet sh = book.getSheet("org");
		
		int lastRow = sh.getLastRowNum();
		
		for(int i=0; i<=lastRow; i++) {
			String data=null;
			
			try {
				 data = sh.getRow(i).getCell(0).toString();
				 if(data.equals(ExpectedTestId)) {
					 flag =true;
				  data1 = sh.getRow(i).getCell(1).toString();
				  data2 = sh.getRow(i).getCell(2).toString();
				  data3 = sh.getRow(i).getCell(3).toString();				 
				 }
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		if(flag==true) {
			System.out.println(data1);
			 System.out.println(data2);
			 System.out.println(data3);
		}
		else {
			System.out.println(ExpectedTestId+" data is not available");
		}
			 
			 
		book.close();
		
	}

}
