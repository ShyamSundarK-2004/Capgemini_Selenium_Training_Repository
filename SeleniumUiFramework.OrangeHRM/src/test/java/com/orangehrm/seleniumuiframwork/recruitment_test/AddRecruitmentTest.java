package com.orangehrm.seleniumuiframwork.recruitment_test;

import org.testng.annotations.Test;

import com.genericUtilities.BaseClass;

public class AddRecruitmentTest extends BaseClass {

	@Test
	public void addRecruitment() {
		// click recruitment module
		dashboardPage.ClickRecruitmentModule();

		// click vacancies button
		recruitmentPage.ClickVacancies();

		// click add button in vacancies
		vacancies.ClickAddBtn();

		// enter vacancy name
		addVacanciesPage.setVacancyName("a000000000000002026");

		// select job title
		addVacanciesPage.clickJobTitleDropdown("Account Assistant");

		// enter description
		addVacanciesPage.setDescription("Java Developer role for freshers");

		// select hiring manager
		addVacanciesPage.setHiringManager("Peter ");

		// enter number of positions
		addVacanciesPage.setNoOfPositions("10");

		// save button
		addVacanciesPage.clickSaveButton();

	}

}
