package taskTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class PracticeCombindPropertyFileAndExcelFile {
	public static void main(String[] args) throws Throwable {
		FileInputStream fis = new FileInputStream("D:\\SUJOY_Qspider\\TekPyramid\\SeleniumCRMGUIFrameWork\\alphabate.properties");
		Properties pobj = new Properties();
		pobj.load(fis);
//		String key1= pobj.getProperty("key1");
//		String key2= pobj.getProperty("key2");
//		String key3= pobj.getProperty("key3");
//		String key4= pobj.getProperty("key4");
	  
	    
	    
	    
	    FileInputStream f = new FileInputStream("D:\\SUJOY_Qspider\\TekPyramidDocometsAPP\\testScriptData.xlsx");
	    Workbook bok = WorkbookFactory.create(f);
	    Sheet sheet3 = bok.getSheet("Sheet3");

	    
      // add properties data in excel sheet3   
	    int rowNum=0; 
	    for(String key: pobj.stringPropertyNames()) {
	    	Row row = sheet3.createRow(rowNum++);
	    	row.createCell(0).setCellValue(pobj.getProperty(key));    	
	    }
         
         
         
      // Get the data from sheet2 and Write data in Excel Sheet3
        
         List<String > data = new ArrayList<String>();
 //        FileInputStream fis1 = new FileInputStream("D:\\SUJOY_Qspider\\TekPyramidDocometsAPP\\testScriptData.xlsx");
  //	    Workbook book = WorkbookFactory.create(fis1);
  	    Sheet sh = bok.getSheet("Sheet2");
  	  List<String > readwdata = new ArrayList<String>();
  	  for(Row row : sh) {
  		  for(Cell cel :row) {
  			 readwdata.add(cel.toString());
  		  }
  		  data.addAll(readwdata);
  		 
  	  }
  	  // write the excel data in sheet3
  	    
  	    for(String writeata : readwdata) {
  	    	Row row = sheet3.createRow(rowNum++);
  	    	int cellNum =0; 
  	    	row.createCell(cellNum++).setCellValue(writeata);
  	    }
  	    
              
	    FileOutputStream fo = new FileOutputStream("D:\\SUJOY_Qspider\\TekPyramidDocometsAPP\\testScriptData.xlsx");
		bok.write(fo);
		fo.close();
		System.out.println("==============execute=========");
		bok.close();
		

         fis.close();
             
             fo.close();
             bok.close();
	}

}
