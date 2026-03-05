package com.xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Xpath_Attribute_program {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.amazon.in/");
		Thread.sleep(3000);

		driver.findElement(By.xpath("//a[@aria-label='Cushion covers, bedsheets & more']")).click();

//		driver.findElement(By.xpath("//input[@placeholder='Search Amazon.in']")).sendKeys("honor 200 5g", Keys.ENTER);
	}

}
