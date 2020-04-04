package com.qa.makemytrip.testpages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.makemytrip.base.BaseClass;

public class HomePage extends BaseClass{
	
	public HomePage() {
		PageFactory.initElements(getDriver(), this);
	}

	//Page Factory :OR
	@FindBy(xpath="//li[text()='Round Trip']")
	WebElement RoundTrip;
	
	@FindBy(xpath="//input[@id='fromCity']")
	WebElement From;
	
	@FindBy(xpath="//div[text()='BLR']")
	WebElement Start;
	
	@FindBy(xpath="//input[@id='toCity']")
	WebElement To;
	
	@FindBy(xpath="//div[text()='HYD']")
	WebElement End;
	
	@FindBy(xpath="//span[text()='DEPARTURE']")
	WebElement Departure;
	
	@FindBy(xpath="//span[@aria-label='Previous Month']")
	WebElement PrevMonth;
	
	@FindBy(xpath="//div[@aria-label='Thu Oct 31 2019']")
	WebElement DepartureDate;
	
	@FindBy(xpath="//span[text()='RETURN']")
	WebElement Return;
	
	@FindBy(xpath="//div[@aria-label='Thu Nov 07 2019']")
	WebElement ReturnDate;
	
	@FindBy(xpath="//a[text()='Search']")
	WebElement Search;
	@FindBy(xpath ="//div[@id='ow-domrt-jrny']//div/div[contains(@class,'fli-list splitVw-listing ')]")
	List<WebElement> departureFlights; 
	
	@FindBy(xpath="//div[@id='rt-domrt-jrny']//div/div[contains(@class,'fli-list splitVw-listing ')]")
	List<WebElement> returnFlights;
	
	@FindBy(xpath="//span[@data-filtertext='collapsed_stop_nonStop']")
	WebElement nonStop;
	
	@FindBy(xpath="//span[@data-filtertext='collapsed_stop_oneStop']")
	WebElement oneStop;
	// Actions
	public void SelectFlights() {
		
	RoundTrip.click();
	From.click();
    Start.click();
    To.click();
    End.click();
    Departure.click();
    PrevMonth.click();
    DepartureDate.click();
    Return.click();
    ReturnDate.click();
    Search.click();
    getExecutor().executeScript("window.scrollTo(0, document.body.scrollHeight);");
    getExecutor().executeScript("window.scrollTo(0, -document.body.scrollHeight);");
    System.out.println("the total number of departure flight records is "+departureFlights.size());
    System.out.println("the total number of return flight records is "+returnFlights.size());
    nonStop.click();
    oneStop.click();
    System.out.println("the total number of departure flight records is "+departureFlights.size());
    System.out.println("the total number of return flight records is "+returnFlights.size());
    
    
    
    
    

}
}