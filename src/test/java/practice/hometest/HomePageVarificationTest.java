package practice.hometest;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageVarificationTest {
	@Test
	public void homePageTest(Method mtd) {
		System.out.println(mtd.getName() + "test Start ");
		String expectedTitle = "Home Page";

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost:8888");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("root");
		driver.findElement(By.id("submitButton")).click();

		String actualTitle = driver.findElement(By.xpath("//a[contains(.,'Home')]")).getText();
		
		//Hard Assert
		Assert.assertEquals (actualTitle, expectedTitle);
			
//		if (actualTitle.trim().equals(expectedTitle)) {
//			System.out.println(expectedTitle + " title is verified ===pass==");
//		} else
//			System.out.println(expectedTitle + " title is not verified ==fail==");

		driver.close();
		System.out.println(mtd.getName() + " test end ");
	}

	@Test
	public void verifyLogoHomePageTest(Method mtd) {
		System.out.println(mtd.getName() + "test Start ");

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost:8888");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("root");
		driver.findElement(By.id("submitButton")).click();

		boolean status = driver.findElement(By.xpath("//img[@title='vtiger-crm-logo.gif']")).isEnabled();
		//Hard Assert
		Assert.assertTrue(status);
		
//		if (status) {
//			System.out.println(" logo is verified ===pass==");
//		} else
//			System.out.println(" logo is not verified ==fail==");

		driver.close();
		System.out.println(mtd.getName() + " test end ");

	}

}
