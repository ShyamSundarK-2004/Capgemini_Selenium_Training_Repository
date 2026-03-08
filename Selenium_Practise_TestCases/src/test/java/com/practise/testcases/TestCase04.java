package com.practise.testcases;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase04 {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		String parent = driver.getWindowHandle();
		driver.findElement(By.partialLinkText("OrangeHRM, Inc")).click();
		Set<String> window = driver.getWindowHandles();
		window.remove(parent);
		for (String childId : window) {
			driver.switchTo().window(childId);
		}
		if (driver.getCurrentUrl().contains("orangehrm")) {
			System.out.println("Pass");
		} else {
			System.out.println("Fail");
		}
		if (!driver.getTitle().isEmpty()) {
			System.out.println("title present");
		} else {
			System.out.println("title not present");
		}
		driver.close();
		driver.switchTo().window(parent);
		if (driver.getCurrentUrl().contains("orangehrmlive.com/web/index.php/auth/login")) {
			System.out.println("login page opened");
		} else {
			System.out.println("Fail");
		}
		driver.quit();

	}
}