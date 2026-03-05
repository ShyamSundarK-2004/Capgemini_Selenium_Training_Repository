package com.xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XPathByContains_Example {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		// 1. Amazon Search Button
		driver.get("https://www.amazon.in/");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[contains(@id,'nav-search-submit')]")).click();
		Thread.sleep(2000);

		// 2.youtube searching
		driver.get("https://www.youtube.com/");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[contains(@name,'search_query')]")).sendKeys("mr bean");
		Thread.sleep(2000);

		// 3.youtube clicking shorts
		driver.get("https://www.youtube.com/");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(@aria-label,'Shorts')]")).click();
		Thread.sleep(3000);

		// 4.mail id login
		driver.get("https://mail.google.com/");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[contains(@aria-label,'Email or phone')]"))
				.sendKeys("shyamson366@gmail.com");
		Thread.sleep(3000);

		// 5.flipkart closing popup
		driver.get("https://www.flipkart.com/");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[contains(text(),'✕')]")).click();
		Thread.sleep(2000);

		driver.quit();
	}
}