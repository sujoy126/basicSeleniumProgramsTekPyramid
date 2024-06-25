package selenium.practiceTest;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ScrollHandelingTest {
	@Test
	public void scrollTest() {
		WebDriver driver= new ChromeDriver();
		driver.get("https://demoapps.qspiders.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//p[text()='UI Testing Concepts']")).click();
		driver.findElement(By.xpath("//section[text()='Scroll']")).click();
		driver.findElement(By.xpath("(//section[text()='Scroll'])[2]")).click();
		driver.findElement(By.xpath("//a[text()='Open In New Tab']")).click();
		
		String mainid = driver.getWindowHandle();
		 Set<String> windows = driver.getWindowHandles();
		for(String windo: windows) {
			if(!windo.equals(mainid)){
			 driver.switchTo().window(windo);
			 String str = driver.getTitle();
			 System.out.println(str);
			}
		}
		
		WebElement we = driver.findElement(By.xpath("//h3[text()='b. Premium Materials']"));
		JavascriptExecutor jse =  (JavascriptExecutor)driver; 
			
			 jse.executeScript("arguments[0].scrollIntoView()",we ) ;
			
	}

}
