package practiceDataDrivenTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;

public class SimpleUnitTestCheckProjectTest {
	@Test
	public void unitTest() throws SQLException {
		String expecedplace="durgapur";
				Driver driverReg = new Driver();
				DriverManager.registerDriver(driverReg);
				
				//step2: connect to database
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sanctoria", "root", "root");
				System.out.println("=================executed===========");
				
				//step3: create SQL statement
				Statement stat= con.createStatement();
				
				//step4: execute select query & get result
				ResultSet resultSet = stat.executeQuery("select * from friends");
				while(resultSet.next()) {
					String actualPlace= resultSet.getString(3);
					if(expecedplace.equals(actualPlace)) {
						System.out.println(expecedplace+" is available==pass");
					}
					System.out.println(expecedplace+" is not available==false");
//					Assert.fail();
				}
				
				 //step5: close the connection
				con.close();
	}

}
