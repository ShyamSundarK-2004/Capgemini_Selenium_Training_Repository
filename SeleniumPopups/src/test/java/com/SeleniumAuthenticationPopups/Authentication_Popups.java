package com.SeleniumAuthenticationPopups;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Authentication_Popups {
	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demoapps.qspiders.com/ui/auth?sublist=0");
		Thread.sleep(2000);
		driver.findElement(By.id("AuthLink")).click();
		Set<String> session = driver.getWindowHandles();
		Iterator<String> i = session.iterator();
		i.next();
		driver.switchTo().window(i.next());
		String url = driver.getCurrentUrl();
		System.out.println(url);
	}

}
