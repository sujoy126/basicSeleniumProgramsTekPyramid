package practice.orgtest;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.FileStore;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;




public class CreateOrganizationTest {
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
		Sheet sh =book.getSheet("orgdata");
		 String OrganizationName= sh.getRow(0).getCell(1).toString()+random;
		 String Wbsite= sh.getRow(1).getCell(1).toString();
		 DataFormatter df = new DataFormatter();
		 String phoneNo = df.formatCellValue(sh.getRow(2).getCell(1));
		 String fax= sh.getRow(3).getCell(1).toString();
			
		System.out.println(OrganizationName);
		System.out.println(Wbsite);
		System.out.println(phoneNo);
		System.out.println(fax);
		book.close();
		
		
	
//	// Give the inpout from keyboard
//		Scanner sc = new Scanner(System.in);
//		System.out.println("enter the Browser name");
//		String browser = sc.next();
//		System.out.println(browser);
		
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
		 
		
		driver.findElement(By.xpath("//input[@name='website']")).sendKeys(Wbsite);
		driver.findElement(By.name("phone")).sendKeys(phoneNo);
		driver.findElement(By.name("fax")).sendKeys(fax);
		driver.findElement(By.name("button")).click();
		
	//verify Page header msg Expected Result
		WebElement ele = driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
		String actualData = ele.getText();
		System.out.println(actualData);
		if(actualData.contains(OrganizationName)) {
			System.out.println("Data is virified");
		}
		else {
			System.out.println("Varification Fail");
		}
		
	//VerifyHeader orgNameinfo Expected Result
		 String actOrgName= driver.findElement(By.id("dtlview_Organization Name")).getText();
		 if(actOrgName.contains(OrganizationName)) {
			 System.out.println(OrganizationName+" is created ==pass");
		 }
		 else
			 System.out.println(OrganizationName+" is not created== fail");
		 
		 
		 
		
	// step 5: Logout
		Thread.sleep(2000);
		driver.findElement(By.xpath("//td[@class='small' and @valign='bottom']")).click();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		driver.quit();
	}

}
