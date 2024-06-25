package taskTest;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IrctcSelectDestinationTest {
	public static void main(String[] args) throws Throwable {
		
		ChromeOptions cop = new ChromeOptions();
		cop.addArguments("--disable-notifications");
		
		WebDriver driver = new ChromeDriver(cop);
		driver.manage().window().maximize();
		driver.get("https://www.irctc.co.in/nget/train-search");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		// from bengaluru
		Thread.sleep(3000);
		WebElement from =  driver.findElement(By.xpath("//span[@class='ng-tns-c57-8 ui-autocomplete ui-widget']/input"));
		from.sendKeys("sbc");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(from));
			
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
		//to hyderabad
		Thread.sleep(3000);
		WebElement to =  driver.findElement(By.xpath("//span[@class='ng-tns-c57-9 ui-autocomplete ui-widget']/input"));
		to.sendKeys("hyd");
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait2.until(ExpectedConditions.visibilityOf(to));
			
		Robot r1 = new Robot();
		r1.keyPress(KeyEvent.VK_ENTER);
		r1.keyRelease(KeyEvent.VK_ENTER);
		
		Thread.sleep(3000);
		WebElement date =  driver.findElement(By.xpath("//span[@class='ng-tns-c58-10 ui-calendar']/input"));
	
		
		
	}

}


//div[@class='col-sm-9 col-xs-12']/descendant::div[@class='form-group no-pad col-xs-12 bull-back border-all']