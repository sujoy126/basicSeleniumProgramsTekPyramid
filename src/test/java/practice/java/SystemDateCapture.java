package practice.java;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.testng.annotations.Test;


public class SystemDateCapture {
	@Test
	public void date() {
		
		Date dateObj = new Date();
//		System.out.println(dateObj );
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(sdf.format(dateObj));
		
		Calendar cal = sdf.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, 30);
		String dateRequres= sdf.format(cal.getTime());
		System.out.println(dateRequres);
		
	
	}
	
	@Test
	public void generateDate() {
		Date da = new Date();
		String x[] = da.toString().split(" ");
		String date =  x[2]+"-"+x[1]+"-"+x[5];
		System.out.println(date);
	}
	
	@Test
	public void generateTime() {
		Date dt = new Date();
		String time = dt.toString().replace(" " , "_").replace(":", "_");
		System.out.println(time);
	}
	
	
	
	
	
	
	

}
