package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@CucumberOptions(features = "src/test/java/featureFile/addToCart.feature", glue = "stepDefinition", dryRun = false)
//public class RunnerIO extends AbstractTestNGCucumberTests {
//}

@CucumberOptions(features = "src/test/java/featureFile/flipkartFeatureFile.feature", glue = "stepDefinition", dryRun = false)
public class RunnerIO extends AbstractTestNGCucumberTests {

}
