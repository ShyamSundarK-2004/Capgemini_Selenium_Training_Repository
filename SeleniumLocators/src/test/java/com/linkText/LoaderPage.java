package com.linkText;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoaderPage {

	public static void main(String[] args) throws InterruptedException {

//        String browser = "chrome";   // change to firefox if needed

		WebDriver driver = new ChromeDriver();

//        if (browser.equalsIgnoreCase("chrome")) {
//            driver = new ChromeDriver();
//        } 
//        else if (browser.equalsIgnoreCase("firefox")) {
//            driver = new FirefoxDriver();
//        } 
//        else {
//            throw new IllegalArgumentException("Invalid browser name");
//        }

		driver.manage().window().maximize();
		driver.get("https://www.panimalar.ac.in/");
//		Thread.sleep(3000);
//		System.out.println("Title: " + driver.getTitle());
//		System.out.println("URL: " + driver.getCurrentUrl());

		driver.findElement(By.linkText("Admission Information")).click();
		
//		driver.close(); // Properly close browser
	}
}