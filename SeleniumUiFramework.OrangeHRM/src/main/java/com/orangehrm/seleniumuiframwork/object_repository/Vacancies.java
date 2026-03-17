package com.orangehrm.seleniumuiframwork.object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Vacancies {

	public Vacancies(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// add button
	@FindBy(xpath = "//button[text()=' Add ']")
	WebElement addbtn;

	public WebElement getAddBtn() {
		return addbtn;
	}

	public void ClickAddBtn() {
		getAddBtn().click();
	}

}
