package com.navigationAPI;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Navigate_Back_Forward_Methods {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.navigate().to("https://www.google.com");
		System.out.println(driver.getCurrentUrl());
		driver.navigate().to("https://www.youtube.com");
		System.out.println(driver.getCurrentUrl());
		driver.navigate().to("https://www.netflix.com");
		System.out.println(driver.getCurrentUrl());
		// navigate back to youtube

		driver.navigate().back();
		System.out.println(driver.getCurrentUrl());

		// navigate forward to netflix
		driver.navigate().forward();
		System.out.println(driver.getCurrentUrl());

		// navigate back to youtube
		driver.navigate().back();
		System.out.println(driver.getCurrentUrl());

		// get
		System.out.println(driver.getTitle());

	}

}
