package taskTest;

public class StringAccorenceInNmae {
	public static void main(String[] args) {
		String str = "ManojKumara";
		String s ="";
		String d="*";
		
		for(int i=0; i<str.length(); i++) {
		char ch= str.charAt(i);
		 if(ch=='a') {
		 s=s+d;
		 d= d+d;
			
		 }
		 else
			 s=s+ch;
		}
		System.out.println(s);
	 
	}

}
