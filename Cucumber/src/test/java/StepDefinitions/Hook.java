package StepDefinitions;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import com.cucumber.listener.Reporter;
import com.google.common.io.Files;

import Helpers.CommonUtils;
import PageObjects.GoogleSearchPage;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Hook {
	public static WebDriver driver;

	@Before
	public void startSetUp() {

		if (CommonUtils.getValue().getProperty("BrowserName").equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			// driver.manage().window().maximize();
			driver.manage().window().setSize(new Dimension(1200, 800));
			driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS) ;
		}
		if (CommonUtils.getValue().getProperty("BrowserName").equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			// driver.manage().window().maximize();
			driver.manage().window().setSize(new Dimension(1200, 800));
		}

	}

	@After
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed() == true) {
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			try {
				TakesScreenshot ts = (TakesScreenshot) driver;
				File sourcePath = ts.getScreenshotAs(OutputType.FILE);
				File destinationPath = new File(
						System.getProperty("user.dir") + "/test-output/screenshots/" + screenshotName + ".png");
				Files.copy(sourcePath, destinationPath);
				Reporter.addScreenCaptureFromPath(destinationPath.toString());
			} catch (IOException e) {
			}
		}
		driver.close();
	}

	public static WebDriver getDriver() {
		return driver;
	}
}
