package taskTest;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class NoonwebPageAppleTest {
	@Test
	public void AppleNameFetchTest() throws InterruptedException, AWTException, EncryptedDocumentException, IOException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.noon.com/uae-en/");
		
		
		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//		 WebElement we= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='sc-fKWMtX bzokpP']")));
////			WebElement we= driver.findElement(By.xpath("//h2[text()='Recommended for you']"));
////		 WebElement we= driver.findElement(By.xpath("//div[@class='sc-fKWMtX bzokpP']"));
//
//		JavascriptExecutor jse = (JavascriptExecutor)driver;
////		 jse.executeScript("arguments[0].scrollIntoView()",we );
//		jse.executeScript("window.scrollBy(0,1500)");
//	//	 System.out.println("======execute=====");
//	//	 driver.quit();
		
//		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//         WebElement recommendedSection = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Recommended for you']")));
//         ((ChromeDriver) driver).executeScript("arguments[0].scrollIntoView(true);", recommendedSection);
//
//         // Scroll to load all products
//         for (int i = 0; i < 10; i++) {
//             ((ChromeDriver) driver).executeScript("window.scrollBy(0,1000);");
//             Thread.sleep(1000);
		
//		Robot r = new Robot();
//		r.keyPress(KeyEvent.VK_DOWN);
//		r.keyPress(KeyEvent.VK_DOWN);
//		r.keyPress(KeyEvent.VK_DOWN);
//		r.keyPress(KeyEvent.VK_DOWN);
//		r.keyRelease(KeyEvent.VK_DOWN);
//		r.keyPress(KeyEvent.VK_DOWN);
//		r.keyRelease(KeyEvent.VK_DOWN);
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,900);");
		
		List<WebElement> elements = driver.findElements(By.xpath("//div[@class='sc-fKWMtX jPgkAQ']/div/div/div/div/div/a/div/div/div/following-sibling::div//div[@data-qa='product-name']"));
		System.out.println(elements);
		 
		FileInputStream fis =new FileInputStream("D:\\SUJOY_Qspider\\TekPyramidDocometsAPP\\testScriptData.xlsx");
		Workbook book = WorkbookFactory.create(fis);
        Sheet sheet = book.getSheet("Apple Products");
        
        int row =0;
        for(WebElement ele: elements) {
        	String productName= ele.getText();
        	if(productName.contains("Apple")) {
        		sheet.createRow(row++).createCell(0).setCellValue(productName);
        	}
        }
        
        FileOutputStream fos = new FileOutputStream("D:\\\\SUJOY_Qspider\\\\TekPyramidDocometsAPP\\\\testScriptData.xlsx");
        book.write(fos);
        book.close();
        
        System.out.println("====executed=======");
		 
	}

}
