package com.practise.testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class OrangeHRM_ActionsTest {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		// Login
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		// Home page validation
		WebElement homepage = driver.findElement(By.xpath("//h6"));

		if (homepage.isDisplayed()) {
			System.out.println("The home page is displayed: Status- PASS");
		} else {
			System.out.println("The home page is not displayed: Status- Failed");
		}

		// Click Admin
		driver.findElement(By.xpath("//span[.='Admin']")).click();

		// Dropdown
		WebElement drop = driver.findElement(By.xpath("//label[.='User Role']/../..//i"));

		// Actions class
		Actions act = new Actions(driver);

		act.click(drop).pause(1000).sendKeys(Keys.ARROW_DOWN, Keys.ENTER).perform();

		Thread.sleep(2000);

		// Scroll
		act.scrollByAmount(0, 1500).perform();

	}
}