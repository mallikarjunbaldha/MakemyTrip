package javaPrograms;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DownloadCheck {

	public static void main(String[] a) {
		System.setProperty("Webdriver.gecko.driver", "E:\\Selenium3.0\\MakeMyTrip\\drivers\\geckodriver.exe");
		System.setProperty("Webdriver.chrome.driver", "E:\\Selenium3.0\\MakeMyTrip\\drivers\\chromedriver\\chromedriver.exe");
		//WebDriver driver = new FirefoxDriver();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.google.com");
		Actions actions = new Actions(driver);
		driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys("download selenium");
		actions.sendKeys(Keys.ENTER).build().perform();
		driver.findElement(By.xpath("//h3[text()='Downloads - Selenium']")).click();
		driver.findElement(By.linkText("3.141.59")).click();
		
		actions.keyDown(Keys.CONTROL).sendKeys("j").keyUp(Keys.CONTROL).build().perform();
	}
	
}
