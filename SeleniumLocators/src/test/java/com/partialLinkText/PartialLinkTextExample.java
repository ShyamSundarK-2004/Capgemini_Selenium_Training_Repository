package com.partialLinkText;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PartialLinkTextExample {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.get("https://demowebshop.tricentis.com/");

		driver.findElement(By.partialLinkText("Compu")).click();

		driver.get("https://www.flipkart.com/");
		Thread.sleep(3000);
		driver.findElement(By.className("b3wTlE")).click();
		driver.findElement(By.partialLinkText("Login")).click();

	}

}
