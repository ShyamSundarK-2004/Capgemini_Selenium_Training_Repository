package com.selenium_javascriptExecutor;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ScrollBy_Method {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.get("https://www.youtube.com/");
		driver.findElement(By.name("search_query")).sendKeys("gangam style", Keys.ENTER);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//div[@id='dismissible' and @class='style-scope ytd-video-renderer'])[1]")));
		js.executeScript("window.scrollBy(0,5000);");
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,2500);");

	}

}
