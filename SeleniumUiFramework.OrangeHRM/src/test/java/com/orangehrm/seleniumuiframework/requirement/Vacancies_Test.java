package com.orangehrm.seleniumuiframework.requirement;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import com.genericUtilities.BaseClass;

public class Vacancies_Test extends BaseClass {
	@Test
	public void RequirementVacancy() throws InterruptedException {
		driver.findElement(By.xpath("//a//span[.='Recruitment']")).click();
		driver.findElement(By.xpath("//a[.='Vacancies']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[.=' Add ']"))))
				.click();
		driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]")).sendKeys("CxxxxxD26");
		WebElement select = driver
				.findElement(By.xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow']"));
		select.click();
		WebElement w = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//div[@role='listbox']//span[contains(.,'Account Assistant')]")));
		w.click();
		driver.findElement(By.cssSelector("[placeholder='Type description here']")).sendKeys("please accept");
		driver.findElement(By.cssSelector("[placeholder='Type for hints...']")).click();
		Actions al = new Actions(driver);
		al.sendKeys("Shyam ").pause(3000).sendKeys(Keys.ARROW_DOWN, Keys.ENTER).perform();
		driver.findElement(By.xpath("(//label[.='Number of Positions']/../following::input)[1]")).sendKeys("6");
		driver.findElement(By.xpath("//button[.=' Save ']")).click();
	}

}
