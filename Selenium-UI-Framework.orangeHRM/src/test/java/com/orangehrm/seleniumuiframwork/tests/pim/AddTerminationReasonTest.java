package com.orangehrm.seleniumuiframwork.tests.pim;

import org.testng.annotations.Test;

import com.orangehrm.seleniumuiframework.base.BaseClass;

public class AddTerminationReasonTest extends BaseClass {

	@Test
	public void AddTerminationReason() {

		// click pim module
		dashboardPage.clickPIMModule();

		// click on configuration dropdown
		pimPage.clickConfigBtn();

		// click on termination link
		pimPage.clickTerminationBtn();

		// click on add button
		terminationPage.clickAddBtn();

		// give termination reason
		terminationPage.setReason("poor time management");

		// click on save button
		terminationPage.clickSaveBtn();

	}

}