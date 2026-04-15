package com.Sample.apollo247;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Demo {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.get("https://www.apollo247.com/");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement dom = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("ct-web-popup-imageonly")));

		SearchContext shadowDom = dom.getShadowRoot();

		shadowDom.findElement(By.id("close")).click();

		driver.findElement(By.linkText("Lab Tests")).click();

	}
}
