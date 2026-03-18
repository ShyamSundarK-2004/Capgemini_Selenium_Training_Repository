package com.orangehrm.seleniumuiframwork.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddEmployeePage {

	public AddEmployeePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// firstname
	@FindBy(css = "[placeholder='First Name']")
	WebElement firstName;

	// middle name
	@FindBy(css = "[placeholder='Middle Name']")
	WebElement middleName;

	// lastname
	@FindBy(css = "[placeholder='Last Name']")
	WebElement lastName;

	// Employee ID
	@FindBy(xpath = "//label[text() ='Employee Id']/../..//input")
	WebElement empID;

	// create login details toggle button
	@FindBy(xpath = "//p[text()='Create Login Details']/following::label")
	WebElement togglebtn;

	// username test field
	@FindBy(xpath = "//label[text()='Username']/parent::div/following-sibling::div//input")
	WebElement userName;

	// select status of employee

	// enabled button
	@FindBy(xpath = "//label[text()='Enabled']")
	WebElement enabledbtn;

	// disabled button
	@FindBy(xpath = "//label[text()='Disabled']")
	WebElement disabledbtn;

	// password text field
	@FindBy(xpath = "//label[text()='Password']/parent::div/following-sibling::div//input")
	WebElement password;

	// password text field
	@FindBy(xpath = "//label[text()='Confirm Password']/parent::div/following-sibling::div//input")
	WebElement confirmPassword;

	// save button
	@FindBy(xpath = "//button[.=' Save ']")
	private WebElement savebtn;

	// check employee profile
	@FindBy(css = "[class='oxd-text oxd-text--h6 --strong']")
	private WebElement empdetails;

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

	public WebElement getEmpID() {
		return empID;
	}

	public void setEmpID(String empID) {
		getEmpID().sendKeys(Keys.CONTROL + "a", Keys.DELETE);
		getEmpID().sendKeys(empID);
	}

	public WebElement getTogglebtn() {
		return togglebtn;
	}

	public void clickTogglebtn() {
		getTogglebtn().click();
	}

	public WebElement getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		getUserName().sendKeys(userName);
	}

	public WebElement getEnabledbtn() {
		return enabledbtn;
	}

	public void clickEnabledbtn() {
		getEnabledbtn().click();
	}

	public WebElement getDisabledbtn() {
		return disabledbtn;
	}

	public void clickDisabledbtn() {
		getDisabledbtn().click();
	}

	public WebElement getpassword() {
		return password;
	}

	public void setPassword(String password) {
		getpassword().sendKeys(password);
	}

	public WebElement getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		getConfirmPassword().sendKeys(confirmPassword);
	}

	public WebElement getSaveBtn() {
		return savebtn;
	}

	public void clickSaveBtn() {
		getSaveBtn().click();
	}

	public WebElement getProfile() {
		return empdetails;
	}

	public void addEmployee(String firstName, String middleName, String lastName, String empID) {
		setFirstName(firstName);
		setMiddleName(middleName);
		setLastName(lastName);
		setEmpID(empID);

	}

	public void createCredentials(String userName, String password) {
		setUserName(userName);
		setPassword(password);
		setConfirmPassword(password);
	}
}
