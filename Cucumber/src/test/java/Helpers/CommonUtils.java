package Helpers;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonUtils {
	static Properties prop = new Properties();

	public static Properties getValue() {
		InputStream input = null;
		try {

			File propFile = new File(System.getProperty("user.dir") + "/src/test/java/Helpers/Resoruce.properties");

			if (!propFile.exists()) {
				prop.load(CommonUtils.class.getResourceAsStream(
						System.getProperty("user.dir") + "/src/test/java/Helpers/Resoruce.properties"));
			} else {
				input = new FileInputStream(propFile);
				prop.load(input);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return prop;
	}

	public static void WaitForElement(WebDriver driver, String LocatorName, String Element) {
		if (LocatorName.equalsIgnoreCase("Xpath")) {
			WebDriverWait wait = new WebDriverWait(driver, 200);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Element)));
			driver.findElement(By.xpath(Element)).isDisplayed();
		}
	}
	
	
}
