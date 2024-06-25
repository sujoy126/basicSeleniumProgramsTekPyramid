package selenium.practiceTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class MoucseActionsTest {
	@Test
	public void DragAndDropTest() throws Exception {
		WebDriver driver= new ChromeDriver();
		driver.get("https://demoapps.qspiders.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//p[text()='UI Testing Concepts']")).click();
		driver.findElement(By.xpath("//section[text()='Mouse Actions']")).click();
		driver.findElement(By.xpath("//section[text()='Drag & Drop']")).click();
		WebElement dragItem=  driver.findElement(By.xpath("//div[text()='Drag Me']"));
		
		Thread.sleep(2000);
		Actions act = new Actions(driver);
		act.dragAndDropBy(dragItem, 200,100).perform();
	
		
		
	}
	
	
		@Test
		public void DragPositionTest() throws Exception {
			WebDriver driver= new ChromeDriver();
			driver.get("https://demoapps.qspiders.com/");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().window().maximize();
			driver.get("https://demoapps.qspiders.com/");
			driver.findElement(By.xpath("//p[text()='UI Testing Concepts']")).click();
			driver.findElement(By.xpath("//section[text()='Mouse Actions']")).click();
			driver.findElement(By.xpath("//section[text()='Drag & Drop']")).click();
			driver.findElement(By.xpath("//a[text()='Drag Position']")).click();
			
			
			WebElement dragmobileCharger=  driver.findElement(By.xpath("//div[text()='Mobile Charger']"));
			WebElement dropMobileCharger=  driver.findElement(By.xpath("//div[@class='drop-column  min-h-[200px] bg-slate-100']"));
			
			WebElement dragmobileCover=  driver.findElement(By.xpath("//div[text()='Mobile Cover']"));
			WebElement dropMobileCover=  driver.findElement(By.xpath("//div[@class='drop-column  min-h-[200px] bg-slate-100']"));
			
			WebElement dragLaptopCharger=  driver.findElement(By.xpath("//div[text()='Laptop Charger']"));
			WebElement dropLaptopCharger=  driver.findElement(By.xpath("//div[@class='drop-column min-h-[200px] bg-slate-100']"));
		    
			WebElement dragLaptopCover=  driver.findElement(By.xpath("//div[text()='Laptop Cover']"));
			WebElement dropLaptopCover=  driver.findElement(By.xpath("//div[@class='drop-column min-h-[200px] bg-slate-100']"));
		
			Thread.sleep(2000);
			Actions act = new Actions(driver);
			act.dragAndDrop(dragmobileCharger,dropMobileCharger).perform();
			act.dragAndDrop(dragmobileCover,dropMobileCover).perform();
			act.dragAndDrop(dragLaptopCharger,dropLaptopCharger).perform();
			act.dragAndDrop(dragLaptopCover,dropLaptopCover).perform();
		}
		
		
		
		@Test
		public void DragMultipleTest() throws Exception {
			WebDriver driver= new ChromeDriver();
			driver.get("https://demoapps.qspiders.com/");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().window().maximize();
			
			driver.findElement(By.xpath("//p[text()='UI Testing Concepts']")).click();
			driver.findElement(By.xpath("//section[text()='Mouse Actions']")).click();
			driver.findElement(By.xpath("//section[text()='Drag & Drop']")).click();
			driver.findElement(By.xpath("//a[text()='Drag Multiple']")).click();
			
			
			WebElement dragmobileCharger=  driver.findElement(By.xpath("//div[text()='Mobile Charger']"));
			WebElement dragmobileCover=  driver.findElement(By.xpath("//div[text()='Mobile Cover']"));

			WebElement dropMobileCharger=  driver.findElement(By.xpath("//div[@class='drop-column  min-h-[200px] bg-slate-100']"));
			
			WebElement dropMobileCover=  driver.findElement(By.xpath("//div[@class='drop-column  min-h-[200px] bg-slate-100']"));
			
			WebElement dragLaptopCharger=  driver.findElement(By.xpath("//div[text()='Laptop Charger']"));
			WebElement dropLaptopCharger=  driver.findElement(By.xpath("//div[@class='drop-column min-h-[200px] bg-slate-100']"));
		    
			WebElement dragLaptopCover=  driver.findElement(By.xpath("//div[text()='Laptop Cover']"));
			WebElement dropLaptopCover=  driver.findElement(By.xpath("//div[@class='drop-column min-h-[200px] bg-slate-100']"));
		
			Thread.sleep(2000);
			Actions act = new Actions(driver);
			act.dragAndDrop(dragmobileCharger,dropMobileCharger).perform();
			act.dragAndDrop(dragmobileCover,dropMobileCover).perform();
			act.dragAndDrop(dragLaptopCharger,dropLaptopCharger).perform();
			act.dragAndDrop(dragLaptopCover,dropLaptopCover).perform();
		}
		
		
		
		
		
		
		
		

}
