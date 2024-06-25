package taskTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FlipkartFashionTest {
	public static void main(String[] args) throws Throwable {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		
		Actions act = new Actions(driver);
		WebElement we = driver.findElement(By.xpath("//div[@aria-label='Fashion']"));	
		act.moveToElement(we).perform();
		
		WebElement we2= driver.findElement(By.xpath("//a[@class='_1BJVlg _11MZbx']"));
		act.moveToElement(we2).perform();
		
		List<WebElement> mensTopWear= driver.findElements(By.xpath("//div[@class='_31z7R_']/object/div/following-sibling::a"));
		System.out.println(mensTopWear.size());
		
		
		
		FileInputStream f = new FileInputStream("D:\\SUJOY_Qspider\\TekPyramidDocometsAPP\\HomeWorkData.xlsx");
	    Workbook book = WorkbookFactory.create(f);
	    Sheet sh = book.getSheet("filpCardmansTOpWear");
	    int i=0;
		
		for (WebElement prod : mensTopWear) {
			
			System.out.println(prod.getText());
			Row row=sh.createRow(i++);
			Cell cel=row.createCell(0);
			cel.setCellValue(prod.getText().toString());
		
		}
		
		book.write(new FileOutputStream("D:\\\\SUJOY_Qspider\\\\TekPyramidDocometsAPP\\\\HomeWorkData.xlsx"));
		book.close();
	    
		
	}

}
