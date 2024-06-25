package practice.testng;

import org.testng.annotations.Test;

public class SkipTestCaseOrderTest {
	@Test
	public void createOrderTest() {
		System.out.println("Execute createOrderTest===>123");
		String str = null;
		System.out.println(str.equals(" "));
	}
	
	@Test(dependsOnMethods = "createOrderTest")
	public void billingAndOrderTest() {
		System.out.println("Execute billingAndOrderTest===>123");
		
	}

}
