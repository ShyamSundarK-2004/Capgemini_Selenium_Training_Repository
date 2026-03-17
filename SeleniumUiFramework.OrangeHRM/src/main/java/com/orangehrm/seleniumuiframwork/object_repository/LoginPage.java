package com.orangehrm.seleniumuiframwork.object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// username text field
	@FindBy(name = "username")
	private WebElement username;

	// password text field
	@FindBy(name = "password")
	private WebElement password;

	// login button
	@FindBy(css = "[type='submit']")
	private WebElement loginbtn;

	// forgot password button link
	@FindBy(xpath = "//p[.='Forgot your password? ']")
	private WebElement forgotPwd;

	// orangehrm official page URL
	@FindBy(css = "[href='http://www.orangehrm.com']")
	private WebElement orangehrmPage;

	// orangeHRM linkedin page
	@FindBy(css = "['href='https://www.linkedin.com/company/orangehrm/mycompany/']")
	private WebElement linkedinURL;

	// orangeHRM facebook page
	@FindBy(css = "[href='https://www.facebook.com/OrangeHRM/']")
	private WebElement facebookURL;

	// orangeHRM twitter page
	@FindBy(css = "[href='https://twitter.com/orangehrm?lang=en']")
	private WebElement twitterURL;

	// orangeHRM youtube page
	@FindBy(css = "[href='https://www.youtube.com/c/OrangeHRMInc']")
	private WebElement youtubeURL;

	public WebElement getUsername() {
		return username;
	}

	public void setUsername(String username) {
		getUsername().sendKeys(username);

	}

	public WebElement getPassword() {
		return password;
	}

	public void setPassword(String password) {
		getPassword().sendKeys(password);
	}

	public WebElement getLoginbtn() {
		return loginbtn;
	}

	public void ClickLoginbtn() {
		getLoginbtn().click();
	}

	public WebElement getForgetPwd() {
		return forgotPwd;
	}

	public void ClickForgotPwd() {
		getForgetPwd().click();
	}

	public WebElement getOrangehrmPage() {
		return orangehrmPage;
	}

	public void ClickOrangehrmPage() {
		getOrangehrmPage().click();
	}

	public WebElement getLinkedinURL() {
		return linkedinURL;
	}

	public void ClickLinkedinURL() {
		getLinkedinURL().click();
	}

	public WebElement getFacebookURL() {
		return facebookURL;
	}

	public void ClickFacebookURL() {
		getFacebookURL().click();
	}

	public WebElement getTwitterURL() {
		return twitterURL;
	}

	public void ClickTwitterURL() {
		getTwitterURL().click();
	}

	public WebElement getYoutubeURL() {
		return youtubeURL;
	}

	public void ClickYoutubeURL() {
		getYoutubeURL().click();
	}

	public void login(String username, String password) {
		setUsername(username);
		setPassword(password);
		ClickLoginbtn();
	}

}
