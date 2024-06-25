package selenium.practiceTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class KeyBoardActionTest {
	@Test
	public void KeyBoardTest() throws Exception {
		WebDriver driver= new ChromeDriver();
		driver.get("https://demoapps.qspiders.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//p[text()='UI Testing Concepts']")).click();
		driver.findElement(By.xpath("//section[text()='Keyboard Actions']")).click();
		driver.findElement(By.xpath("//section[text()='Keyboard']")).click();
		WebElement keysperform= driver.findElement(By.xpath("//input[@id='email']"));
	//	sendKeys("Best4@gmail.com", Keys.TAB, "Epic@123",Keys.TAB, "Epic@123", Keys.ENTER);
		
		new Actions(driver)
		.sendKeys(keysperform, "Best4@gmail.com")
        .keyDown(Keys.TAB)
        .sendKeys("Epic@123")
        .keyDown(Keys.TAB)
        .sendKeys("Epic@123")
        .perform();
		
		
	}

}
