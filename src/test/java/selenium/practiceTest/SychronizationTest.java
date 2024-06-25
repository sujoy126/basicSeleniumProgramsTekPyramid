package selenium.practiceTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class SychronizationTest {
	@Test
	public void sychroniesTest() {
		WebDriver driver= new ChromeDriver();
		driver.get("https://demoapps.qspiders.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://demoapps.qspiders.com/");
		driver.findElement(By.xpath("//p[text()='UI Testing Concepts']")).click();
		driver.findElement(By.xpath("//section[text()='Synchronization']")).click();
		driver.findElement(By.xpath("//section[text()='Progress Bar']")).click();
		driver.findElement(By.xpath("//button[text()='Start']")).click();
		
	}
	
	
	@Test
	public void sychroniesWithTimeTest() {
		WebDriver driver= new ChromeDriver();
		driver.get("https://demoapps.qspiders.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://demoapps.qspiders.com/");
		driver.findElement(By.xpath("//p[text()='UI Testing Concepts']")).click();
		driver.findElement(By.xpath("//section[text()='Synchronization']")).click();
		driver.findElement(By.xpath("//section[text()='Progress Bar']")).click();
		driver.findElement(By.xpath("//a[text()='With Timer']")).click();
		
		driver.findElement(By.xpath("//input[@placeholder='Enter time in seconds']")).sendKeys("10", Keys.TAB, Keys.ENTER);
	}
	
	
	@Test
	public void sychroniesWithElementTest() {
		WebDriver driver= new ChromeDriver();
		driver.get("https://demoapps.qspiders.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	
		driver.findElement(By.xpath("//p[text()='UI Testing Concepts']")).click();
		driver.findElement(By.xpath("//section[text()='Synchronization']")).click();
		driver.findElement(By.xpath("//section[text()='Progress Bar']")).click();
		driver.findElement(By.xpath("//a[text()='With Element']")).click();
		
		
		
		driver.findElement(By.xpath("//input[@placeholder='Enter time in seconds']")).sendKeys("2", Keys.TAB, Keys.ENTER);
		
		WebElement we = driver.findElement(By.xpath("//select[contains(@class,'border-0 px-3 py-3')]"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(we));
		
		Select s =new Select(we);
		s.selectByIndex(1);
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
