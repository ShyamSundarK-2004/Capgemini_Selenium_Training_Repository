package com.selenium_javascriptExecutor;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Perform_Action_on_Disabled_Element {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.get("https://www.oracle.com/in/java/technologies/javase-jdk25-doc-downloads.html");
		driver.findElement(By.cssSelector("[class='license-link icn-download-locked']")).click();
		js.executeScript("arguments[0].click()",
				driver.findElement(By.cssSelector("[class='download-file icn-download']")));

	}

}
