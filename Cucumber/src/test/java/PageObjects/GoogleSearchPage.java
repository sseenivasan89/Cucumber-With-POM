package PageObjects;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import StepDefinitions.GoogleSearchSteps;
import StepDefinitions.Hook;
import junit.framework.Assert;

public class GoogleSearchPage {

	public WebDriver driver = Hook.getDriver();

	public GoogleSearchPage() {
		PageFactory.initElements(driver, this);
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
		System.out.println();
		seleniumSearchBox.sendKeys(seleniumSearchText);
		seleniumPageSubmitButton.click();
	}

}
