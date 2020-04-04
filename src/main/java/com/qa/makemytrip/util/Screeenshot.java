package com.qa.makemytrip.util;

import java.io.File;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screeenshot {
WebDriver driver;
TakesScreenshot sc = ((TakesScreenshot)driver);
File screenshot = sc.getScreenshotAs(OutputType.FILE);

}
