package com.ninjacrm.seleniumuiframework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashBoardPage {

	public DashBoardPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// campaign module
	@FindBy(linkText = "Campaigns")
	WebElement campaignsModule;

	// user icon
	@FindBy(css = "[class='user-icon']")
	WebElement userIcon;

	// logout button
	@FindBy(xpath = "//div[text() = 'Logout ']")
	WebElement logoutbtn;

	public WebElement getCampaignModule() {
		return campaignsModule;
	}

	public void clickCampaignModule() {
		getCampaignModule().click();
	}

	public WebElement getUserIcon() {
		return userIcon;
	}

	public void clickUserIcon() {
		getUserIcon().click();
	}

	public WebElement getLogoutBtn() {
		return logoutbtn;
	}

	public void clickLogoutBtn() {
		getLogoutBtn().click();
	}
}
