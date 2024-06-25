package practice.java;

import org.testng.annotations.Test;

public class StringOccorance {
	@Test
	public void t1() {
		String str = "science";
		
	
		for(int i=0; i<=str.length(); i++) {
			int count=0;
			char ch1 = str.charAt(i);
			for(int j=0; j<str.length(); j++) {
				char ch2 = str.charAt(j);
				if(ch1 ==ch2 & i>j) {
					break;
				}
				if(ch1==ch2) {
					count++;
				}
			}
			if(count>0) {
				System.out.println(ch1+" occourance "+count);
			}
		}
	}
	
	@Test
	public void m2() {
		String s = "java";
		StringBuffer sb = new StringBuffer();
		sb.append(s);
	System.out.println(sb.reverse());
	}
	
	@Test
	public void m3() {
		String s = "java";
		String st = new StringBuffer(s).reverse().toString();
		System.out.println(st);
	}
	
	@Test
	public void m4() {
		String s = "java";
		String ss = "";
		for(int i=0; i<s.length(); i++) {
			ss = s.charAt(i)+ss;
		}
		System.out.println(ss);
	}
	

}

