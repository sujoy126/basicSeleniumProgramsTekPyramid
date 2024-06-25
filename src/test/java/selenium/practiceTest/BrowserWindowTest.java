package selenium.practiceTest;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BrowserWindowTest {
	@Test
	public void newWindow() {
		WebDriver driver= new ChromeDriver();
		driver.get("https://demoapps.qspiders.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	
		driver.findElement(By.xpath("//p[text()='UI Testing Concepts']")).click();
		driver.findElement(By.xpath("//section[text()='Popups']")).click();
		driver.findElement(By.xpath("//section[text()='Javascript']")).click();
		driver.findElement(By.xpath("//section[text()='Browser Windows']")).click();
		driver.findElement(By.xpath("//a[text()='Open in new window']")).click();
		
		String mainid = driver.getWindowHandle();
		 Set<String> windows = driver.getWindowHandles();
		for(String windo: windows) {
			if(!windo.equals(mainid)){
			 driver.switchTo().window(windo);
			 String str = driver.getTitle();
			 System.out.println(str);
			}
		}	
	}
	
	
	@Test
	public void newTabWindow() {
		WebDriver driver= new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://demoapps.qspiders.com/");
		driver.findElement(By.xpath("//p[text()='UI Testing Concepts']")).click();
		driver.findElement(By.xpath("//section[text()='Popups']")).click();
		driver.findElement(By.xpath("//section[text()='Browser Windows']")).click();
		driver.findElement(By.xpath("//a[text()='New Tab']")).click();
		driver.findElement(By.xpath("//button[text()='Open window in new Tab']")).click();
		
		String mainid = driver.getWindowHandle();
		 Set<String> windows = driver.getWindowHandles();
		for(String windo: windows) {
			if(!windo.equals(mainid)){
			 driver.switchTo().window(windo);
			 String str = driver.getTitle();
			 System.out.println(str);
			}
		}
		driver.findElement(By.id("email")).sendKeys("Abcdefgh");
	
	}

}
