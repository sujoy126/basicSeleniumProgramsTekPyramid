package practice.testng;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class SanpleReportTest {
	
	ExtentSparkReporter spark;
	ExtentReports report;
	ExtentTest test;
	
	@BeforeSuite
	public void configBS() {
		// Spark report configuration
			     spark = new ExtentSparkReporter("./AdvanceReport/report.html");
				spark.config().setDocumentTitle("Vtiger application testing");
				spark.config().setReportName("Sujoy MOndal");
				spark.config().setTheme(Theme.DARK);
				
				//add env info & create test
				 report = new ExtentReports();
				report.attachReporter(spark);
				report.setSystemInfo("Operating System", "windows-10");
				report.setSystemInfo("BROWSER", "Chrome driver-100");
	}
	
	@AfterSuite
	public void configAS() {
		
		report.flush();
	}
	
	@Test
	public void createContactTest() {
		
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8888");
		 
		TakesScreenshot shot = (TakesScreenshot) driver;
		 String filePath = shot.getScreenshotAs(OutputType.BASE64);
		
		test = report.createTest("SanpleReportTest");
		test.log(Status.INFO,"login to application");
		test.log(Status.INFO,"navigate to contact page");
		test.log(Status.INFO,"create contact page");
		if("hdfc".equals("hdfjjjjjj")) {
			test.log(Status.PASS,"contact is crated");
		}
		else {
			test.addScreenCaptureFromBase64String(filePath, "ErrorFile");
		}
	}
		
		@Test
		public void createContactWithOrgTest() {
			
			 test = report.createTest("SanpleReportTest");
			
			test.log(Status.INFO,"login to application");
			test.log(Status.INFO,"navigate to contact page");
			test.log(Status.INFO,"create contact page");
			if("hdfc".equals("hdfc")) {
				test.log(Status.PASS,"contact is crated");
			}
			else {
				test.log(Status.FAIL,"contact is not created");
			}
		}
		
			@Test
			public void createContactWithPhNoTest() {
				
				 test = report.createTest("SanpleReportTest");
				
				test.log(Status.INFO,"login to application");
				test.log(Status.INFO,"navigate to contact page");
				test.log(Status.INFO,"create contact page");
				if("hdfc".equals("hdfc")) {
					test.log(Status.PASS,"contact is crated");
				}
				else {
					test.log(Status.FAIL,"contact is not created");
				}	
		
	}

}
