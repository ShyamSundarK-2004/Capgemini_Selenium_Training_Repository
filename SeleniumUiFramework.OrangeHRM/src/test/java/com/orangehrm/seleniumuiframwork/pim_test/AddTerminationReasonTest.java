package com.orangehrm.seleniumuiframwork.pim_test;

import org.testng.annotations.Test;

import com.orangehrm.seleniumuiframework.generic_utilities.BaseClass;

public class AddTerminationReasonTest extends BaseClass {

	@Test
	public void AddTerminationReason() {

		// click pim module
		dashboardPage.ClickPIMModule();

		// click on configuration dropdown
		pimPage.ClickConfigBtn();

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