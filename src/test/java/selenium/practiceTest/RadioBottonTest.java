package selenium.practiceTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class RadioBottonTest {
	@Test
	public void defultTest() {
		WebDriver driver= new ChromeDriver();
		driver.get("https://demoapps.qspiders.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://demoapps.qspiders.com/");
		driver.findElement(By.xpath("//p[text()='UI Testing Concepts']")).click();
		driver.findElement(By.xpath("//section[text()='Radio Button']")).click();
		driver.findElement(By.cssSelector("input[value='Upi']")).click();
		driver.findElement(By.cssSelector("input[value='home']")).click();
		driver.findElement(By.id("btn")).submit();
	}
	
	
	
	@Test
	public void selectedTest() {
		WebDriver driver= new ChromeDriver();
		driver.get("https://demoapps.qspiders.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://demoapps.qspiders.com/");
		driver.findElement(By.xpath("//p[text()='UI Testing Concepts']")).click();
		driver.findElement(By.xpath("//section[text()='Radio Button']")).click();
		driver.findElement(By.xpath("//a[text()='Selected']")).click();
		driver.findElement(By.cssSelector("button[type='submit']")).submit();
	}
	
	

}
