package taskTest;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplictWaitMethods {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.numberOfElementsToBe(null, null));
	}

}
