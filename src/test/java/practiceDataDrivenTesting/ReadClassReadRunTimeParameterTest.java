package practiceDataDrivenTesting;

public class ReadClassReadRunTimeParameterTest {
	public static void main(String[] args) {
		
		System.out.println(args.length);
		for(String str: args) {
			System.out.println(str);
		}
	}

}
