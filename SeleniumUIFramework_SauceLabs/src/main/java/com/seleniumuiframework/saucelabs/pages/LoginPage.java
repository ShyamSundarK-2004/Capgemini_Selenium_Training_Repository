package com.seleniumuiframework.saucelabs.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

	// username
	@FindBy(id = "user-name")
	private WebElement username;

	// password
	@FindBy(id = "password")
	private WebElement password;

	// login button
	@FindBy(id = "login-button")
	private WebElement loginbtn;

	public WebElement getUserName() {
		return username;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLoginBtn() {
		return loginbtn;
	}

	// business login
	public void login(String username, String password) {
		getUserName().sendKeys(username);
		getPassword().sendKeys(password);
		getLoginBtn().click();
	}

}
