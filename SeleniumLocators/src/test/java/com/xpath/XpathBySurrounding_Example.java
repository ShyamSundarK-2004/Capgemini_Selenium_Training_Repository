package com.xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathBySurrounding_Example {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.get("https://demowebshop.tricentis.com/");

		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@type='radio']/../..//label[.='Poor']")).click();

		driver.findElement(By.xpath("//a[@title='Show details for 14.1-inch Laptop']/../..//input[@type='button']"))
				.click();

	}

}
