#Author: jabezj@gmail.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios 
#<> (placeholder)
#""
## (Comments)

#Sample Feature Definition Template
@Smoke @Regression
Feature: Smoke Testsuite for the Gruyere Snipet web application

@SingleAccount
Scenario: Sign up a new user account
Given User navigates to sign up page
When User enters the new "James" and "James123" 
	And User click the button 'Create Account'
Then User validates the displayed message “Account created” 

@MultipleAccount
Scenario Outline: Sign up a new user account
Given User navigates to sign up page
When User enters the new "<Username>" and "<Password>" 
	And User click the button 'Create Account'
Then User validates the displayed message “Account created” 

Examples:
    | Username  |Password |
    | James 		|James123 |
    | jj 				|jj123  	|

@SignIn
Scenario Outline: Sign in to an user account
Given User enters the existing "<Username>" and "<Password>" 
When User submits login details
Then User validates the displayed message “Gruyere: Home” 

Examples:
    | Username  |Password |
    | James 		|James123 |
    
@SnippetCreation
Scenario: Create a snippet entry
Given User clicks on the link “New Snippet”
When User adds a new snippet "https://news.google.com/news/search?q=hmrc"
And User clicks on the 'submit' button
Then Added snippet is displayed on the “My Snippets” box
 
@SignOut
Scenario: Sign out an user account
Given User is already logged on 
When User clicks on the Sign out weblink
Then User validates the Sucessfull Sign Out
 
 
