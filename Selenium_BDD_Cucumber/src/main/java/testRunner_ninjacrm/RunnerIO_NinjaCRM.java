package testRunner_ninjacrm;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/featureFile_ninjacrm/NinjaCRM.feature", glue = "stepDefinition_ninjacrm", dryRun = true)
public class RunnerIO_NinjaCRM extends AbstractTestNGCucumberTests {

}
