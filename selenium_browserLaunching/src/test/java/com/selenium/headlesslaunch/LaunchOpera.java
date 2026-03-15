package com.selenium.headlesslaunch;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LaunchOpera {

	public static void main(String[] args) {

		ChromeOptions options = new ChromeOptions();
		options.setBinary("C:\\Users\\Shyam Sundar\\Downloads\\OperaSetup.exe");

		WebDriver driver = new ChromeDriver(options);

		driver.get("https://www.google.com");
	}
}