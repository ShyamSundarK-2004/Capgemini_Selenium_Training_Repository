package com.orangehrm.seleniumuiframwork.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TerminationPage {

	public TerminationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// add button
	@FindBy(xpath = "//button[text()=' Add ']")
	WebElement addbtn;

	// name test field
	@FindBy(xpath = "//label[text()='Name']/parent::div/following::input")
	WebElement reason;

	// save button
	@FindBy(css = "[type='submit']")
	WebElement savebtn;

	// cancel button
	@FindBy(xpath = "//button[text() = ' Cancel ']")
	WebElement cancelbtn;

	public WebElement getAddBtn() {
		return addbtn;
	}

	public void clickAddBtn() {
		getAddBtn().click();
	}

	public WebElement getReason() {
		return reason;
	}

	public void setReason(String reason) {
		getReason().sendKeys(reason);
	}

	public WebElement getSaveBtn() {
		return savebtn;
	}

	public void clickSaveBtn() {
		getSaveBtn().click();
	}

	public WebElement getCancelBtn() {
		return cancelbtn;
	}

	public void ClickCancelBtn() {
		getCancelBtn().click();
	}
}
