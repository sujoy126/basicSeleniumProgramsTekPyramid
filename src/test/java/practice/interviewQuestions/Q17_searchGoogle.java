package practice.interviewQuestions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Q17_searchGoogle {
	@Test
	public void seachGoogleTypwName() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.google.com/");
		driver.findElement(By.id("APjFqb")).sendKeys("sujoy");
		List<WebElement> l=  driver.findElements(By.xpath("//div[@class='mkHrUc']/descendant::li"));
	}
}
