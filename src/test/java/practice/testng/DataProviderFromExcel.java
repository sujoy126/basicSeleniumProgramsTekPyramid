package practice.testng;

import java.io.FileInputStream;
import java.io.FileNotFoundException;


import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class DataProviderFromExcel {
	
	
	@Test(dataProvider ="getFromExcel")
	public void loginDetails(String str,String name) {
		System.out.println(str+" "+name);
	}

	@DataProvider
	public Object[][] getFromExcel() throws Throwable {
		FileInputStream fis = new FileInputStream("D:\\SUJOY_Qspider\\TekPyramidDocometsAPP\\dataproviderFile.xlsx");
		Workbook book =  WorkbookFactory.create(fis);
		Sheet sh =  book.getSheet("states");
	  DataFormatter df= new DataFormatter();
	    int lrow = sh.getLastRowNum()+1;
	    
	    	    
	    Object[][] ary = new Object[lrow][2];
	    for(int i=0; i<lrow;i++) {
	    	int lcell = sh.getRow(i).getLastCellNum();
	    	for(int j=0; j<lcell; j++) {
//	    ary[i][0]= df.formatCellValue(sh.getRow(i).getCell(0)); // first cell with all row
//	  	ary[i][1]= df.formatCellValue(sh.getRow(i).getCell(1));  // second cell with all row
	    		ary[i][j]= df.formatCellValue(sh.getRow(i).getCell(j));
	    }
	    }
	   
	    book.close();
	    return ary;
		
	}	

}
