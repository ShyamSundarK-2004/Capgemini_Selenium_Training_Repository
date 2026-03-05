package com.practise.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoApp_WithOutPlaceHolder {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();

		driver.get("https://demoapps.qspiders.com/");
		Thread.sleep(3000);
		driver.findElement(By.partialLinkText("Explore more")).click();

		// without placeholder
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[text()='Without placeholder']")).click();

		// go to register page
		driver.findElement(By.linkText("Text Field")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("name")).sendKeys("Shyam Sundar K");
		driver.findElement(By.id("email")).sendKeys("official.shyamsundarK@gmail.com");
		driver.findElement(By.id("password")).sendKeys("Admin@123", Keys.ENTER);

		// login
		Thread.sleep(2000);
		driver.findElement(By.id("email")).sendKeys("official.shyamsundarK@gmail.com");
		driver.findElement(By.id("password")).sendKeys("Admin@123", Keys.ENTER);
	}

}
