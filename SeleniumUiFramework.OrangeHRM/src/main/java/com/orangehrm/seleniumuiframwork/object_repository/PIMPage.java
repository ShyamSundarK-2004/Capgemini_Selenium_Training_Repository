package com.orangehrm.seleniumuiframwork.object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PIMPage {
	public PIMPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// click add button
	@FindBy(xpath = "//button[text()=' Add ']")
	private WebElement addbtn;

	// configuration dropdown
	@FindBy(xpath = "//span[text()='Configuration ']")
	WebElement configDropdown;

	// termination button
	@FindBy(linkText = "Termination Reasons")
	WebElement terminationbtn;

	public WebElement getAddBtn() {
		return addbtn;
	}

	public void clickAddBtn() {
		getAddBtn().click();
	}

	public WebElement getConfigBtn() {
		return configDropdown;
	}

	public void ClickConfigBtn() {
		getConfigBtn().click();
	}

	public WebElement getTerminationBtn() {
		return terminationbtn;
	}

	public void clickTerminationBtn() {
		getTerminationBtn().click();
	}
}
