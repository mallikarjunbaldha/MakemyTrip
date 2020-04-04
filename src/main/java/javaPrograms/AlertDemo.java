package javaPrograms;

import java.sql.Driver;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertDemo {
	WebDriver driver;
@BeforeMethod
public void Setup(){
System.setProperty("webdriver.chrome.driver","E:\\Selenium3.0\\MakeMyTrip\\drivers\\chromedriver(79).exe" );
driver = new ChromeDriver();
driver.manage().deleteAllCookies();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
}

@Test
public void test() throws InterruptedException {
	driver.get("http://toolsqa.com/automation-practice-switch-windows/");
	driver.findElement(By.linkText("ACCEPT")).click();
	Thread.sleep(5000);
	WebElement ele = driver.findElement(By.id("button1"));
    String MainWindow = driver.getWindowHandle();
    for(int i=0;i<3;i++) {
    	ele.click();
    	Thread.sleep(3000);
    }
	Set<String> set = driver.getWindowHandles();
	String LastWindowHandle =" ";
	for(String CW : set) {
		System.out.println("switching to window: - "+ CW); 
		System.out.println("navigating to google");
		driver.switchTo().window(CW);
		driver.get("https://www.google.com");
		LastWindowHandle = CW;
		}
	driver.switchTo().window(MainWindow);
	driver.close();
	   
	driver.switchTo().window(LastWindowHandle);
	driver.get("https://www.youtube.com");
	}
	
		

@AfterMethod
public void teardown() {
	driver.close();	
}




}
