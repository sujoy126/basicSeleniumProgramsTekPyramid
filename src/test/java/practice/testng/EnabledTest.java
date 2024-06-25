package practice.testng;

import org.testng.annotations.Test;

public class EnabledTest {
	@Test
	public void m1() {
		System.out.println("Execute m1");
	}
	
	@Test(enabled = false)
	public void m2() {
		System.out.println("Execute m2");
	}

}
