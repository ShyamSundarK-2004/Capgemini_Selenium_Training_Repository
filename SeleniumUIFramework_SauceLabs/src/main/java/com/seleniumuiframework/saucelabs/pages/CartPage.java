package com.seleniumuiframework.saucelabs.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage {

	// item name
	@FindBy(className = "inventory_item_name")
	private WebElement itemList;

	// remove button
	@FindBy(id = "remove-sauce-labs-backpack")
	private WebElement removebtn;

	public WebElement getItemList() {
		return itemList;
	}

	public WebElement getRemoveBtn() {
		return removebtn;
	}

	// business logic
	public void removeItem() {
		getRemoveBtn().click();
	}

	public String captureProductName() {
		return getItemList().getText();
	}
}
