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
	private WebElement username;
	@FindBy(id = "password")
	private WebElement password;
	@FindBy(id = "login-button")
	private WebElement loginbtn;

	// Business logic for entering credentials
	// getting website url
	public void webpage_url(String url) {
		driver.get(url);
	}

	public WebElement getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username.sendKeys(username);
	}

	public WebElement getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password.sendKeys(password);
		;
	}

	public void ClickLoginbtn() {
		loginbtn.click();
	}

}
