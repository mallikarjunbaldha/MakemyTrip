package javaPrograms;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MonsterDemo {
	WebDriver driver;

	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium3.0\\MakeMyTrip\\drivers\\chromedriver(79).exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.monsterindia.com/");
	}
	
	@AfterTest
	public void teardown() {
		driver.quit();
	}
	
	
	@Test
	public void test() {
		driver.findElement(By.xpath("//input[@name='fts'][@id='SE_home_autocomplete']")).click();;
		driver.findElement(By.name("fts")).sendKeys("selenium");
		driver.findElement(By.name("lmy")).sendKeys("Hyderabad");
		driver.findElement(By.xpath("//span[@class='multiselect__single modal-ref-class']")).click();
		driver.findElement(By.xpath("//span[@title='3 Years']")).click();
		driver.findElement(By.className("btn")).click();
	}
}
