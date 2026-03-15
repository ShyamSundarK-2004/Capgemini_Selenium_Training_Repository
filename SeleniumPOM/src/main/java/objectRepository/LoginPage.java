package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	WebDriver driver;

	// Constructor to initialize the WebDriver
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	// Locators
	By username = By.id("user-name");
	By password = By.id("password");
	By loginBtn = By.id("login-button");

	// getting website url
	public void webpage_url(String url) {
		driver.get(url);
	}

	// Business logic for entering credentials
	public void enterCredentials(String un, String pwd) {
		driver.findElement(username).sendKeys(un);
		driver.findElement(password).sendKeys(pwd);
	}

	// Method to click the login button
	public void clickLogin() {
		driver.findElement(loginBtn).click();
	}
}
