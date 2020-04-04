package javaPrograms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NewDemo {
	WebDriver driver;
	@BeforeMethod
	public void setup() {
		WebDriverManager.chromedriver().setup();
		//System.setProperty("Webdriver.chrome.driver", "E:\\Selenium3.0\\MakeMyTrip\\drivers\\chromedriver(79).exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
	}
	@Test
	public void test() {
		driver.get("https://www.google.com");
	}
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
