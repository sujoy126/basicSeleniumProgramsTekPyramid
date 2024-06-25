package practiceDataDrivenTesting;

public class GenerateAlphaNumaricRandomData {
	public static void main(String[] args) {
		int n = 6;
	//choose a character random from this String
		String AlphanumaricString="abcdefghijklmnopqrstuvwxyz1234567890abcdefghijklmnpqrstuvwxyz";
		
		StringBuilder sb = new StringBuilder(n);
		
		for(int i=0; i<n; i++) {
			
	// generate a random number between 0 to alphaNumaricString variable length
			int index = (int)(AlphanumaricString.length()*Math.random());
			
	// add character one y one in end of sb
			sb.append(AlphanumaricString.charAt(index));
		}
		System.out.println(sb);
	}

}
