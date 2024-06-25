package practice.pom.repositoty;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SampleTestWithOutPom {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8888");
		WebElement we1 = driver.findElement(By.name("user_name"));
		WebElement we2 = driver.findElement(By.name("user_password"));
		WebElement we3 = driver.findElement(By.id("submitButton"));
		
		we1.sendKeys("admin");
		we2.sendKeys("root");
		
		driver.navigate().refresh();
		
		we1.sendKeys("admin");
		we2.sendKeys("root");
		we3.click();
		
	}

}
