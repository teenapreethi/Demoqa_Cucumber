package FlipkartTask;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class flipkartStep {

	WebDriver driver;
	static String parentWindowID;

	@Given("^the user is in filpkart website$")
	public void the_user_is_in_filpkart_website() throws Throwable {
		System.setProperty("webdriver.chrome.driver",
				"E:\\Workspace\\Selenium29March18\\cucumberProject\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//*[text() = '✕']")).click();
		Thread.sleep(3000);
	}

	@When("^the user search and adds the \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\" to the cart$")
	public void the_user_search_and_adds_the_to_the_cart(String item1, String item2, String item3, String item4,
			String item5) throws Throwable {
		driver.findElement(By.name("q")).click();
		String items[] = { item1, item2, item3, item4, item5 };
		for (int i = 0; i < items.length; i++) {
			driver.findElement(By.name("q")).sendKeys(items[i]);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			Thread.sleep(3000);
			parentWindowID = driver.getWindowHandle();
			System.out.println(parentWindowID);
			// selecting 3rd product
			driver.findElement(By.xpath(
					"//*[@id='container']/div/div[1]/div/div[2]/div/div[2]/div/div[3]/div[1]/div[1]/div[3]/div/a[2]"))
					.click();

			Set<String> allWindowID = driver.getWindowHandles();
			System.out.println(allWindowID);
			for (String x : allWindowID) {
				System.out.println(x);
				if (!x.equals(parentWindowID)) {
					driver.switchTo().window(x);
					System.out.println(x);
				}
			}
			WebDriverWait wait = new WebDriverWait(driver, 10);
			// click on button
			WebElement addToCart = wait.until(ExpectedConditions
					.presenceOfElementLocated(By.xpath("//button[@class='_2AkmmA _2Npkh4 _2MWPVK']")));
			addToCart.click();
			Thread.sleep(5000);
		}
	}

	@Then("^the user verified the cart for the added items$")
	public void the_user_verified_the_cart_for_the_added_items() throws Throwable {
		Assert.assertEquals("MY CART (5)", driver
				.findElement(By.xpath("//*[@id=\"container\"]/div/div[1]/div/div/div[1]/div/div[1]/span")).getText());
		driver.quit();
	}

}
