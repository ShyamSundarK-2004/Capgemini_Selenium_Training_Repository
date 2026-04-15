package runnerIO;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/featureFile/addToCart.feature", plugin = "html:target/report.html", glue = "stepdefinition", dryRun = false)
public class RunnerIO extends AbstractTestNGCucumberTests {

}
