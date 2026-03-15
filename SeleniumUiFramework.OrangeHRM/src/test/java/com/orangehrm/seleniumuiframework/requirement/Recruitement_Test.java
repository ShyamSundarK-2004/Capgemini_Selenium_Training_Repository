package com.orangehrm.seleniumuiframework.requirement;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.genericUtilities.BaseClass;

public class Recruitement_Test extends BaseClass {
	@Test
	public void requirement_test() {

		driver.findElement(By.xpath("//span[text()='Recruitment']")).click();
		// first name, second name , and last name
		driver.findElement(By.xpath("//button[.=' Add ']")).click();
		WebElement firstname = driver.findElement(By.name("firstName"));
		firstname.sendKeys("Shyam");
		WebElement middlename = driver.findElement(RelativeLocator.with(By.name("middleName")).toRightOf(firstname));
		middlename.sendKeys("Sundar");
		driver.findElement(RelativeLocator.with(By.name("lastName")).toRightOf(middlename)).sendKeys("K");
		// vacancy drop down
		WebElement vacancy = driver.findElement(By.xpath("//div[text()='-- Select --']"));
		vacancy.click();
		vacancy.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
		// email ID
		WebElement emailID = driver
				.findElement(By.xpath("//label[text()='Email']/parent::div/following-sibling::div//input"));
		emailID.sendKeys("shyamson366@gmail.com");

		// contact number
		driver.findElement(RelativeLocator.with(By.cssSelector("[placeholder='Type here']")).toRightOf(emailID))
				.sendKeys("7904399332");
		// selecting file
		driver.findElement(By.cssSelector("[type='file']")).sendKeys(
				"C:\\Users\\Shyam Sundar\\OneDrive\\Desktop\\Stickers\\Important files\\Capgemini_Docs\\Shyam Sundar K Resume.pdf");
		// selecting date
		WebElement date = driver.findElement(By.cssSelector("[placeholder='yyyy-dd-mm']"));
		date.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
		date.sendKeys("2026-12-03");

		// clicking save btn
		driver.findElement(By.cssSelector("[type='submit']")).click();

		// clicking on candidates
		driver.findElement(By.linkText("Candidates")).click();
		// selecting jobtitle dropdown
		WebElement jobtitle = driver.findElement(By.xpath("(//div[@class='oxd-select-text-input'])[1]"));
		a.click(jobtitle).pause(2000).sendKeys(Keys.ARROW_DOWN).click().perform();
		// selecting job vacancy
		WebElement jobvacancy = driver.findElement(By.xpath("(//div[@class='oxd-select-text-input'])[2]"));
		jobvacancy.click();
		jobvacancy.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
		// selecting Hiring Manager
		WebElement hiringmanager = driver.findElement(By.xpath("(//div[@class='oxd-select-text-input'])[3]"));
		hiringmanager.click();
		hiringmanager.sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
//		driver.findElement(By.xpath("//span[text()='John Doe']")).click();
		// selecting status
		WebElement status = driver.findElement(By.xpath("(//div[@class='oxd-select-text-input'])[4]"));
		status.click();
		status.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
		// enter employee name
		WebElement empname = driver.findElement(By.cssSelector("[placeholder='Type for hints...']"));
		empname.sendKeys("Shyam");
		a.pause(3000).sendKeys(empname, Keys.ARROW_DOWN, Keys.ENTER).perform();
		// enter from date
		WebElement fromdate = driver.findElement(By.cssSelector("[placeholder='From']"));
		fromdate.sendKeys("2026-08-03");
		// enter to date
		WebElement todate = driver.findElement(By.cssSelector("[placeholder='To']"));
		todate.sendKeys("2026-15-03");
		// click search btn
		driver.findElement(By.cssSelector("[type='submit']")).click();

		// verification
		Assert.assertTrue(driver.findElement(By.xpath("//div[@role='table']")).isDisplayed(), "No Data Found");
		String emp = driver.findElement(By.xpath("//div[@role='table']")).getText();
		Assert.assertTrue(emp.contains("Shyam"));
		Reporter.log("employee data verified", true);
	}

}
