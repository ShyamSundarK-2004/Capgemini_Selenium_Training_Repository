package com.orangehrm.seleniumuiframwork.pim_test;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.orangehrm.seleniumuiframework.generic_utilities.BaseClass;

public class AddEmployeeTest extends BaseClass {

	@Test
	public void addEmployee() {

		// click pim module
		dashboardPage.ClickPIMModule();

		// click on add employee button
		pimPage.clickAddBtn();

		// add employee details
		addEmpPage.addEmployee("Shyam", "Sundar", "K", "1110");

		// click on create credential toggle button
		addEmpPage.clickTogglebtn();
//		js.executeScript("arguments[0].click()", addEmpPage.getTogglebtn());

		// enter username and password
		addEmpPage.createCredentials("Shyam@007", "Shyam@123");

		// click on save button
		wait.until(ExpectedConditions.elementToBeClickable(addEmpPage.getSaveBtn())).click();

		// wait till saved
		wait.until(ExpectedConditions.visibilityOf(addEmpPage.getProfile()));

		Assert.assertTrue(driver.getCurrentUrl().contains("viewPersonalDetails"), "Employee Details Not Saved");

	}

}
