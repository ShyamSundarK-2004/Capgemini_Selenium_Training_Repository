package com.orangehrm.seleniumuiframwork.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VacanciesPage {

	public VacanciesPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// add button
	@FindBy(xpath = "//button[text()=' Add ']")
	WebElement addbtn;

	public WebElement getAddBtn() {
		return addbtn;
	}

	public void clickAddBtn() {
		getAddBtn().click();
	}

}
