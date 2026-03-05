package com.practise.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioGarden {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.get("https://radio.garden/");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='_welcomeIcon_1m2ix_48 _playButton_1m2ix_83']")).click();

		Thread.sleep(2000);

		driver.findElement(By.xpath("//a[@data-jest-id='tab-search tab-Search tab-inactive tab']")).click();

		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@class='_searchInput_1d5j9_46']")).sendKeys("mirchi FM");

		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@aria-label='Mirchi FM in Durban, South Africa']")).click();
	}
}
