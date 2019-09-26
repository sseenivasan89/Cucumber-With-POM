package StepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import PageObjects.GoogleSearchPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class GoogleSearchSteps extends GoogleSearchPage {

	@Given("^I Launch Goolge$")
	public void i_Launch_Goolge() throws Throwable {
		driver.get("https://www.google.com");
	}

	@Given("^I Search For Selenium$")
	public void i_Search_For_Selenium() throws Throwable {
		searchSelenium("Selenium");
	}

	@Then("^I Select The Link$")
	public void i_Select_The_Link() throws Throwable {
		clickSeleniumLink();
	}

	@Then("^I Search Something On Selenium Page$")
	public void i_Search_Something_On_Selenium_Page() throws Throwable {
		searchSelenium("Selenium");
	}

}
