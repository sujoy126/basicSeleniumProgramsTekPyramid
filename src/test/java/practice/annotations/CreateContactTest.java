package practice.annotations;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class CreateContactTest {
	
	

	
	@Test
	public void createContact() {
		System.out.println("Execute createContact");
	}
	
	@Test
	public void createContactwithDate() {
		System.out.println("Execute createContactwithDate");
	}
	
	
	

}
