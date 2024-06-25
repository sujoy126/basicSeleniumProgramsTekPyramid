package selenium.practiceTest;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DatePickierTest {
	@Test
	public void dateTest() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoapps.qspiders.com/ui/datePick?sublist=0");
		driver.findElement(By.xpath("//td[@data='2024-01-01']")).click();
		
		Date dt = new Date();
		System.out.println(dt);
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(sim.format(dt));
		
	}

}
