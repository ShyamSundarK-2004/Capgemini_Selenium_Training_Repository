package com.orangehrm.seleniumuiframwork.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.seleniumuiframework.utilities.WebDriverUtility;

public class AddCandidatesPage {

	WebDriverUtility webutility = null;

	public AddCandidatesPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		webutility = new WebDriverUtility(driver);

	}

	// first name
	@FindBy(name = "firstName")
	private WebElement firstName;

	// middle name
	@FindBy(name = "middleName")
	private WebElement middleName;

	// last name
	@FindBy(name = "lastName")
	private WebElement lastName;

	// vacancy
	@FindBy(xpath = "//div[text()='-- Select --']")
	private WebElement vacancy;

	// vacancy listbox
	@FindBy(xpath = "//div[@role='listbox']")
	private WebElement vacancyList;

	// email ID
	@FindBy(xpath = "//label[text()='Email']/parent::div/following-sibling::div//input")
	private WebElement emailID;

	// contact number
	@FindBy(xpath = "//label[text()='Contact Number']/parent::div/following-sibling::div//input")
	private WebElement contactNo;

	// upload a file
	@FindBy(css = "[type='file']")
	private WebElement inputFIle;

	// keywords
	@FindBy(css = "[placeholder='Enter comma seperated words...']")
	private WebElement keywords;

	// date
	@FindBy(css = "[placeholder='yyyy-dd-mm']")
	private WebElement date;

	// notes
	@FindBy(css = "textarea[placeholder='Type here']")
	private WebElement notes;

	// Consent to keep data
	@FindBy(xpath = "//label[text()='Consent to keep data']/parent::div/following-sibling::div//span")
	private WebElement keepData;

	// save button
	@FindBy(xpath = "//button[text()=' Save ']")
	private WebElement savebtn;

	// cancel button
	@FindBy(xpath = "//button[text()=' Cancel ']")
	private WebElement cancelbtn;

	// candidates list
	@FindBy(xpath = "//div[@role='row']//div[3]")
	private List<WebElement> candidateList;

	// List next button
	@FindBy(xpath = "//button[.//i[contains(@class,'bi-chevron-right')]]")
	private WebElement nextbtn;

	public WebElement getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		getFirstName().sendKeys(firstName);
	}

	public WebElement getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		getMiddleName().sendKeys(middleName);
	}

	public WebElement getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		getLastName().sendKeys(lastName);
	}

	public WebElement getVacancy() {
		return vacancy;
	}

	public WebElement getVacancyList() {
		return vacancyList;
	}

	public void setVacancy(String vacancy) {
		getVacancy().click();
		webutility.waitUntilElementIsVisibility(10L, getVacancyList());
		WebElement list = vacancyList.findElement(By.xpath("//span[contains(.,'" + vacancy + "')]"));
		list.click();
	}

	public WebElement getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		getEmailID().sendKeys(emailID);
	}

	public WebElement getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		getContactNo().sendKeys(contactNo);
	}

	public WebElement getInputFIle() {
		return inputFIle;
	}

	public void setInputFIle(String inputFIle) {
		getInputFIle().sendKeys(inputFIle);
	}

	public WebElement getDate() {
		return date;
	}

	public void setDate(String date) {
		getDate().sendKeys(Keys.CONTROL + "a", Keys.DELETE);
		getDate().sendKeys(date);
	}

	public WebElement getKeepData() {
		return keepData;
	}

	public void clickKeepData() {
		getKeepData().click();
	}

	public WebElement getSavebtn() {
		return savebtn;
	}

	public void clickSavebtn() {
		getSavebtn().click();
	}

	public WebElement getCancelbtn() {
		return cancelbtn;
	}

	public void clickCancelbtn() {
		getCancelbtn().click();
	}

	public void name(String firstname, String middlename, String lastname) {
		setFirstName(firstname);
		setMiddleName(middlename);
		setLastName(lastname);
	}

	public List<WebElement> getCandidateList() {
		return candidateList;
	}

	public WebElement getNextBtn() {
		return nextbtn;
	}

	public boolean ValidateCandidateList(String firstName) {
		boolean flag = false;

		while (true) {

			for (WebElement row : getCandidateList()) {
				if (row.getText().contains(firstName)) {
					flag = true;
					break;
				}
			}

			if (flag) {
				break;
			}
			WebElement nextBtn = getNextBtn();

			if (nextbtn.isDisplayed() || nextBtn.isEnabled()) {
				nextBtn.click();
			} else {
				break;
			}
		}

		return flag;
	}

}
