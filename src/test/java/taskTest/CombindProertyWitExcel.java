package taskTest;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class CombindProertyWitExcel {
	public static void main(String[] args) throws IOException {
		
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
	     
//	     Row headerRow = sheet3.createRow(0);
//         Cell headerCell1 = headerRow.createCell(0);
//         headerCell1.setCellValue(key1);
//         
//
//         Row dataRow1 = sheet3.createRow(1);
//         Cell dataCell1 = dataRow1.createCell(0);
//         dataCell1.setCellValue(key2);
//         
//         Row dataRow2 = sheet3.createRow(2);
//         Cell dataCell2 = dataRow2.createCell(0);
//         dataCell2.setCellValue(key3);
//         
//         Row dataRow3 = sheet3.createRow(3);
//         Cell dataCell3 = dataRow3.createCell(0);
//         dataCell3.setCellValue(key4);
	    
	    
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
