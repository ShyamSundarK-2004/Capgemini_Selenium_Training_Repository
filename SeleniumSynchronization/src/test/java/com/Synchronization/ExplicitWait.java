package com.Synchronization;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// for automation testing demo site
		driver.get("https://demo.automationtesting.in/Loader.html");
		driver.findElement(By.id("loader")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[class='close']"))).click();

		// for shopperstack site
		driver.switchTo().newWindow(WindowType.TAB);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.shoppersstack.com/products_page/57");
		driver.findElement(By.name("Check Delivery")).sendKeys("600099");
//		d.findElement(By.id("Check")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.id("Check"))).click();

		// for flipkart site
		driver.switchTo().newWindow(WindowType.TAB);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.flipkart.com");
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("b3wTlE")))).click();

	}

}
