package DemoqaTask;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="cucumberProject\\Features\\demoqa.feature",glue = {"DemoqaTask"}, plugin = {"pretty", 
		"html:target/htmlreport/"}, tags= {"@textbox,@regression,@sanity"})

public class Runner {

	
}
