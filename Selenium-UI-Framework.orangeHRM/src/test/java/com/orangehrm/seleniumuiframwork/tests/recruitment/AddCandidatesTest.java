package com.orangehrm.seleniumuiframwork.tests.recruitment;

import org.testng.annotations.Test;

import com.orangehrm.seleniumuiframework.base.BaseClass;

public class AddCandidatesTest extends BaseClass {

	@Test
	public void addCandidates() {

		// click recruitment module
		dashboardPage.clickRecruitmentModule();

		// click candidated link
		recruitmentPage.clickCandidates();

		// click add in candidates page
		candidatesPage.clickAddBtn();

		// Name
		addCandidates.name("Shyam", "Sundar", "K");

		// select vacany list
		addCandidates.setVacancy("Junior Account Assistant");

		// add email id
		addCandidates.setEmailID("test@gmail.com");

		// add contact number
		addCandidates.setContactNo("7904399332");

		// add input file
		addCandidates.setInputFIle(
				"C:\\Users\\Shyam Sundar\\OneDrive\\Desktop\\Stickers\\Important files\\Capgemini_Docs\\Shyam Sundar K Resume.pdf");

		// add date of application
		addCandidates.setDate("2026-17-03");

		// click keep consent data
		addCandidates.clickKeepData();

		// click save button
		addCandidates.clickSavebtn();
	}
}
