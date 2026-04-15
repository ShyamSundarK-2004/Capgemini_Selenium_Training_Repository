package com.orangehrm.seleniumuiframwork.tests.pim;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.orangehrm.seleniumuiframework.base.BaseClass;

public class AddTerminationReasonTest extends BaseClass {

	@Test(dataProvider = "TerminationExcelData")
	public void AddTerminationReason(String Reason) throws InterruptedException {

		// click pim module
		dashboardPage.clickPIMModule();

		// click on configuration dropdown
		pimPage.clickConfigBtn();

		// click on termination link
		pimPage.clickTerminationBtn();

		// click on add button
		terminationPage.clickAddBtn();

		// give termination reason
		terminationPage.setReason(Reason);

		// click on save button
		terminationPage.clickSaveBtn();

		// verfication page
		Assert.assertTrue(terminationPage.verifyTerminationReason(Reason), "Reason not found");

	}

}