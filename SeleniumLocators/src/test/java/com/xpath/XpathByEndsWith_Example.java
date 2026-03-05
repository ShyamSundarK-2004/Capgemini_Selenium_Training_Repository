package com.xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathByEndsWith_Example {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demowebshop.tricentis.com/");
		Thread.sleep(2000);
//		driver.findElement(By.xpath("//input[@value='Search store' and @id = 'small-searchterms']"))
//				.sendKeys("Computers", Keys.ENTER);
//		Thread.sleep(2000);
		driver.findElement(By.xpath("//ul[@class='top-menu']//a[contains(.,'Digital downloads')]")).click();
	}

}
