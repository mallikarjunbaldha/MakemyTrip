package com.qa.makemtrip.constants;

import com.qa.makemytrip.base.BaseClass;

public class Constants extends BaseClass{
	public Constants() {
		super();
	}
	

	public static String  ChromeKey = "webdriver.Chrome.driver";
	//public static String ChromeValue= getCurDir()+"\\drivers\\chromedriver.exe";
	public static String ChromeValue= "E:\\Selenium\\AutomationPractiseTest\\drivers\\chromedriver.exe";
	
	
	public static String  FirefoxKey = "webdriver.Firefox.driver";
	public static String FirefoxValue = getCurDir()+"\\drivers\\geckodriver.exe";
	
	public static final void constant() {
		System.out.println("Dummy method");
	}
	
}
