package com.selenium_javascriptExecutor;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ScrollIntoView_Method {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.get("https://www.youtube.com/@madangowri");
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//span[text()='Madan Gowri' and @role='text']")));
		WebElement ele = driver.findElement(By.xpath("//div[@id='title-text']//span[@id='title-superscript']"));
		js.executeScript("document.body.style.zoom='50%'");
		js.executeScript("arguments[0].scrollIntoView(true);", ele);
		Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView(false);", ele);

	}

}
