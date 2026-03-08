package com.Synchronization;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ThreadClass {
	public static void main(String[] args) throws InterruptedException {
		/*
		 * just simply wait for the given time without any condition just waiting dumb
		 * even the element is loaded
		 */
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in");
		Thread.sleep(2000);
		driver.get("https://www.ebay.com/");
		Thread.sleep(2000, 10000);
		driver.get("https://www.shoppersstack.com/");
		Thread.sleep(Duration.ofSeconds(10));
		driver.quit();

	}

}
