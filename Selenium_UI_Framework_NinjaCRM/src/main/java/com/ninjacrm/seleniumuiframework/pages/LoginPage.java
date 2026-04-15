package com.ninjacrm.seleniumuiframework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "username")
	WebElement username;

	@FindBy(id = "inputPassword")
	WebElement password;

	@FindBy(css = "[type='submit']")
	WebElement loginbtn;

	public WebElement getUserName() {
		return username;
	}

	public void setUserName(String usrName) {
		getUserName().sendKeys(usrName);
	}

	public WebElement getPassword() {
		return password;
	}

	public void setPassword(String pwd) {
		getPassword().sendKeys(pwd);
	}

	public WebElement getLoginBtn() {
		return loginbtn;
	}

	public void clickLoginBtn() {
		getLoginBtn().click();
	}

	public void login(String usrname, String password) {
		setUserName(usrname);
		setPassword(password);
		clickLoginBtn();
	}

}
