package practiceDataDrivenTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;

public class HrmConnectionTest {
	@Test
	public void rmgyantraUser() throws SQLException {

	//create a project in GUI
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://106.51.90.215:8084/");
		driver.findElement(By.id("username")).sendKeys("rmgyantra", Keys.TAB, "rmgy@9999", Keys.ENTER);
		driver.findElement(By.xpath("//a[text()='Projects']")).click();
		driver.findElement(By.xpath("//span[text()='Create Project']")).click();

		Random rdm = new Random();
		int Rnumber = rdm.nextInt(1000);
		String projectN = "Tiger_" + Rnumber;
		driver.findElement(By.name("projectName")).sendKeys(projectN);
		driver.findElement(By.name("createdBy")).sendKeys("Sujoy");

		WebElement we = driver.findElement(By.xpath("(//select[@name='status'])[2]"));
		Select sl = new Select(we);
		sl.selectByValue("Created");

		driver.findElement(By.xpath("//input[@type='submit']")).click();

	//verify the project in BackEnd [DB] using JDBC
		boolean flag = false;
		Connection con = null;
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		con = DriverManager.getConnection("jdbc:mysql://106.51.90.215:3333/Projects", "root@%", "root");
		Statement sts = con.createStatement();
		ResultSet rstSet = sts.executeQuery("select * from project ;");
		while (rstSet.next()) {
			String actProject = rstSet.getString(4);
			if (actProject.equals(projectN)) {
				 flag =true;
				System.out.println(rstSet.getString(1) + "\t" + rstSet.getString(2) + "\t" + rstSet.getString(3) + "\t"
						+ rstSet.getString(4) + "\t" + rstSet.getString(5) + "\t" + rstSet.getString(6));
			}
		}
		if(flag==false) {
			System.out.println("data is not available");
		}

		System.out.println("=======execute=====");

	}

}
