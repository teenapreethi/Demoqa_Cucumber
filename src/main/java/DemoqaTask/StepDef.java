package DemoqaTask;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDef {

	WebDriver driver;
	String selectedValue;
	Select s;
	WebElement firstSelectedOption;
	String Value;

	@Given("^the user is in Demoqa Website$")
	public void the_user_is_in_Demoqa_Website() throws Throwable {
		System.setProperty("WebDriver.chrome.driver",
				"E:\\Workspace\\Selenium29March18\\cucumberProject\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://demoqa.com/registration/");
	}

	@When("^the user enters firstname and lastname$")
	public void the_user_enters_firstname_and_lastname() throws Throwable {
		driver.findElement(By.id("name_3_firstname")).sendKeys("First Name");
		driver.findElement(By.id("name_3_lastname")).sendKeys("Last Name");
	}

	@Then("^the user verifies the textbox$")
	public void the_user_verifies_the_textbox() throws Throwable {
		Assert.assertEquals("First Name", driver.findElement(By.id("name_3_firstname")).getAttribute("value"));
		Assert.assertEquals("Last Name", driver.findElement(By.id("name_3_lastname")).getAttribute("value"));
		driver.quit();
	}

	@When("^the user clicks single radiobutton$")
	public void the_user_clicks_single_radiobutton() throws Throwable {
		driver.findElement(By.name("radio_4[]")).click();
	}

	@Then("^the user verifies the checked Single radiobutton$")
	public void the_user_verifies_the_checked_Single_radiobutton() throws Throwable {
		Assert.assertEquals("Single", driver.findElement(By.xpath("//label[text()='Single']")).getText());
		driver.quit();
	}

	@When("^the user selects the Dance and Reading checkboxes$")
	public void the_user_selects_the_Dance_and_Reading_checkboxes() throws Throwable {
		driver.findElement(By.xpath("//input[@value='dance']")).click();
		driver.findElement(By.xpath("//input[@value='reading']")).click();
	}

	@Then("^the user verifies the Dance and Reading checkboxes$")
	public void the_user_verifies_the_Dance_and_Reading_checkboxes() throws Throwable {
		Assert.assertEquals("Dance", driver.findElement(By.xpath("//label[text()='Dance']")).getText());
		Assert.assertEquals("Reading", driver.findElement(By.xpath("//label[text()='Reading']")).getText());
		driver.quit();
	}

	@When("^the selects the India Option from dropdown$")
	public void the_selects_the_India_Option_from_dropdown() throws Throwable {
		s= new Select (driver.findElement(By.id("dropdown_7")));
		firstSelectedOption = s.getFirstSelectedOption();
		Value = firstSelectedOption.getText();
	}

	@Then("^the user verifies the India Option from dropdown$")
	public void the_user_verifies_the_India_Option_from_dropdown() throws Throwable {
		Assert.assertEquals("Afghanistan", Value);
		driver.quit();
	}

}
