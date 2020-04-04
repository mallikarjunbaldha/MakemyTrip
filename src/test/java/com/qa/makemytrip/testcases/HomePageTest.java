package com.qa.makemytrip.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.makemytrip.base.BaseClass;
import com.qa.makemytrip.testpages.HomePage;

public class HomePageTest extends BaseClass{
	
	public HomePageTest() {
		super();
	}

	HomePage homepage;
	@BeforeMethod
	public void setup() {
		openBrowser();	
	}
	
	@Test
	public void HomePageTest() {
	homepage= new HomePage();	
	homepage.SelectFlights();
	}
	
	@Override
	@AfterMethod
	public void teardown() {
		getDriver().quit();
	}
}
