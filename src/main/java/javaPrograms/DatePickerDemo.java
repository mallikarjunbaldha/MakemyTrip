package javaPrograms;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePickerDemo {

WebDriver driver;
	
	@BeforeMethod
	public void setup() {
	WebDriverManager.chromedriver().setup();
	System.setProperty("Webdriver.chrome.driver", "E:\\Selenium3.0\\MakeMyTrip\\drivers\\chromedriver(79).exe");
	//WebDriver driver = new FirefoxDriver();
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.get("https://www.google.com");
	}
	@Test(priority=0)
	public void test() throws InterruptedException {
	driver.findElement(By.name("q")).sendKeys("flights");
	Actions actions = new Actions(driver);
	actions.sendKeys(Keys.ENTER).build().perform();
	driver.findElement(By.xpath("//a[text()='Flights']")).click();
	driver.findElement(By.xpath("//div[@data-flt-ve='destination_airport'][@role='presentation']")).click();
	driver.findElement(By.xpath("//div[text()='Tirupati']")).click();
	driver.findElement(By.xpath("//div[@class='gws-flights__flex-filler"
			+ " gws-flights__ellipsize gws-flights-form__input-target']")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("(//span[text()='Round trip'][@class='gws-flights-form__menu-label'])[2]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("(//span[text()='One-way'])[2]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//calendar-month[@class='gws-travel-calendar__month"
			+ " gws-travel-calendar__show-annotations']//calendar-week//calendar-day[@data-day='2020-02-11']")).click();
	Thread.sleep(3000);
	WebElement date = driver.findElement(By.xpath("//calendar-day[@data-day='2020-01-01']"));
	Thread.sleep(3000);
	if(date.isEnabled())
		System.out.println("this is enabled");
	else
		System.out.println("this is not enabled");
	
	
}
	
	@AfterTest
	public void teardown() {
		driver.quit();
}
}
