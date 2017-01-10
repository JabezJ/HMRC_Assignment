package com.hmrc.automation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StartPage {
	
	WebDriver driver;
	
	By agreement = By.linkText("Agree & Start");
	By resume = By.linkText("Resume");

	   public StartPage(WebDriver driver){
		   
	       this.driver = driver;
	    }
	   
	   
	   public void startPageAgreement()
	   
	   {
		   
			driver.get("https://google-gruyere.appspot.com/start");
			String appTitle = driver.getTitle();
			System.out.println("Application title is :: "+appTitle);
		   
		   if (driver.findElement(agreement).isDisplayed())
			{
				System.out.println("Agree & Start weblink found on  page");
				driver.findElement(agreement).click();
				}
			else
			{
			    System.out.println("Agree & Start weblink not found on page");
			    if (driver.findElement(resume).isDisplayed())
			    {
			    	System.out.println("Resume weblink found on page");
			    	driver.findElement(resume).click();
			    	}
			    else
			    {
			    	System.out.println("Resume weblink not found on page . And this case is a bug");
			    }
			}
	 
	    }

}


