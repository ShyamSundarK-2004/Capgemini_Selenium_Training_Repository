package com.SeleniumHiddenPopUps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HiddenPopups {
	
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.irctc.co.in/nget/train-search");
		String parent = driver.getWindowHandle();
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.xpath("//span[@class='ng-tns-c69-9 ui-calendar']//input")).click();
		driver.findElement(By.xpath("//a[@class='ui-datepicker-next ui-corner-all ng-tns-c69-9 ng-star-inserted']")).click();
		driver.findElement(By.xpath("//a[.='14']")).click();
	}

}
