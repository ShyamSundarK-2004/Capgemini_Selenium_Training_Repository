package com.selenium_javascriptExecutor;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExecuteScriptMethod {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.get("https://opensource-demo.orangehrmlive.com/");
		WebElement usr_name = driver.findElement(By.name("username"));
		js.executeScript("arguments[0].value='Admin';arguments[0].dispatchEvent(new Event('input'));", usr_name);
		WebElement pwd = driver.findElement(By.name("password"));
		js.executeScript("arguments[0].value='admin123';arguments[0].dispatchEvent(new Event('input'));", pwd);
		WebElement loginbtn = driver.findElement(By.cssSelector("[type='submit']"));
		js.executeScript("arguments[0].click();", loginbtn);
		
//		js.executeScript(
//				"arguments[0].value='Admin';arguments[0].dispatchEvent(new Event('input'));arguments[1].value='admin123';arguments[1].dispatchEvent(new Event('input'));arguments[2].click();",
//				usr_name, pwd, loginbtn);
	}

}
