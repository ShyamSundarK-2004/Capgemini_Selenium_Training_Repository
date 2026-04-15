package com.seleniumuiframework.saucelabs.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InventoryItemPage {

	// add to cart button
	@FindBy(id = "add-to-cart")
	private WebElement addToCartBtn;

	public WebElement getAddToCartBtn() {
		return addToCartBtn;
	}

	// businees logic
	public void clickOnAddToCart() {
		getAddToCartBtn().click();
	}
}
