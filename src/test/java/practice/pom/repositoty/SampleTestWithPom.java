package practice.pom.repositoty;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class SampleTestWithPom {
	@FindBy(name="user_name")
	WebElement ele1;
	
	@FindBy(name="user_password")
	WebElement ele2;
	
	@FindAll({@FindBy(id="submitButton"), @FindBy(xpath = "//input[@type='submit']")}) //any one condition should satisfy (AutoHealing)
    private	WebElement ele3;
	
//	@FindBys({@FindBy(id="submitButto"), @FindBy(xpath = "//input[@type='submit']")})  // both findBy() condition should satisfy
//	private WebElement ele3;
	
	@Test
	public void testPom() {
		
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8888");
		
		 SampleTestWithPom p = PageFactory.initElements(driver,SampleTestWithPom.class);
		
		p.ele1.sendKeys("admin");
		p.ele2.sendKeys("root");
		
		driver.navigate().refresh();
		
		p.ele1.sendKeys("admin");
		p.ele2.sendKeys("root");
		p.ele3.click();
		
	}

}
