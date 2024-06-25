package selenium.practiceTest;

import java.awt.AWTException;
import java.sql.DriverManager;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class IFrameTest {
	@Test
	public void IFramessTest() throws Exception {
		WebDriver driver= new ChromeDriver();
		driver.get("https://demoapps.qspiders.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	
		driver.findElement(By.xpath("//p[text()='UI Testing Concepts']")).click();
		driver.findElement(By.xpath("//section[text()='Frames']")).click();
		driver.findElement(By.xpath("//section[text()='iframes']")).click();
		WebElement we = driver.findElement(By.xpath("//iframe[@class='w-full h-96']"));
		
		driver.switchTo().frame(we);
		driver.findElement(By.id("username")).sendKeys("abcdefghi", Keys.TAB,"Pqrst123");		
	}
	
	@Test
	public static void nestedIFrameTest() throws InterruptedException {
		WebDriver driv=new ChromeDriver();
		driv.manage().window().maximize();
		driv.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		driv.get("https://demoapps.qspiders.com/ui/frames/nested?sublist=1");
		driv.switchTo().frame(driv.findElement(By.tagName("iframe")));//window to iframe
		driv.switchTo().frame(driv.findElement(By.tagName("iframe")));//parent iframe to child
		driv.findElement(By.id("email")).sendKeys("Admin@gmail.com");
		driv.findElement(By.id("password")).sendKeys("Admin@1234");
		driv.findElement(By.id("confirm-password")).sendKeys("Admin@1234");
		driv.findElement(By.id("submitButton")).submit();
		Thread.sleep(2000);
		driv.quit();
		System.out.println("=====Done=====");
	
		}
	
	@Test
	public static void multipleIFrameTest() throws InterruptedException, AWTException {
		WebDriver driv=new ChromeDriver();
		driv.manage().window().maximize();
		driv.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		driv.get("https://demoapps.qspiders.com/ui/frames/multiple?sublist=2");
		
		Thread.sleep(2000);
		driv.switchTo().frame(driv.findElement(By.tagName("iframe")));	
		driv.findElement(By.id("email")).sendKeys("Admin@gmail.com");
		driv.findElement(By.id("password")).sendKeys("Admin@1234");
		driv.findElement(By.id("confirm-password")).sendKeys("Admin@1234");
		driv.findElement(By.id("submitButton")).submit();
		driv.switchTo().parentFrame();
		
		Thread.sleep(2000);
		driv.switchTo().frame(driv.findElement(By.xpath("(//iframe)[2]")));
		driv.findElement(By.id("username")).sendKeys("Admin@gmail.com");
		driv.findElement(By.id("password")).sendKeys("SuperAdmin@1234");
		driv.findElement(By.id("submitButton")).submit();
		Thread.sleep(2000);
		driv.quit();
	}
	
	@Test
	public static void nestedWithMultipleiFrame() throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		driver.get("https://demoapps.qspiders.com/ui/frames/nestedWithMultiple?sublist=3");
		
		Thread.sleep(3000);
		
		driver.switchTo().frame(0);
		String email=driver.findElement(By.xpath("(//p[@class='para'])[1]")).getText();
		String password=driver.findElement(By.xpath("(//p[@class='para'])[2]")).getText();
		String confirm=driver.findElement(By.xpath("(//p[@class='para'])[3]")).getText();
		driver.switchTo().frame(0);
		driver.switchTo().frame(0);
		
		driver.findElement(By.id("email")).sendKeys(email);
		driver.switchTo().parentFrame();
		driver.switchTo().frame(1);
		
		driver.findElement(By.id("password")).sendKeys(password);
		driver.switchTo().parentFrame();
		driver.switchTo().frame(2);
	
		driver.findElement(By.id("confirm")).sendKeys(confirm);
		driver.switchTo().parentFrame();
		driver.switchTo().frame(3);
		Thread.sleep(2000);
		driver.findElement(By.id("submitButton")).click();
		Thread.sleep(4000);
		System.out.println("======Done======");
		driver.quit();
	}

}
