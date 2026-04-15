package com.ninjacrm.seleniumuiframework.test;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.ninjacrm.seleniumuiframework.utilities.BaseClass;

public class CreateCampaign_Test extends BaseClass {

	@Test(dataProvider = "createCampaign")
	public void createCampaign(String Campaign_Name, String Target_Size) {
		// clicking campaign module
		dashboardpage.clickCampaignModule();

		// click create campaign button
		campaignPage.clickCreateCampaignBtn();

		// enter the campaign name
		createCampaignPage.setCampaignName(Campaign_Name);

		// enter the target size
		createCampaignPage.setTargetSize(Target_Size);

		// click on create campaign button
		createCampaignPage.clickCreateCampaignBtn();

		webutility.waitUntilElementIsVisibility(2000, createCampaignPage.getConfirmationMsg());

		Assert.assertTrue(createCampaignPage.getConfirmationMsg().getText().contains("Successfully"), "Not Displayed");

		Reporter.log("displayed successfully", true);

	}
}
