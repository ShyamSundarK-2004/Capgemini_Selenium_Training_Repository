package com.orangehrm.seleniumuiframework.pim;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.genericUtilities.BaseClass;

public class PIM_Test extends BaseClass {

	@Test
	public void pimModule() {

		// adding employee details

		// click in pim module
		driver.findElement(By.cssSelector("[href='/web/index.php/pim/viewPimModule']")).click();
		// click add btn
		driver.findElement(By.xpath("//div[@class='orangehrm-header-container']//button")).click();
		// enter first,second, last name
		driver.findElement(By.name("firstName")).sendKeys("Salaar");
		driver.findElement(By.name("middleName")).sendKeys("Devaratha");
		driver.findElement(By.name("lastName")).sendKeys("Raisaar");
		// enter empID
		WebElement empId = driver.findElement(By.xpath("(//label[text()='Employee Id']//following::input)[1]"));
		empId.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
		empId.sendKeys("2200");
		// click toggle btn
		driver.findElement(By.xpath("//input[@type='checkbox']/following-sibling::span")).click();
		// username
		driver.findElement(By.xpath("//label[text()='Username']//parent::div/following-sibling::div//input"))
				.sendKeys("Devaratha");
		// status dropdown
		driver.findElement(By.xpath("//label[text()='Enabled']")).click();
		// password
		WebElement pwd = driver.findElement(
				By.xpath("//label[text()='Password']/parent::div/following-sibling::div//input[@type='password']"));
		wait.until(ExpectedConditions.visibilityOf(pwd)).sendKeys("22Dec2023");
		// confirm dropdown
		driver.findElement(By.xpath(
				"//label[text()='Confirm Password']/parent::div/following-sibling::div//input[@type='password']"))
				.sendKeys("22Dec2023");
		// click save
		driver.findElement(By.cssSelector("[type='submit']")).click();

		// verfication
		if (driver.findElement(By.cssSelector("[class='orangehrm-background-container']")).isDisplayed())
			Reporter.log("Employee Record Created", true);

		// checking employee details

		// click admin module
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[text()='Admin']")))).click();
		// enter username
		driver.findElement(By.xpath("//label[text()='Username']/parent::div/following-sibling::div/input"))
				.sendKeys("Devaratha");
		// select usrrole dropdown
		WebElement usrRole = driver.findElement(By.xpath("(//div[text()='-- Select --'])[1]"));
		usrRole.click();
		usrRole.sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
		// search emp name
		WebElement empname = driver.findElement(By.cssSelector("[placeholder='Type for hints...']"));
		a.click(empname).sendKeys("Salaar Devaratha").pause(2000).sendKeys(Keys.ARROW_DOWN, Keys.ENTER).perform();
		// select status dropdown
		WebElement status = driver.findElement(By.xpath("//div[text()='-- Select --']"));
		a.click(status).pause(2000).sendKeys(Keys.ARROW_DOWN, Keys.ENTER).perform();
		// click search btn
		driver.findElement(By.cssSelector("[type='submit']")).click();

		// verification
		if (driver.findElement(By.xpath("(//div[@role='cell'])[2]")).isDisplayed()) {
			String empDetails = driver.findElement(By.xpath("(//div[@role='cell'])[2]")).getText();
			if (empDetails.contains("Devaratha"))
				Reporter.log("Employee detailed added and verified", true);
		} else {
			Reporter.log("No User found.", true);
		}
	}

}
