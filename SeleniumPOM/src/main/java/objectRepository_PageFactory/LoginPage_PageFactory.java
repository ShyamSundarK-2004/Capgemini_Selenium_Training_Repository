package objectRepository_PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage_PageFactory {

	WebDriver driver;

	// Constructor to initialize the WebDriver
	public LoginPage_PageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Locators using selenium annotation
	@FindBy(id = "user-name")
	WebElement username;
	@FindBy(id = "password")
	WebElement password;
	@FindBy(id = "login-button")
	WebElement loginbtn;

	// getting website url
	public void webpage_url(String url) {
		driver.get(url);
	}

	// Business logic for entering credentials
	public void enterCredentials(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
	}

	// Method to click the login button
	public void clickLogin() {
		loginbtn.click();
	}
}
