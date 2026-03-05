package com.webEleementInterrogationMethods;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Verification_getRect {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.navigate().to("https://demowebshop.tricentis.com/");
		Thread.sleep(2000);

		System.out.println(driver.findElement(By.id("small-searchterms")).getRect().height);
		System.out.println(driver.findElement(By.id("small-searchterms")).getRect().width);
		System.out.println(driver.findElement(By.id("small-searchterms")).getRect().getHeight());
		System.out.println(driver.findElement(By.id("small-searchterms")).getRect().getWidth());
		System.out.println(driver.findElement(By.id("small-searchterms")).getRect().x);
		System.out.println(driver.findElement(By.id("small-searchterms")).getRect().y);
		System.out.println(driver.findElement(By.id("small-searchterms")).getRect().getX());
		System.out.println(driver.findElement(By.id("small-searchterms")).getRect().getY());
		System.out.println(driver.findElement(By.id("small-searchterms")).getRect().getDimension());
		System.out.println(driver.findElement(By.id("small-searchterms")).getRect().getPoint());

		driver.quit();
	}

}
