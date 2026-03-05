package com.RelativeLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class DemoAutomationBy_RelativeLocators {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.get("https://demoapps.qspiders.com/");
		Thread.sleep(3000);
		driver.findElement(By.partialLinkText("Explore more")).click();

		Thread.sleep(2000);

		WebElement name = driver.findElement(By.xpath("//input[@placeholder='Enter your name']"));
		Thread.sleep(2000);
		name.sendKeys("shyam sundar K");
		Thread.sleep(2000);
		WebElement email = driver.findElement(RelativeLocator.with(By.tagName("input")).below(name));
		Thread.sleep(2000);
		email.sendKeys("shyamson36@gmail.com");
		Thread.sleep(2000);
		WebElement pwd = driver.findElement(RelativeLocator.with(By.tagName("input")).below(email));
		pwd.sendKeys("admin123");
		Thread.sleep(2000);
		driver.findElement(RelativeLocator.with(By.tagName("button")).below(pwd)).click();

	}

}
