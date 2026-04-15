package com.seleniumuiframework.saucelabs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InventoryPage {

	// menu
	@FindBy(id = "react-burger-menu-btn")
	private WebElement menu;

	// logout button
	@FindBy(linkText = "Logout")
	private WebElement logoutbtn;

	// cart button
	@FindBy(id = "shopping_cart_container")
	private WebElement shoppingCart;

	public WebElement getMenu() {
		return menu;
	}

	public WebElement getLogoutBtn() {
		return logoutbtn;
	}

	public WebElement getShoppingCart() {
		return shoppingCart;
	}

	// business logic
	public void logout() {
		getMenu().click();
		getLogoutBtn().click();
	}

	public void clickOnCartBtn() {
		getShoppingCart().click();
	}

	public void clickOnProduct(WebDriver driver, String ProductName) {
		driver.findElement(By.xpath("//div[text()='" + ProductName + "']")).click();
	}

}
