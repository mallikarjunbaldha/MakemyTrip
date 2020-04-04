package javaPrograms;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DownloadDemo {
	WebDriver driver;
	File dfolder;

	@BeforeMethod
	public void Setup() {
		dfolder = new File("C:\\Users\\malli\\Desktop"); 
		dfolder.mkdir();
		
		/*
		 * // firefox browser FirefoxProfile profile = new FirefoxProfile();
		 * profile.setPreference("browser.download.dir", dfolder.getAbsolutePath());
		 * profile.setPreference("browser.download.folderList", 2);
		 * //profile.setPreference("browser.helperApps.neverAsk.saveToDisk", 
		 * "application/octet-stream,image/png,image/jpeg,application/msword,application/pdf"
		 * ); profile.setPreference("browser.helperApps.neverAsk.openFile",
		 * "application/octet-stream"); profile.setPreference("pdfjs.disabled", true);
		 * driver = new FirefoxDriver();
		 */
		
		//chrome browser
	System.setProperty("Webdriver.chrome.driver", "E:\\Selenium3.0\\MakeMyTrip\\drivers\\chromedriver\\chromedriver.exe");
	ChromeOptions options = new ChromeOptions();
	
	Map<String, Object> prefs = new HashMap<String, Object>();
	prefs.put("profile.default_content_settings.popups", 0);
		prefs.put("download.default_directory", dfolder.getAbsolutePath());
	
	options.setExperimentalOption("prefs",prefs);
	DesiredCapabilities cap = DesiredCapabilities.chrome();
	cap.setCapability(ChromeOptions.CAPABILITY, options);
	
		WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();	
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	@Test
	public void downloadFile() throws InterruptedException {
		driver.get("https://filehippo.com/download_avast_antivirus/");
		driver.findElement(By.linkText("Download Latest Version")).click();
		
		Thread.sleep(3000);
		File files[] = dfolder.listFiles();
		Assert.assertTrue(files.length>0);
		for(File file: files) {
			Assert.assertTrue(file.length()>0);
		}
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
		for(File file:dfolder.listFiles()) {
			file.delete();
		}
		dfolder.delete();
	}
}
