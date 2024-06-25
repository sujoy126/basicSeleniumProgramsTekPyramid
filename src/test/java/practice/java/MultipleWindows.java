package practice.java;

import java.util.Set;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleWindows {
	public static void main(String[] args) {
		WebDriver driver= new ChromeDriver();
		driver.get("https://google.com");
		for(int i=1; i<=5; i++) {
		driver.switchTo().newWindow(WindowType.TAB);
		}
		Set<String> allWindow = driver.getWindowHandles();
		
	}

}
