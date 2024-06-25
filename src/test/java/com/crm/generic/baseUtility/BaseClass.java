package com.crm.generic.baseUtility;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class BaseClass {
	

	@BeforeSuite
	public void configBEforeSuit() {
		System.out.println("====connect to DB, Report Config====");
	}
	
	@BeforeClass
	public void configBeforeClass() {
		System.out.println("===Launch Browser===");
	}

	
	@BeforeMethod
	public void configBM() {
		System.out.println("==Login==");
	}

	
	@AfterMethod
	public void createAM() {
		System.out.println("==LogOut==");
	}
	
	@AfterClass
	public void configAfterClass() {
		System.out.println("===Close The Browser===");
	}
	
	@AfterSuite
	public void configAfterSuit() {
		System.out.println("====close to DB, Report Backup====");
	}


}
