package com.orangehrm.seleniumuiframework.utilities;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionsUtility {
	WebDriver driver;
	Actions action;

	public ActionsUtility(WebDriver driver) {
		this.driver = driver;
		this.action = new Actions(driver);
	}

	// pause
	public void pauseOnAction(long timeInSeconds) {
		action.pause(timeInSeconds);
	}

	// Click using Actions
	public void clickOnElement(WebElement element) {
		action.click(element).perform();
	}

	// SendKeys using Actions
	public void sendKeys(WebElement element, String value) {
		action.sendKeys(element, value).perform();
	}

	// keys down in dropdown
	public void navigateDownDropdown(WebElement element, int count) {
		Actions a = action.click(element).pause(2000);
		for (int i = 1; i <= count; i++) {
			a.keyDown(Keys.ARROW_DOWN);
		}
		a.click().perform();
	}

}
