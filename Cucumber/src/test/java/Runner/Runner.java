package Runner;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/Features", 
				glue = { "StepDefinitions" }, 
				tags = { "@Search" }, 
				format = {"pretty", "html:test-output","com.cucumber.listener.ExtentCucumberFormatter:test-output/report.html" },
				dryRun = false, 
				monochrome = true)

public class Runner {
	@AfterClass
	public static void reportSetup() throws IOException {

		Reporter.loadXMLConfig(new File("src/test/java/Helpers/extent-config.xml"));
		Properties p = System.getProperties();
		p.list(System.out);
		Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
		Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
		Reporter.setSystemInfo("64 Bit", "Windows 10");
		Reporter.setSystemInfo("3.3.9", "Maven");
		Reporter.setSystemInfo("1.8.0_66", "Java Version");
		Reporter.setTestRunnerOutput("Cucumber JUnit Test Runner");
		Reporter.addStepLog("Step Log Message");
		Reporter.addStepLog("Step Log message goes here");
		Reporter.addScenarioLog("Scenario Log message goes here");

	}

}
