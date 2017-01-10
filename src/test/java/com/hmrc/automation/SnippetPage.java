package com.hmrc.automation;

import org.junit.Assert;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

public class SnippetPage {
	
	WebDriver driver;
	
	By newsnippet = By.xpath("//a[contains(.,'New Snippet')]");
	By content = By.xpath("//textarea[contains(@name,'snippet')]");
	By submit = By.xpath("//input[contains(@value,'Submit')]");
	By delete = By.xpath("//a[contains(.,'[X]')]");	
	
	   public SnippetPage(WebDriver driver){
	   
	       this.driver = driver;
	    }
	   
	   public void  invokeCreation()
	   {
		   driver.findElement(newsnippet).click();
	   }
	   
	   
	   public void createSnippet() {
	   
		   driver.findElement(content).sendKeys("https://news.google.com/news/search?q=hmrc");
	   }
	   
	   public void submitSnippet() {
		   
			driver.findElement(submit).click();
		 }
	   
	   		public void validateCreation() {
		   
	   			if (driver.findElement(delete).isDisplayed())
	   			{
	   				System.out.println("Snippet creation sucessfull");
	   			}
	   			else
	   			{
	   				System.out.println("Snippet creation unsucessfull");
	   			}
	   		}
	   
		//Delete Snippet
	   public void deleteSnippet() {
		driver.findElement(delete).click();
	   }

}
