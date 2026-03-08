package com.practise.testcases;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ImplicitWait_testCase06 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demowebshop.tricentis.com/");

		driver.findElement(By.linkText("Facebook")).click();
		driver.findElement(By.linkText("Twitter")).click();
		driver.findElement(By.linkText("YouTube")).click();

		Set<String> session = driver.getWindowHandles();
		Iterator<String> i = session.iterator();
		while (i.hasNext()) {
			driver.switchTo().window(i.next());
			if (driver.getCurrentUrl().contains("youtube")) {
				driver.findElement(By.xpath("(//a[@title='YouTube Home'])[1]")).click();
				driver.findElement(By.cssSelector("[name='search_query']")).sendKeys("mr bean", Keys.ENTER);
				driver.findElement(By.xpath("(//a[@id='video-title'])[1]")).click();
				break;
			}
		}

	}

}
