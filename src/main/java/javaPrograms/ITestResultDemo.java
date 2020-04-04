package javaPrograms;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ITestResultDemo {
WebDriver driver;
	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium3.0\\MakeMyTrip\\drivers\\chromedriver(79).exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.google.com");
		
	}
	
	
	@AfterTest
	public void teardown() {
		driver.quit();
	}
	
	@Test
	public void test() {
		driver.findElement(By.name("q")).sendKeys("alex");
		driver.findElement(By.name("btnK1")).click();
		
	}
	
	@BeforeMethod
	public void beforeMethod(Method m) {
		System.out.println("executing the testcase: "+ m.getName());
	}
	
	@AfterMethod
	public void AfterMethod(ITestResult result) throws IOException {
		if(ITestResult.FAILURE==result.getStatus()) {
			System.out.println("testcase failed, Screenshot captured");
		   TakesScreenshot takeSS = (TakesScreenshot)driver;
		   File screenshot = takeSS.getScreenshotAs(OutputType.FILE);
		   FileUtils.copyFile(screenshot, new File("E:\\Selenium3.0\\MakeMyTrip\\Screenshots\\gmail.jpeg"));
		}
		
		else if(ITestResult.SKIP==result.getStatus()) {
			System.out.println("testcase failed, Screenshot captured");
			   TakesScreenshot takeSS = (TakesScreenshot)driver;
			   File screenshot = takeSS.getScreenshotAs(OutputType.FILE);
			   FileUtils.copyFile(screenshot, new File("E:\\Selenium3.0\\MakeMyTrip\\Screenshots\\gmail.jpeg"));
			}
		else{
			System.out.println("testcase is passed");
		}
			
	}
}
