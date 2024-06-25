package practiceDataDrivenTesting;

import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ReadDatafromJsonTest {
	public static void main(String[] args) throws Throwable {
		
	//step1: parse Json physical file into java object using jsonparse class
		JSONParser parser = new JSONParser();
		FileReader fr = new FileReader("D:\\SUJOY_Qspider\\TekPyramidDocometsAPP\\appjsondata.json");
		Object obj = parser.parse(fr);
		
	//step2: converting java object into json object by using down casting
		JSONObject map =(JSONObject)obj;
		
	// step3: get the data from json file using key
		System.out.println(map.get("url"));
		System.out.println(map.get("browser"));
		System.out.println(map.get("username"));
		System.out.println(map.get("password"));
		System.out.println(map.get("timeout"));
		
		
	}

}
