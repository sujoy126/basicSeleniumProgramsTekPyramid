package practiceDataDrivenTesting;

import org.testng.annotations.Test;

public class ReadRunTimeMavenParameterTest {
	@Test
	public void runtimeparameterTest() {
		String url = System.getProperty("URL");
		String BROWSER = System.getProperty("browser");
		String USERNAME = System.getProperty("usern ame");
		String PASSWORD = System.getProperty("password");
		System.out.println("Env Testing====>url ======>>"+url);
		System.out.println("browser Testing====> ======>>"+BROWSER);
		System.out.println("username Testing====>url ======>>"+USERNAME);
		System.out.println("password Testing====>url ======>>"+PASSWORD);
		
	}
	@Test
	public void m2() {
		String pp =System.getProperty("xyz");
		System.out.println("second method "+pp);
	}
	

}
