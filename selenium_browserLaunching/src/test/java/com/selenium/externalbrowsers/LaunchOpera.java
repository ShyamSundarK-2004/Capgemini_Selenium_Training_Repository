package com.selenium.externalbrowsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LaunchOpera {
	public static void main(String[] args) throws InterruptedException {

		// ✅ Your ChromeDriver path
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Shyam Sundar\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

		// Create options
		ChromeOptions options = new ChromeOptions();

		// ✅ Your Opera browser path
		options.setBinary("C:\\Users\\Shyam Sundar\\AppData\\Local\\Programs\\Opera\\opera.exe");

		// Launch Opera using ChromeDriver
		WebDriver driver = new ChromeDriver(options);

		driver.manage().window().maximize();
		driver.get("https://www.amazon.in");
		Thread.sleep(2000);
//		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Apple Iphone 17 pro max");
	}
}