package selenium.practiceTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CheckBoxTest {
	@Test
	public void checkBox() {
		WebDriver driver= new ChromeDriver();
		driver.get("https://demoapps.qspiders.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//p[text()='UI Testing Concepts']")).click();
		driver.findElement(By.xpath("//section[text()='Check Box']")).click();
		WebElement checkBox= driver.findElement(By.xpath("//input[contains(@id,'domain')]"));
		checkBox.click();
		checkBox.sendKeys( Keys.TAB, Keys.SPACE,Keys.TAB, Keys.SPACE, Keys.TAB, Keys.SPACE,Keys.TAB, Keys.SPACE,
				Keys.TAB, Keys.SPACE,Keys.TAB, Keys.SPACE,Keys.TAB, Keys.SPACE,Keys.TAB, Keys.SPACE
				,Keys.TAB, Keys.SPACE);
	//	checkBox.submit();
	}

}

