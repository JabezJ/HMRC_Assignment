package stepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.hmrc.automation.SigningPage;
import com.hmrc.automation.SnippetPage;
import com.hmrc.automation.StartPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Test_Steps {
	
	// Variable driver definition
	public static WebDriver driver;

 //step definition methods for BDD scenarios   

	
@Given("^User navigates to sign up page$")
public void user_navigate_to_sign_up_page() throws Throwable 
{
	
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\chromedriver.exe");
	driver  = new ChromeDriver();	
	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	driver.manage().deleteAllCookies();
	
	StartPage start = new StartPage (driver);
	start.startPageAgreement();
   }


@When("^User enters the new \"([^\"]*)\" and \"([^\"]*)\"$")
public void user_enters_the_new_and(String User, String Pword) throws Throwable {
    
	SigningPage sign = new SigningPage  (driver);
	sign.clickSignup();
	sign.enterCredentials(User,Pword);
	    
}

@When("^User click the button 'Create Account'$")
public void user_click_the_button_Create_Account() throws Throwable {
	
	SigningPage sign = new SigningPage  (driver);
	sign.createAccount ();
}

@Then("^User validates the displayed message “Account created”$")
public void user_validates_the_displayed_message_Account_created() throws Throwable {
	
	SigningPage sign = new SigningPage  (driver);
	sign.validateAccountCreation ();
	
}

@Given("^User enters the existing \"([^\"]*)\" and \"([^\"]*)\"$")
public void user_enters_the_existing_and(String User, String Pword) throws Throwable {
	
	SigningPage sign = new SigningPage  (driver);
	sign.clickSignin();
	sign.enterCredentials(User,Pword);

}

@When("^User submits login details$")
public void user_submits_login_details() throws Throwable {
	
	SigningPage sign = new SigningPage  (driver);
	sign.signinAccount ();
	
}

@Then("^User validates the displayed message “Gruyere: Home”$")
public void user_validate_the_displayed_message_Gruyere_Home() throws Throwable {

	SigningPage sign = new SigningPage  (driver);
	sign.validateSignin ();

}


@Given("^User clicks on the link “New Snippet”$")
public void user_clicks_on_the_link_New_Snippet() throws Throwable {
    
	SnippetPage snippet = new SnippetPage(driver);
	snippet.invokeCreation();
}

@When("^User adds a new snippet \"([^\"]*)\"$")
public void user_adds_a_new_snippet(String arg1) throws Throwable {
	
	SnippetPage snippet = new SnippetPage(driver);
	snippet.createSnippet();
 
}

@When("^User clicks on the 'submit' button$")
public void user_clicks_on_the_submit_button() throws Throwable {
	
	SnippetPage snippet = new SnippetPage(driver);
	snippet.submitSnippet();
   
}

@Then("^Added snippet is displayed on the “My Snippets” box$")
public void added_snippet_is_displayed_on_the_My_Snippets_box() throws Throwable {
	
	SnippetPage snippet = new SnippetPage(driver);
	snippet.validateCreation();
 
}


@Given("^User is already logged on$")
public void user_is_already_logged_on() throws Throwable {
	
	SigningPage sign = new SigningPage  (driver);
	sign.alreadySignedin ();
}

@When("^User clicks on the Sign out weblink$")
public void user_clicks_on_the_Sign_out_weblink() throws Throwable {
	SigningPage sign = new SigningPage  (driver);
	sign.executeSignout();
  
}

@Then("^User validates the Sucessfull Sign Out$")
public void user_validates_the_Sucessfull_Sign_Out() throws Throwable {
	
	SigningPage sign = new SigningPage  (driver);
	sign.validateSignout();
  
}



}
