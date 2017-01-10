package com.hmrc.automation;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
 
@RunWith(Cucumber.class)
@CucumberOptions(
		features = "Feature",tags = {"@SingleAccount,@SignIn,@SnippetCreation,@SignOut"}
		,glue={"stepDefinition"},monochrome = true,plugin={"html:target/cucumber-html-report", "json:target/cucumber-json-report.json" }
		)
 
public class TestRunner {
 
}

//tags={"@SingleAccount,@SignIn"}
//tags = {"@SingleAccount,@SignIn,@SnippetCreation"}