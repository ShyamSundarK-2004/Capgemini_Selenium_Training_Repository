package com.seleniumuiframework.saucelabs.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.seleniumuiframework.saucelabs.pages.CartPage;
import com.seleniumuiframework.saucelabs.pages.InventoryItemPage;
import com.seleniumuiframework.saucelabs.pages.InventoryPage;
import com.seleniumuiframework.saucelabs.pages.LoginPage;

public class Pages {

	public static LoginPage loginPage;
	public static InventoryItemPage inventoryItemPage;
	public static InventoryPage inventoryPage;
	public static CartPage cartPage;

	// all the pages are initialized with the driver object
	public static void loadAllPages(WebDriver driver) {
		loginPage = PageFactory.initElements(driver, LoginPage.class);
		inventoryItemPage = PageFactory.initElements(driver, InventoryItemPage.class);
		inventoryPage = PageFactory.initElements(driver, InventoryPage.class);
		cartPage = PageFactory.initElements(driver, CartPage.class);
	}
}
