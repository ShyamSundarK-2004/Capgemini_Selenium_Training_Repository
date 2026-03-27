package com.orangehrm.seleniumuiframwork.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.seleniumuiframework.base.BaseClass;

public class DashboardPage extends BaseClass {

	public DashboardPage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	// pim module
	@FindBy(linkText = "PIM")
	private WebElement PIMModule;

	// profile menu
	@FindBy(css = "[class='oxd-userdropdown-img']")
	private WebElement profileMenu;

	// logout button
	@FindBy(linkText = "Logout")
	private WebElement logoutbtn;

	// recruitment module
	@FindBy(xpath = "//span[text()='Recruitment']")
	private WebElement recruitmentModule;

	public WebElement getPIMModule() {
		return PIMModule;
	}

	public void clickPIMModule() {
		getPIMModule().click();
	}

	public WebElement getRecruitmentModule() {
		return recruitmentModule;
	}

	public void clickRecruitmentModule() {
		getRecruitmentModule().click();
	}

	public WebElement getProfileMenu() {
		return profileMenu;
	}

	public void clickProfileMenu() {
		getProfileMenu().click();
	}

	public WebElement getLogoutbtn() {
		return logoutbtn;
	}

	public void clickLogoutbtn() {
		getLogoutbtn().click();
	}

	public void logout() {

		clickProfileMenu();
		clickLogoutbtn();
	}

}
