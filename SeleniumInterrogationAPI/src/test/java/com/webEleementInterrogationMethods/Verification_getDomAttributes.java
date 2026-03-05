package com.webEleementInterrogationMethods;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Verification_getDomAttributes {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.navigate().to("https://demowebshop.tricentis.com/");
		Thread.sleep(2000);

		// return the default value
		WebElement search = driver.findElement(By.id("small-searchterms"));
		search.sendKeys("tools");
		System.out.println(search.getDomAttribute("value"));

		System.out.println(driver.findElement(By.id("small-searchterms")).getDomAttribute("value"));
		driver.quit();
	}
}
