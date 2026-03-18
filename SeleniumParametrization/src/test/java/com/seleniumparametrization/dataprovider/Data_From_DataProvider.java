package com.seleniumparametrization.dataprovider;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Data_From_DataProvider {

	@DataProvider(name = "LoginData")
	public Object[][] getData() {
		return new Object[][] { { "Admin", "admin123" } };
	}

	@Test(dataProvider = "LoginData")
	public void readingFromDataProvider(String key, String value) {
		System.out.println("My Keys is : " + key + "---->" + value);

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://opensource-demo.orangehrmlive.com/");

		driver.findElement(By.cssSelector("[placeholder='Username']")).sendKeys(key);
		driver.findElement(By.cssSelector("[placeholder='Password']")).sendKeys(value);
		driver.findElement(By.cssSelector("[type='submit']")).click();
	}

}
