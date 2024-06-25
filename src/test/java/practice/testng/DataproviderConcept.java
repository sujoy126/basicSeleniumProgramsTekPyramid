package practice.testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataproviderConcept {
	@Test(dataProvider = "getData") // =login
	public void createContatTest(String FirstName, String lastName, long phoneNumber) {
		System.out.println("FirstName : "+FirstName+ " LastName : "+ lastName+ " phoneNumber : "+ phoneNumber);
		
	}
	
	
	@DataProvider()  //name="login"; 
	public Object[][] getData(){
		Object[][] objArr = new Object[3][3];
		objArr[0][0]= "Depak";
		objArr[0][1]= "CEO";
		objArr[0][2]= 2345678909l;
	
		objArr[1][0]= "john";
		objArr[1][1]= "CFO";
		objArr[1][2]= 2345678909l;
	
		objArr[2][0]= "Sujoy";
		objArr[2][1]= "AE";
		objArr[2][2]= 85857888787l;
			
		return objArr;
		
	}

}
