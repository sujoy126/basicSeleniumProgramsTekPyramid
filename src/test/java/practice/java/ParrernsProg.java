package practice.java;

import org.testng.annotations.Test;

public class ParrernsProg {
	@Test
	public void p1() {
		int n=3;
		for(int i=1; i<=n;i++) {
			for(int j=1; j<=n; j++) {
				if(i-j>=0) {
					System.out.print(" * ");
				}
				else
					System.out.print(" ");
			}
			System.out.println();
		}
		
	}
		@Test
		public void p2() {
		int n=5;
			for(int i=1; i<=n; i++) {
				for(int j=1; j<=n; j++) {
					if(i+j<=6) {
						System.out.print(" * ");
					}
					else
						System.out.print(" ");
				}
				System.out.println();
			}	
	}
		
		@Test
		public void p3() {
		int n=3;
			for(int i=1; i<=n; i++) {
				for(int j=1; j<=n; j++) {
					if(i+j>=4) {
						System.out.print(" *");
					}
					else
						System.out.print("  ");
				}
				System.out.println();
			}	
	}
		
		
		@Test
		public void hw1() {
		
			for(int i=1; i<=3; i++) {
				for(int j=1; j<=5; j++) {
					if(i+j>=4 && j-i<=2) {
						System.out.print(" *");
					}
					else
						System.out.print("  ");
				}
				System.out.println();
			}	
	}	
		
		@Test
		public void hw2() {
		
			for(int i=1; i<=5; i++) {
				for(int j=1; j<=5; j++) {
					if(i+j>=4 && j-i<=2 && i+j<=8 && i-j<=2) {
						System.out.print(" *");
					}
					else
						System.out.print("  ");
				}
				System.out.println();
			}	
	}	
		
		@Test
		public void hw3() {
		
		int row=3, star = 1, space =2,num=1 ; 
			for(int i=1; i<=row; i++) {
				for(int j=1; j<=space; j++) {
						System.out.print(" ");
				}
				num=1;
				for(int k=1; k<=star; k++) {
					System.out.print(num);
				
				if(k==i || k>i) {
					num--;
				}
				else
				{
					num++;
				}
				}
				space--;
				star= star+2;
				System.out.println();
			}	
	}	
		
		
		@Test
		public void hw4() {
		
		int n=4, star = 1, space =n-1; 
			for(int i=1; i<=n; i++) {
				char ch ='A';
				for(int j=1; j<=space; j++) {
						System.out.print(" ");
				}
				
				for(int k=1; k<=star; k++) {
					System.out.print(ch);
				
				if(k==i || k>i) {
					ch--;
				}
				else
				{
					ch++;
				}
				}
				space--;
				star= star+2;
				System.out.println();
			}	
	}	
		
		@Test
		public void hw4AnotherLogic() {
		char ch ='A';
		
			for(int i=1; i<=3; i++) {
				for(int j=1; j<=5; j++) {
					
				}
			
			}
	}	
		
		
		
		@Test
		public void hw5() {
		
		int row=5, star = 1, space =2; 
			for(int i=1; i<=row; i++) {
				for(int j=1; j<=space; j++) {
						System.out.print(" ");
				}
				
				for(int k=1; k<=star; k++) {
					if(i==2 &&k==2 ||k>1&& k<5&& i==3||i==4&&k==2) {
					System.out.print('*');
				}
				else
					System.out.print('1');
				}
			
			if(i>=3) {
				star= star-2;
				space++;
			}else {
				star=star+2;
				space--;
			}
				System.out.println();
			}	
	}	
		
		
		
		
		
		
		
		
		

}
