package com.orangehrm.seleniumuiframework.recruitment;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.orangehrm.seleniumuiframework.base.BaseClass;

public class AddCandidates_Test extends BaseClass {

	@Test(dataProvider = "CandidateExcelData")
	public void addCandidates(String FirstName, String MiddleName, String LastName, String Vacancy, String Email,
			String ContactNo, String ResumePath, String date, String Consent) throws InterruptedException {

		// click recruitment module
		dashboardPage.clickRecruitmentModule();

		// click candidated link
		recruitmentPage.clickCandidates();

		// click add in candidates page
		candidatesPage.clickAddBtn();

		// Name
		addCandidates.name(FirstName, MiddleName, LastName);

		// select vacany list
		addCandidates.setVacancy(Vacancy);

		// add email id
		addCandidates.setEmailID(Email);

		// add contact number
		addCandidates.setContactNo(ContactNo);

		// add input file
		addCandidates.setInputFIle(ResumePath);

		// add date of application
		addCandidates.setDate(date);

		// click keep consent data
		addCandidates.clickKeepData();

		// click save button
		addCandidates.clickSavebtn();

		// click pim page again
		recruitmentPage.clickCandidates();

		Assert.assertTrue(addCandidates.ValidateCandidateList(FirstName), "Candidate was NOT found in the table");
	}
}
