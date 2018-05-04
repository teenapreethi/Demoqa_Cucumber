package org.test.cucumberProject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinition {
	WebDriver driver;
	String selectedValue;
	Select s;
	WebElement firstSelectedOption;
	String Value;

	@Given("^The user is in DemoQa website$")
	public void the_user_is_in_DemoQa_website() throws Throwable {
		System.setProperty("webdriver.chrome.driver",
				"E:\\Workspace\\Selenium29March18\\cucumberProject\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://demoqa.com/registration/");
	}

	@When("^The user enters fistname and lastname$")
	public void the_user_enters_fistname_and_lastname() throws Throwable {
		driver.findElement(By.id("name_3_firstname")).sendKeys("Teena Preethi");
		driver.findElement(By.id("name_3_lastname")).sendKeys("Gopi");
	}

	@Then("^The user verifies the firstname and lastname$")
	public void the_user_verifies_the_firstname_and_lastname() throws Throwable {
		Assert.assertEquals("Teena Preethi", driver.findElement(By.id("name_3_firstname")).getAttribute("value"));
		Assert.assertEquals("Gopi", driver.findElement(By.id("name_3_lastname")).getAttribute("value"));
		driver.quit();
	}

	@When("^The user selects Marital Status as Single$")
	public void the_user_selects_Marital_Status_as_Single() throws Throwable {
		driver.findElement(By.name("radio_4[]")).click();
	}

	@When("^The user checks Hobby as Dance and Reading$")
	public void the_user_checks_Hobby_as_Dance_and_Reading() throws Throwable {
		driver.findElement(By.xpath("//input[@value='dance']")).click();
		driver.findElement(By.xpath("//input[@value='reading']")).click();
	}

	@Then("^verify the selected Marital Status and Checked Hobby$")
	public void verify_the_selected_Marital_Status_and_Checked_Hobby() throws Throwable {
		Assert.assertEquals("Single", driver.findElement(By.xpath("//label[text()='Single']")).getText());
		Assert.assertEquals("Dance", driver.findElement(By.xpath("//label[text()='Dance']")).getText());
		Assert.assertEquals("Reading", driver.findElement(By.xpath("//label[text()='Reading']")).getText());
		driver.quit();
	}

	@When("^The user checks the default value for country is Afghanistan$")
	public void the_user_checks_the_default_value_for_country_is_Afghanistan() throws Throwable {
		s= new Select (driver.findElement(By.id("dropdown_7")));
		firstSelectedOption = s.getFirstSelectedOption();
		Value = firstSelectedOption.getText();
	}

	@Then("^The user verifies the default value for country is Afghanistan$")
	public void the_user_verifies_the_default_value_for_country_is_Afghanistan() throws Throwable {
		Assert.assertEquals("Afghanistan", Value);
		driver.quit();
	}

}