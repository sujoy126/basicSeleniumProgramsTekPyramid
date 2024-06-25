package selenium.practiceTest;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class DropDownTest {
	@Test
	public void singleSelectTest() throws InterruptedException {
		WebDriver driver= new ChromeDriver();
		driver.get("https://demoapps.qspiders.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://demoapps.qspiders.com/");
		driver.findElement(By.xpath("//p[text()='UI Testing Concepts']")).click();
		driver.findElement(By.xpath("//section[text()='Dropdown']")).click();
		Thread.sleep(2000);
		WebElement selectElement= driver.findElement(By.xpath("(//select[contains(@id,'select')])[2]"));
		
		Select s = new Select(selectElement);
		 s.selectByVisibleText("Male");
		 
	}
	
	
	
	@Test
	public void multiSelectTest() throws InterruptedException {
		WebDriver driver= new ChromeDriver();
		driver.get("https://demoapps.qspiders.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://demoapps.qspiders.com/");
		driver.findElement(By.xpath("//p[text()='UI Testing Concepts']")).click();
		driver.findElement(By.xpath("//section[text()='Dropdown']")).click();
		driver.findElement(By.xpath("//a[text()='Multi Select']")).click();
	
		WebElement genderElement= driver.findElement(By.xpath("//select[@placeholder='Select Gender']"));
		Select g = new Select(genderElement);
		 g.selectByVisibleText("Male");
		
		 
		 Thread.sleep(2000);
		 WebElement countryElement= driver.findElement(By.id("select-multiple-native"));
			Select c = new Select(countryElement);
			 c.selectByValue("India");
			 
			 Thread.sleep(2000);
			 WebElement stateElement= driver.findElement(By.xpath("(//select[@id='select-multiple-native'])[2]"));
				Select s = new Select(stateElement);
				 s.selectByValue("West Bengal");
				 
				 Thread.sleep(2000);
				 WebElement cityElement= driver.findElement(By.xpath("(//select[@id='select-multiple-native'])[3]"));
					Select city = new Select(cityElement);
					 city.selectByIndex(0);
			 
	}
	
	
	
	@Test
	public void searchWithSelectTest() throws InterruptedException, AWTException {
		WebDriver driver= new ChromeDriver();
		driver.get("https://demoapps.qspiders.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://demoapps.qspiders.com/");
		driver.findElement(By.xpath("//p[text()='UI Testing Concepts']")).click();
		driver.findElement(By.xpath("//section[text()='Dropdown']")).click();
		driver.findElement(By.xpath("//a[text()='Search With Select']")).click();
		
		driver.findElement(By.xpath("(//div[@class=' css-hlgwow'])[2]")).click();
		
		Robot r = new Robot();
		
		
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	

}
