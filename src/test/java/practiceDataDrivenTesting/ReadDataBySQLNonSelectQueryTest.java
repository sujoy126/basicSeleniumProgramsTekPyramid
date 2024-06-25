package practiceDataDrivenTesting;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;

public class ReadDataBySQLNonSelectQueryTest {
	@Test
	public void nonSelectQuary() throws SQLException {
		//step1: load/ register the database driver
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
					System.out.println(resultSet.getString(1)+"\t"+ resultSet.getString(2)+"\t"+resultSet.getString(3)+"\t"+resultSet.getString(4));
					
				}
				
				 //step5: close the connection
				con.close();
	}

}
