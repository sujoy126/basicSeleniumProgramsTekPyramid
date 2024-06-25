package practice.testng;

import org.testng.annotations.Test;

public class ContactTest {
	@Test(dependsOnMethods = "a3" )
	public void a1() {
		System.out.println("a1 method executed");
	}
	
	@Test(dependsOnMethods ="a3" )
	public  void a2() {
		
		System.out.println("a2 method is executed");
		
	} 
	
	@Test
	public  void a3() {
		
		System.out.println("a3 method is executed");
		
	} 

}
