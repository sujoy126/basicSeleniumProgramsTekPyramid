package practice.hometest;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionTest {
	@Test
	public void m1(Method md) {
		
		SoftAssert sofasert = new SoftAssert();
		
		System.out.println(md.getName()+" test strt");
		System.out.println("step-1");
		System.out.println("step-2");
//strict validation or mandatory information validation use hard assert
		Assert.assertEquals("Home", "Home");
		System.out.println("step-3");
// not a strict validation or non mandatory validation use soft assert.		
		sofasert.assertEquals("Home-CRM", "Home-CRMree");
		System.out.println("step-4");
		System.out.println(md.getName()+" test end");
		System.out.println("===========");
// assertAll() is compulsury for soft asseert otherwise it will not print any exception.
		sofasert.assertAll();
	}
	
	@Test
	public void m2(Method mm) {
		SoftAssert sofasert = new SoftAssert();
		
		System.out.println(mm.getName()+" start test");
		System.out.println("step-1");
		System.out.println("step-2");
		sofasert.assertTrue(true);
		System.out.println("step-3");
		System.out.println("step-4");
		sofasert.assertAll();
		System.out.println(mm.getName()+" end test");
		
	}

}
