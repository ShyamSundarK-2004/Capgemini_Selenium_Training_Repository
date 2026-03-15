package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogoutPage {
	WebDriver driver;

	public LogoutPage(WebDriver driver) {
		this.driver = driver;
	}

	// locating menu options
	By menu = By.id("react-burger-menu-btn");
	// locating logout btn
	By logout = By.linkText("Logout");

	public void clickMenu() {
		driver.findElement(menu).click();
	}

	public void clickLogout() {
		driver.findElement(logout).click();
	}

}
