package com.Synchronization;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ImplicitWait {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		/*
		 * implicit_wait waits till the element is loaded if loaded it just continue the
		 * execution if not it wait till for specific time till the element loaded
		 */
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demoapps.qspiders.com/ui/progress?sublist=0");

		driver.findElement(By.xpath("//button[.='Start']")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		driver.findElement(By.xpath("//button[.='Pause']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[.='Reset']")).click();

	}

}
