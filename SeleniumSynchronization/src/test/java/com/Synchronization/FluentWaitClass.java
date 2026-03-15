package com.Synchronization;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class FluentWaitClass {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		wait.pollingEvery(Duration.ofSeconds(2));
		wait.withTimeout(Duration.ofSeconds(20));
		driver.get("https://www.shoppersstack.com/products_page/57");
		driver.findElement(By.name("Check Delivery")).sendKeys("600099");
		wait.until(ExpectedConditions.elementToBeClickable(By.id("Check"))).click();

	}

}
