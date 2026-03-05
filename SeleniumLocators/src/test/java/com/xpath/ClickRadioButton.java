package com.xpath;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClickRadioButton {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.get("https://demowebshop.tricentis.com/");

		List<WebElement> webList = driver.findElements(By.xpath("//input[@type='radio']"));

		for (WebElement element : webList) {
			element.click();
			Thread.sleep(3000);
		}
	}

}
	