package com.selenium_javascriptExecutor;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Perform_Action_on_Hidden_Element {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.get("https://www.facebook.com/r.php");
		WebElement dropdown = driver.findElement(By.xpath("//div[starts-with(@id,'_R') and @role='combobox']"));
		Actions a = new Actions(driver);
		a.click(dropdown).pause(1000).sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN).click().perform();

		js.executeScript("arguments[0].value='u know'",
				driver.findElement(By.xpath("//input[starts-with(@id,'_r_') and @inputmode='text']")));

		System.out.println(driver.findElement(By.xpath("//input[starts-with(@id,'_r_') and @inputmode='text']"))
				.getAttribute("value"));

	}

}
