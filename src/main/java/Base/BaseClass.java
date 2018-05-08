package Base;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class BaseClass {

	public static WebDriver driver;
	public static Actions action;

	public static WebDriver launchBrowser(String url) {
		System.setProperty("WebDriver.chrome.driver",
				"E:\\Workspace\\Selenium29March18\\cucumberProject\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		return driver;

	}

	public static void quitBrowser() {
		driver.quit();
	}

	public static void searchMobiles(WebElement element, String name) {
		element.sendKeys(name);
		action= new Actions(driver);
	
	
	
	
	}
}
