package org.test.cucumberProject;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "Features", glue = {
		"src/main/java/org/test/cucumberProject/StepDefinition.java" }, 
		plugin= {"pretty","html:E:\\Workspace\\Selenium29March18\\cucumberProject\\target\\report"},
		tags= {"~@textbox"})
public class TestRunner {

}
