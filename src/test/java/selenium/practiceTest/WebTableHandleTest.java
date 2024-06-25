package selenium.practiceTest;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class WebTableHandleTest {
	@Test
	public void staticWebTable() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://demoapps.qspiders.com/");
		driver.findElement(By.xpath("//p[text()='UI Testing Concepts']")).click();
		driver.findElement(By.xpath("//section[text()='Web Table']")).click();
		WebElement tableElement = driver.findElement(By.tagName("table"));
		List<WebElement> rows=tableElement.findElements(By.tagName("tr"));
		
		
 // Specify the row index you want to fetch (for example, the second row)
        int rowIndex = 2; // Index is zero-based
            WebElement row = rows.get(rowIndex);
 // Fetch all cells in the row
            List<WebElement> cells = row.findElements(By.tagName("th"));
            WebElement ele= driver.findElement(By.xpath("//th[text()='Levis Shirt']/following-sibling::td[4]"));
              String s= ele.getText();
 // Print the data of the row
            for (WebElement cell : cells) {
                System.out.print(cell.getText() + " "+ s+"\t");
            }
        
		
			   
		      driver.quit();
		
	}
	
	//@Test
	public void DynamicWbTable() throws InterruptedException {
		
		WebDriver driver= new ChromeDriver();
		driver.get("https://demoapps.qspiders.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://demoapps.qspiders.com/");
		driver.findElement(By.xpath("//p[text()='UI Testing Concepts']")).click();
		driver.findElement(By.xpath("//section[text()='Web Table']")).click();
	//	driver.findElement(By.xpath("//a[text()='Dynamic Web Table']")).click();
		Thread.sleep(3000);
		WebElement tableData= driver.findElement(By.xpath("//a[@aria-current='page'][1]"));
		 List<WebElement> tableheaders = tableData.findElements(By.tagName("th"));
		 List<String> headerDatas= new ArrayList<String>();
		 for(WebElement heading : tableheaders) {
			 String headerData = heading.getText();
			 headerDatas.add(headerData);
		 }
		 String colmnNeame = "Price";
				int colmnIndex= headerDatas.indexOf(colmnNeame);
			  List<WebElement> colmdatas = tableData.findElements(By.xpath("//td["+(colmnIndex+1)+"]"));
			 for(WebElement comdata: colmdatas) {
				 System.out.println(comdata.getText());
			 }
		
		List<WebElement> colmns = driver.findElements(By.xpath("//th[@scope='row']/../td[4]"));
		for(WebElement colmn : colmns) {
			String data= colmn.getText();
			System.out.println(data);
		}
		
	}

	
	@Test
	public void dynamicWebTeble() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://demoapps.qspiders.com");
		driver.findElement(By.xpath("//p[text()='UI Testing Concepts']")).click();
		driver.findElement(By.xpath("//section[text()='Web Table']")).click();
		driver.findElement(By.xpath("//a[text()='Dynamic Web Table']")).click();
		Thread.sleep(3000);
		List<WebElement>colmelement= driver.findElements(By.xpath("//th[@scope='row']/following-sibling::td[4]"));
		System.out.println(colmelement.size());
		
		for(WebElement colmn: colmelement) {
			String data= colmn.getText();
			System.out.println(data);
		}	
	}
	
	
	
	@Test
	public void tableWithSort() throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://demoapps.qspiders.com");
		driver.findElement(By.xpath("//p[text()='UI Testing Concepts']")).click();
		driver.findElement(By.xpath("//section[text()='Web Table']")).click();
		driver.findElement(By.xpath("//a[@href='/ui/table/tableSort']")).click();
		Thread.sleep(2000);
		List<WebElement> sumsungRow= driver.findElements(By.xpath("//th[text()='SAMSUNG Galaxy']/../td"));
		for(WebElement row: sumsungRow) {
			System.out.println(row.getText());
		}
		driver.quit();
	}
	
	
	@Test
	public void tablePagination() throws Exception {
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://demoapps.qspiders.com");
		driver.findElement(By.xpath("//p[text()='UI Testing Concepts']")).click();
		 driver.findElement(By.xpath("//section[text()='Web Table']")).click();
		driver.findElement(By.xpath("//a[@href='/ui/table/tablePagination']")).click();
		Thread.sleep(3000);
		List<WebElement> qualitycolmns= driver.findElements(By.xpath("//th[@scope='row']/following-sibling::td[2]"));
		for(WebElement qcolmnData: qualitycolmns) {
			System.out.println(qcolmnData.getText());
		}
	}
	
	
	@Test
	public void tableWithCheck() throws Exception {
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://demoapps.qspiders.com");
		driver.findElement(By.xpath("//p[text()='UI Testing Concepts']")).click();
		 driver.findElement(By.xpath("//section[text()='Web Table']")).click();
		driver.findElement(By.xpath("//a[@href='/ui/table/tableWithCheck']")).click();
		Thread.sleep(3000);
		List<WebElement> checkBoxHevyEnvy= driver.findElements(By.xpath("(//input[@type='checkbox']/..)[4]/following-sibling::td"));
		for(WebElement checkBoHEData: checkBoxHevyEnvy) {
			String data= checkBoHEData.getText();
			System.out.print(data+"\t");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
