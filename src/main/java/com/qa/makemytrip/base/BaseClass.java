package com.qa.makemytrip.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import com.qa.makemtrip.constants.Constants;

public class BaseClass {
	
	private static Properties prop;
	private static WebDriver driver;
	private static String curDir;
	private static JavascriptExecutor executor;
	private static FirefoxOptions opts;
	
	public BaseClass() {
		prop = new Properties();
		FileInputStream fip = null;
		try {
			fip = new FileInputStream("E:\\Selenium3.0\\MakeMyTrip\\"
					+ "src\\main\\java\\com\\qa\\makemytrip\\config\\config.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			prop.load(fip);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void openBrowser() {
		String browserName = prop.getProperty("browser");
		curDir = System.getProperty("user.dir");
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty(Constants.ChromeKey,Constants.ChromeValue);
			driver = new ChromeDriver();
			initialization();
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			System.setProperty(Constants.FirefoxKey,Constants.FirefoxValue);
			//driver = new FirefoxDriver();
			opts = new FirefoxOptions();
			opts.addArguments("-private");
			driver = new FirefoxDriver(opts);			
			initialization();
		}
	}
	public void initialization() {
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		executor = (JavascriptExecutor)driver;
	}
	
	public void teardown() {
		driver.quit();
	}
	
	
	public static String getCurDir() {
		return curDir;
	}
	
	public static WebDriver getDriver() {
		return driver;
	}
	public static JavascriptExecutor getExecutor() {
		return executor;
	}
}
