package com.orangehrm.seleniumuiframwork.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RecruitmentPage {

	public RecruitmentPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// vacancies link
	@FindBy(linkText = "Vacancies")
	private WebElement vacancies;

	// candidates link
	@FindBy(linkText = "Candidates")
	private WebElement candidates;

	public WebElement getVacancies() {
		return vacancies;
	}

	public void clickVacancies() {
		getVacancies().click();
	}

	public WebElement getCandidates() {
		return candidates;
	}

	public void clickCandidates() {
		getCandidates().click();
	}

}
