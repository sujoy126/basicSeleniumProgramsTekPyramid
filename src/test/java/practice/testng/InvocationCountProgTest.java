package practice.testng;

import org.testng.annotations.Test;

public class InvocationCountProgTest {
	@Test  //(invocationCount = 10)
	public void a() {
		for(int i=0; i<=10; i++) {
		System.out.println("execute == a");
	}
	}
}
