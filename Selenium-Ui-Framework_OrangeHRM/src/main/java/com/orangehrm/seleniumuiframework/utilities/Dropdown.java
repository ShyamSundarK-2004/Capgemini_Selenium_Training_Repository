package com.orangehrm.seleniumuiframework.utilities;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Dropdown {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Open OrangeHRM
		driver.get("https://opensource-demo.orangehrmlive.com/");

		// Login
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Click PIM
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='PIM']"))).click();

		// Click dropdown
		WebElement dropdown = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("(//div[contains(@class,'oxd-select-text')])[1]")));
		dropdown.click();

		// Get all options (IMPORTANT FIX 🔥)
		List<WebElement> options = wait
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@role='option']//span")));

		// Select required option
		for (WebElement option : options) {
			if (option.getText().trim().equalsIgnoreCase("Freelance")) {
				option.click();
				break;
			}
		}

		// Optional wait to see result
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
		}

		driver.quit();
	}
}