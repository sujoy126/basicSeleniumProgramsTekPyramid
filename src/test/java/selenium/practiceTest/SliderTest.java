package selenium.practiceTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class SliderTest {
	@Test
	public void sliderDragTest() {
		WebDriver driver= new ChromeDriver();
		driver.get("https://demoapps.qspiders.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	
		driver.findElement(By.xpath("//p[text()='UI Testing Concepts']")).click();
		
		driver.findElement(By.xpath("//a[@href=\"/ui/slider\"]")).click();
		WebElement sliderElement = driver.findElement(By.className("rangeInputSlidebar"));
		Actions act = new Actions(driver);
		act.dragAndDropBy(sliderElement,500, 0).perform();
		
	}

}
