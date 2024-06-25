package selenium.practiceTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class MouseHoverActionTest {
	@Test
	public void MouseHoverTest() throws Exception {
		WebDriver driver= new ChromeDriver();
		driver.get("https://demoapps.qspiders.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	
		driver.findElement(By.xpath("//p[text()='UI Testing Concepts']")).click();
		driver.findElement(By.xpath("//section[text()='Mouse Actions']")).click();
		driver.findElement(By.xpath("//section[text()='Mouse Hover']")).click();
		WebElement hover= driver.findElement(By.xpath("//img[@src='/assets/message-hint-J20Zlhln.png']"));
		
		Actions act = new Actions(driver);
		act.moveToElement(hover).perform();
	}
	
	
	
}
