package selenium.practiceTest;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FileUploadsTest {
	@Test
	public void promptAlertPopUps() throws Exception {
		WebDriver driver= new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://demoapps.qspiders.com/");
		driver.findElement(By.xpath("//p[text()='UI Testing Concepts']")).click();
		driver.findElement(By.xpath("//section[text()='Popups']")).click();
		
		driver.findElement(By.xpath("//section[text()='File Uploads']")).click();
        driver.findElement(By.id("fileInput")).click();
		
		StringSelection copy = new StringSelection("D:\\SUJOY_Qspider\\TekPyramidDocometsAPP\\FileUpload\\uploadFile.txt");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(copy, null);
		
		Thread.sleep(2000);
		

		
	}

}
