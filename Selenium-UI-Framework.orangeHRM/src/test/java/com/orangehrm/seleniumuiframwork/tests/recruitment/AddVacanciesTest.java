package com.orangehrm.seleniumuiframwork.tests.recruitment;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.orangehrm.seleniumuiframework.base.BaseClass;

public class AddVacanciesTest extends BaseClass {

	@Test
	public void addRecruitment() {
		// click recruitment module
		dashboardPage.clickRecruitmentModule();

		// click vacancies button
		recruitmentPage.clickVacancies();

		// click add button in vacancies
		vacancies.clickAddBtn();

		// enter vacancy name
		addVacanciesPage.setVacancyName("a10000000000002026");

		// select job title
		addVacanciesPage.clickJobTitleDropdown("Automaton Tester");

		// enter description
		addVacanciesPage.setDescription("Java Developer role for freshers");

		// select hiring manager
		addVacanciesPage.setHiringManager("Peter ");

		// enter number of positions
		addVacanciesPage.setNoOfPositions("10");

		// save button
		addVacanciesPage.clickSaveButton();

		// checking saved or not
		Assert.assertTrue(addVacanciesPage.getCheckSaved().isDisplayed(), "Recruitement not saved");

	}

}
