package selenium.practiceTest;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class NotificationPopupTest {
	@Test
	public void authenticationTest() throws InterruptedException {
		ChromeOptions cop = new ChromeOptions();
		cop.addArguments("--disable-notification");
		WebDriver driver= new ChromeDriver(cop);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		driver.get("https://demoapps.qspiders.com/ui/browserNot?sublist=0");

		
	}
	

}
