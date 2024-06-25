package practice.testng;

import org.testng.annotations.Test;

public class OrganizationTest {
	@Test
	public void createOrgTest() {
		System.out.println("Execute CreateOrganization with --> HDFC");
	}
	
	@Test
	public void modificationOrgTest() {
		System.out.println("execute query insert org in DB");
		System.out.println("Execute modify Organization with --> HDFC -->ICICI");
	}
	
	@Test
	public void deleteOrgTest() {
		System.out.println("execute query insert org in DB ==>UPI ");
		System.out.println("Execute delete Organization with --> UPI");
	}
	

}
