package com.SeleniumTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class SwagLabs_TestAutomation extends BaseClass {

	@Test
	public void checkAddtoCart() {
		driver.findElement(By.name("add-to-cart-sauce-labs-backpack")).click();
		driver.findElement(By.name("add-to-cart-sauce-labs-bike-light")).click();
		driver.findElement(By.name("add-to-cart-sauce-labs-bolt-t-shirt")).click();
		driver.findElement(By.className("shopping_cart_link")).click();
		String cartText = driver.findElement(By.className("cart_list")).getText();

		if (cartText.contains("Sauce Labs Backpack") && cartText.contains("Sauce Labs Bike Light")
				&& cartText.contains("Sauce Labs Bolt T-Shirt")) {
			Reporter.log("Items Verified", true);
		}

	}

	@Test(dependsOnMethods = "checkAddtoCart")
	public void filterOption() {
		driver.navigate().back();
		WebElement dropdown = driver.findElement(By.className("product_sort_container"));

		Select s = new Select(dropdown);
		s.selectByIndex(1);
		dropdown = driver.findElement(By.className("product_sort_container"));
		if (dropdown.getAttribute("value") != null) {
			Reporter.log("Filtered based on : " + dropdown.getAttribute("value"), true);
		}
	}

}
