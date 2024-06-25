package practiceDataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class SeleniumReadDataFromRunTime {
	@Test
	public void seleniumTest() throws IOException {
		//Read common data from property file
				// Get the java representation of physical file
				FileInputStream fis = new FileInputStream("D:\\SUJOY_Qspider\\TekPyramidDocometsAPP\\commonData.properties");
				
		  //	using properties class load all the keys.
				Properties pobj = new Properties();
				pobj.load(fis);
				
		  // Get the value based on key.
				String BROWSER = pobj.getProperty("Browser");
				String URL = pobj.getProperty("Url");
				String USERNAME =pobj.getProperty("UserName");
				String PASSWORD =pobj.getProperty("Password");
				
		   // Random numbers
				Random r = new Random();
				 int num = 10000;
				 int random = r.nextInt(num);
WebDriver driver =null;
		
		if(BROWSER.equals("chrome")){
			driver = new ChromeDriver();
		}
		else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		}
		else if(BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		}
		
		
		
	// Step 1: Login to app
		driver.get(URL); 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
	//step2 : navigate to organization module	
		driver.findElement(By.linkText("Organizations")).click();
		
		driver.quit();
	}
		


}
