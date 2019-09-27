package PageObjects;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import StepDefinitions.GoogleSearchSteps;
import StepDefinitions.Hook;
import junit.framework.Assert;

public class GoogleSearchPage {
	WebDriverWait wait;
	public WebDriver driver = Hook.getDriver();

	public GoogleSearchPage() {
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 30);
	}

	@FindBy(name = "q")
	public WebElement googleSearchBox;

	@FindBy(xpath = "//div[contains(text(),'Selenium - Web Browser Automation')]")
	public WebElement seleniumWebLink;

	@FindBy(css = "#q")
	public WebElement seleniumSearchBox;

	@FindBy(id = "submit")
	public WebElement seleniumPageSubmitButton;

	public void searchSelenium(String searchText) {
		googleSearchBox.sendKeys(searchText);
		googleSearchBox.submit();
	}

	public void clickSeleniumLink() {
		seleniumWebLink.click();
	}

	public void seleniumPageSearch(String seleniumSearchText) {
		Assert.assertEquals("Selenium - Web Browser Automation", driver.getTitle());
		wait.until(ExpectedConditions.visibilityOfAllElements(seleniumSearchBox));
		seleniumSearchBox.sendKeys(seleniumSearchText);
		seleniumPageSubmitButton.click();
	}

}
