package practice.contactTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CreateContactWithOrgTest {
	public static void main(String[] args) throws Exception {
		
		FileInputStream fis = new FileInputStream("D:\\SUJOY_Qspider\\TekPyramidDocometsAPP\\commonData.properties");
		Properties pobj = new Properties();
		pobj.load(fis);
		String BROWSER= pobj.getProperty("Browser");
		String URL= pobj.getProperty("Url");
		String USERNAME= pobj.getProperty("UserName");
		String PASSWORD= pobj.getProperty("Password");
		
		
		
		// Random numbers
		Random r = new Random();
		 int num = 10000;
		 int random = r.nextInt(num);
		
	//Read Test script data from Excel Sheet
		FileInputStream Fis = new FileInputStream("D:\\SUJOY_Qspider\\TekPyramidDocometsAPP\\testScriptData.xlsx");
		Workbook book = WorkbookFactory.create(Fis);
		Sheet sh =book.getSheet("contact");
		
		 String OrganizationName= sh.getRow(7).getCell(2).toString()+random;
		 String contactLastName= sh.getRow(7).getCell(3).toString()+random;
		
		 
		book.close();
		
	
		
	// launch the Browser
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
		driver.manage().window().maximize();
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
	//step2 : navigate to organization module	
		driver.findElement(By.linkText("Organizations")).click();
	
	//step 3: create Organization	
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		

	// step 4 : Enter All the details in  New Organization
		
		 driver.findElement(By.className("detailedViewTextBox")).sendKeys(OrganizationName);
		
		driver.findElement(By.name("button")).click();
		
	//step 5 : verify Page header msg Expected Result
		WebElement ele = driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
		String actualData = ele.getText();
		System.out.println(actualData);
		if(actualData.contains(OrganizationName)) {
			System.out.println(OrganizationName+" header is verified == pass");
		}
		else {
			System.out.println(OrganizationName+"  header is not verified == fail");
		}
		
	// step 6 : navigate to contact module 	
		driver.findElement(By.linkText("Contacts")).click();
	
	//step 3: create Contacts	
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		

	// step 4 : Enter All the details in  New Contacts
		
		 driver.findElement(By.name("lastname")).sendKeys(contactLastName);
		 driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
		 
	// switch parent to child window
		 String mainId = driver.getWindowHandle();
		 Set<String> allChildWindow = driver.getWindowHandles();
		 for(String cWindow: allChildWindow) {
			 if(!cWindow.equals(mainId)) {
				 driver.switchTo().window(cWindow);
				 String titleChildWindow= driver.getTitle();
				 System.out.println(titleChildWindow);
			 }
		 }
		 	 
		 driver.findElement(By.name("search_text")).sendKeys(OrganizationName);
		 driver.findElement(By.name("search")).click();
		 
		 driver.findElement(By.xpath("//a[text()='"+OrganizationName+"']")).click();
//		  driver.findElement(By.xpath("//tr[@class='lvtColData']/td/a")).click();
		
		 
		// switch child to parent window
				 
				 Set<String> allWindowIds = driver.getWindowHandles();
				 for(String pWindow: allWindowIds) {
					 if(pWindow.equals(mainId)) {
						 driver.switchTo().window(mainId);
						 String titleParentWindow= driver.getTitle();
						 System.out.println(titleParentWindow);
					 }
				 }
		
		driver.findElement(By.name("button")).click();
		
		//verify Page header msg Expected Result
				WebElement lastNameHeder = driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
				String actuallastname = lastNameHeder.getText();
				System.out.println(actuallastname);
				if(actuallastname.contains(contactLastName)) {
					System.out.println(contactLastName+" Data is virified");
				}
				else {
					System.out.println(contactLastName+" data Varification is Fail");
				}
		
	//verify in contact Page has same Organization Name Expected Result
		WebElement actContInfoOrgname  = driver.findElement(By.id("mouseArea_Organization Name"));
		String actData = actContInfoOrgname.getText();
		System.out.println(actData);
		if(actData.trim().equals(OrganizationName)) {
			System.out.println(OrganizationName+" is present in Contact == pass");
		}
		else {
			System.out.println(OrganizationName+" is  not present in Contact == fail");
		}
		
	
		
	// step 5: Logout
		Thread.sleep(2000);
		driver.findElement(By.xpath("//td[@class='small' and @valign='bottom']")).click();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		driver.quit();
	}

}
