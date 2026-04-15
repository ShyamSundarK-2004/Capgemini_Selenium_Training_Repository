package com.ninjacrm.seleniumuiframework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class createCampaignsPage {
	public createCampaignsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "campaignName")
	private WebElement Name;
	@FindBy(name = "targetSize")
	private WebElement TargetSize;
	@FindBy(css = "[type='submit']")
	private WebElement createBtn;
	@FindBy(css = "[role='alert']")
	private WebElement Alert;

	public WebElement getCampaignName() {
		return Name;
	}

	public void setCampaignName(String name) {
		getCampaignName().sendKeys(name);
	}

	public WebElement getTargetSize() {
		return TargetSize;
	}

	public void setTargetSize(String size) {
		getTargetSize().clear();
		getTargetSize().sendKeys(size);
	}

	public WebElement getCreateCampaignBtn() {
		return createBtn;
	}

	public void clickCreateCampaignBtn() {
		getCreateCampaignBtn().click();
	}

	public WebElement getConfirmationMsg() {
		return Alert;
	}

}