package com.xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathByAxes_Example {
	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.google.com/");
		Thread.sleep(3000);

		driver.findElement(By.xpath(
				"//textarea[@title='Search']/parent::div/parent::div/parent::div/following-sibling::div[2]/child::center/child::input[2]"))
				.click();
	}

}
