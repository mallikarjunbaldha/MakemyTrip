package javaPrograms;

import java.util.HashSet;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SelectDemo {
	WebDriver driver;

	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium3.0\\MakeMyTrip\\drivers\\chromedriver(79).exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com");
	}
	
	@AfterMethod
	public void teardown() {
		driver.close();
	}
	
	@Test
	public void test() {  
	WebElement	ele = driver.findElement(By.name("firstname"));
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.SHIFT);
	actions.sendKeys("arjun");
	actions.keyUp(Keys.SHIFT);
	actions.build().perform();
			}
			
		
	}

