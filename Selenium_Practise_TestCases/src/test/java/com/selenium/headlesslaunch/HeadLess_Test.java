package com.selenium.headlesslaunch;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class HeadLess_Test {
	WebDriver driver = null;

	@Test
	public void launch() {
		Reporter.log("Executing Beforetest", true);
		ChromeOptions option = new ChromeOptions();

		option.addArguments("--headless=new");

		driver = new ChromeDriver(option);

		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.findElement(By.id("user-name")).sendKeys("standard_user");

		driver.findElement(By.id("password")).sendKeys("secret_sauce");

		driver.findElement(By.id("login-button")).click();

		// verification

		WebElement swagLabsText = driver.findElement(By.xpath("//div[text()='Swag Labs']"));

		Assert.assertTrue(swagLabsText.getText().contains("Swag Labs"), "Not Found");
	}
}
