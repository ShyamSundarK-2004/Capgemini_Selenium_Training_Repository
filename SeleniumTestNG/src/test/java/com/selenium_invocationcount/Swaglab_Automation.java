package com.selenium_invocationcount;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Swaglab_Automation {
	WebDriver driver = null;
	WebDriverWait wait = null;

	@Test(priority = 1)
	public void launchingbrowser() {

		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--headless=new");
		options.addArguments("--incognito");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}

	@Test(dependsOnMethods = "launchingbrowser", priority = 2, invocationCount = 5)
	public void login() {
		// Login with valid credentials
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		// verification
		WebElement swagLabsText = driver.findElement(By.xpath("//div[text()='Swag Labs']"));
		Assert.assertTrue(swagLabsText.getText().contains("Swag Labs"), "Login Not Displayed");
	}

	@Test(dependsOnMethods = "login", priority = 3)
	public void logout() {

		// logout
		driver.findElement(By.id("react-burger-menu-btn")).click();
		driver.findElement(By.id("logout_sidebar_link")).click();
		driver.quit();
	}

}
