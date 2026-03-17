package com.orangehrm.seleniumuiframwork.object_repository;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddVacanciesPage {
	private Actions a;

	public AddVacanciesPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
		a = new Actions(driver);
	}

	// vacany name
	@FindBy(xpath = "//label[text()='Vacancy Name']/parent::div/following-sibling::div//input")
	private WebElement vacancyName;

	// job title
	@FindBy(xpath = "//label[text()='Job Title']/parent::div/following-sibling::div//div[text()='-- Select --']")
	private WebElement jobTitleDropdown;

	// job title listbox
	@FindBy(xpath = "//div[@role='listbox']")
	private WebElement jobTitleList;

	// description
	@FindBy(css = "textarea[placeholder='Type description here']")
	private WebElement description;

	// hiring manager
	@FindBy(css = "[placeholder='Type for hints...']")
	private WebElement hiringManager;

	// number of positions
	@FindBy(xpath = "//label[.='Number of Positions']/parent::div/following-sibling::div//input")
	private WebElement noOfPositions;

	// save button
	@FindBy(xpath = "//button[.=' Save ']")
	private WebElement savebtn;

	// Vacancy Name
	public WebElement getVacancyName() {
		return vacancyName;
	}

	public void setVacancyName(String name) {
		getVacancyName().sendKeys(name);
	}

	// Job Title Dropdown
	public WebElement getJobTitleDropdown() {
		return jobTitleDropdown;
	}

	public void clickJobTitleDropdown(String jobtitle) {

		getJobTitleDropdown().click();
		WebElement listbox = jobTitleList.findElement(By.xpath("//span[text()='" + jobtitle + "']"));
		listbox.click();
	}

	// Description
	public WebElement getDescription() {
		return description;
	}

	public void setDescription(String text) {
		getDescription().sendKeys(text);
	}

	// Hiring Manager
	public WebElement getHiringManager() {
		return hiringManager;
	}

	public void setHiringManager(String manager) {
		getHiringManager().sendKeys(manager);
		a.click(getHiringManager()).pause(3000).keyDown(Keys.ARROW_DOWN).keyDown(Keys.ENTER).perform();
	}

	// Number Of Positions
	public WebElement getNoOfPositions() {
		return noOfPositions;
	}

	public void setNoOfPositions(String number) {
		getNoOfPositions().sendKeys(number);
	}

	// Save Button
	public WebElement getSavebtn() {
		return savebtn;
	}

	public void clickSaveButton() {
		getSavebtn().click();
	}
}
