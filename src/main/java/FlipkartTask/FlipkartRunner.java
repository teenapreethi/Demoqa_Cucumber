package FlipkartTask;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "./Features/flipkart.feature", glue = {
		"FlipkartTask" }, dryRun=true)
public class FlipkartRunner {

}
