package practice.testng;

import org.testng.annotations.Test;

public class DependsOnMethod {
	@Test(priority = 0)
	public void west() {
		System.out.println("execute===>west");
	}
	
	@Test(priority = 0,dependsOnMethods ="west")
	public void asia() {
		System.out.println("execute===>asia");
	}
	
	@Test(priority = 1,dependsOnMethods = "asia")
	public void india() {
		System.out.println("execute===>india");
	}
	
	@Test(priority = 0)
	public void world() {
		System.out.println("execute===>world");
	}

}
