package com.hmrc.automation;

import org.junit.Assert;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;


public class SigningPage {
	
	WebDriver driver;
	
	By signin = By.linkText("Sign in");
	By signup = By.linkText("Sign up");
	By signout = By.linkText("Sign out");
	
	
	By username = By.xpath("//input[contains(@name,'uid')]");
    By password = By.xpath("//input[contains(@name,'pw')]");
        
    By account = By.xpath("//div[contains(.,'Account created.')]");
    By duplicate = By.xpath("//div[contains(.,'User already exists.')]");
    By home = By.xpath("//h2[contains(.,'Gruyere: Home')]");
    By login = By.xpath("//input[contains(@value,'Login')]");
    By create_account = By.xpath("//input[contains(@value,'Create account')]");
    
    
	
	   public SigningPage(WebDriver driver){
		   
	       this.driver = driver;
	    }
	
public void clickSignup (){
		
	if (driver.findElement(signup).isDisplayed())
	{
		System.out.println("Sign up weblink found on  page");
		driver.findElement(signup).click();
	}
	else
	{
    	System.out.println("Sign up weblink not found on page . And this is a defect");
    
	}
	}

public void clickSignin (){
if (driver.findElement(signin).isDisplayed())
{
	System.out.println("Sign in weblink found on  page");
	driver.findElement(signin).click();
}
else{
	System.out.println("Sign in weblink not found on page . And this case is a defect");
	}

}

public void enterCredentials (String User,String Pword )
{
	driver.findElement(username).sendKeys(User);	
	driver.findElement(password).sendKeys(Pword);

}


public void createAccount ()
{
	driver.findElement(create_account).click();
}

public void signinAccount ()
{
	driver.findElement(login).click();
}

public void validateAccountCreation ()
{
	

	if (driver.findElement(account).isDisplayed()){
		
		String msg = driver.findElement(By.xpath("//div[contains(.,'Account created.')]")).getText();
		System.out.println("New account has been created successfully");
		Assert.assertEquals("Done","Account created.",msg);
	}
	else
	{
		if (driver.findElement(duplicate).isDisplayed())
		{
			System.out.println("New account is not created as the account should be unique; Account already exists");
	
		}
	}
	
}

public void validateSignin ()
{
	
	if (driver.findElement(home).isDisplayed()){
		System.out.println("Sign in sucessfull");
	}
	else{
		System.out.println("Sign in unsucessfull");
	}
	
	
}

public void alreadySignedin ()
{
if (driver.findElement(signout).isDisplayed()){
		System.out.println("Already signed into application");
		Assert.assertEquals("Signed In already",driver.findElement(signout).isEnabled(),true);
	}
	else{
		System.out.println("Not yet signed in to app");
	}
	
}

public void executeSignout ()
{
		driver.findElement(signout).click();

	}
public void validateSignout ()
{
	if (driver.findElement(signin).isDisplayed()){
		Assert.assertEquals("Sucess",driver.findElement(signin).isEnabled(),true);
		System.out.println("Sign out successfull");
		driver.quit();
	}
	else{
		System.out.println("Not yet signed out of app");
	}

	}

}
