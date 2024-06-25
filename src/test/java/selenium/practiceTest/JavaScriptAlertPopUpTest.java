package selenium.practiceTest;

import java.time.Duration;

import org.junit.experimental.theories.suppliers.TestedOn;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class JavaScriptAlertPopUpTest {
	@Test
	public void alertPopUps() {
		WebDriver driver= new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://demoapps.qspiders.com/");
		driver.findElement(By.xpath("//p[text()='UI Testing Concepts']")).click();
		driver.findElement(By.xpath("//section[text()='Popups']")).click();
		driver.findElement(By.xpath("//section[text()='Javascript']")).click();
		driver.findElement(By.xpath("//button[contains(@id,'buttonAlert')]")).click();
		Alert alt = driver.switchTo().alert();
		alt.accept();
	}
	
	@Test
	public void confermAlertPopUps() throws Exception {
		WebDriver driver= new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://demoapps.qspiders.com/");
		driver.findElement(By.xpath("//p[text()='UI Testing Concepts']")).click();
		driver.findElement(By.xpath("//section[text()='Popups']")).click();
		driver.findElement(By.xpath("//section[text()='Javascript']")).click();
		driver.findElement(By.xpath("//a[text()='Confirm']")).click();
		driver.findElement(By.xpath("//button[text()='Confirm Box']")).click();
//		driver.findElement(By.xpath("//button[contains(@id,'buttonAlert')]")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().dismiss();
	
	}
	
	
	@Test
	public void promptAlertPopUps() throws Exception {
		WebDriver driver= new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://demoapps.qspiders.com/");
		driver.findElement(By.xpath("//p[text()='UI Testing Concepts']")).click();
		driver.findElement(By.xpath("//section[text()='Popups']")).click();
		driver.findElement(By.xpath("//section[text()='Javascript']")).click();
		
		driver.findElement(By.xpath("//a[text()='Prompt']")).click();
		driver.findElement(By.xpath("//button[text()='Prompt Alert Box']")).click();
		
		Alert alt= driver.switchTo().alert();
		alt.sendKeys("yes");
		alt.accept();
	
	}
	

}
