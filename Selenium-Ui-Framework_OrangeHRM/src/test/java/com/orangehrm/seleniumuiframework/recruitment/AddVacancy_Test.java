package com.orangehrm.seleniumuiframework.recruitment;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.orangehrm.seleniumuiframework.base.BaseClass;

public class AddVacancy_Test extends BaseClass {

	@Test(dataProvider = "VacancyExcelData")
	public void addRecruitment(String VacancyName, String JobTitle, String Description, String HiringManager,
			String NumberOfPositions, String Active, String PublishInRSS) {

		// click recruitment module
		dashboardPage.clickRecruitmentModule();

		// click vacancies button
		recruitmentPage.clickVacancies();

		// click add button
		vacancies.clickAddBtn();

		// Data from Excel
		addVacanciesPage.setVacancyName(VacancyName);
		addVacanciesPage.clickJobTitleDropdown(JobTitle);
		addVacanciesPage.setDescription(Description);
		addVacanciesPage.setHiringManager(HiringManager);
		addVacanciesPage.setNoOfPositions(NumberOfPositions);

		// save
		addVacanciesPage.clickSaveButton();

		// validation
		webutility.waitUntilElementIsVisibility(15L, addVacanciesPage.getCheckSaved());
		Assert.assertTrue(addVacanciesPage.getCheckSaved().isDisplayed(), "Recruitment not saved");
	}
}