package com.orangehrm.seleniumuiframwork.tests.pim;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.orangehrm.seleniumuiframework.base.BaseClass;

public class AddEmployee_Test extends BaseClass {

	@Test(dataProvider = "EmployeeExcelData")
	public void addEmployee(String FirstName, String MiddleName, String LastName, String EmpID, String Username,
			String Password) {

		// click pim module
		dashboardPage.clickPIMModule();

		// click on add employee button
		pimPage.clickAddBtn();

		// add employee details
		addEmpPage.addEmployee(FirstName, MiddleName, LastName, EmpID);

		// click on create credential toggle button
		addEmpPage.clickTogglebtn();
//		js.executeScript("arguments[0].click()", addEmpPage.getTogglebtn());

		// enter username and password
		addEmpPage.createCredentials(Username, Password);

		// click on save button
		webutility.waitUntillElementIsCLickable(10L, addEmpPage.getSaveBtn());
		addEmpPage.clickSaveBtn();

		// wait till saved
		webutility.waitUntilElementIsVisibility(15L, addEmpPage.getProfile());

		Assert.assertTrue(driver.getCurrentUrl().contains("viewPersonalDetails"), "Employee Details Not Saved");

	}

}
