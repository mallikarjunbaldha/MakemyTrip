package javaPrograms;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NewClass {

	public static void main(String[] args) {
		System.setProperty("Webdriver.gecko.driver", "E:\\Selenium3.0\\MakeMyTrip\\drivers\\geckodriver.exe");
		System.setProperty("Webdriver.chrome.driver", "C:\\Users\\malli\\Downloads\\chromedriver_win32(79)\\chromedriver.exe");
		//WebDriver driver = new FirefoxDriver();
		 WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.google.com");
	}

}
