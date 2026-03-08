package com.practise.testcases;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_HRM_EMP_002 {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://icehrmpro.gamonoid.com/login.php");
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("admin");
		driver.findElement(By.xpath("//button[text()='Log in ']")).click();
		if (driver.getCurrentUrl().contains("dashboard")) {
			System.out.println("Dashboard page is verified");
		}

		driver.findElement(By.xpath("//li[@ref=\"admin_Admin\"]//span")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//li[@ref='admin_Employees']")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//ul[@id=\"admin_Employees\"]//*/a[contains(.,'Employees')]")).click();

		driver.findElement(By.xpath("//button[@type='button']//span[.='Filter Employees']")).click();

		WebElement dropdown = driver.findElement(By.xpath("//input[@id='rc_select_5']"));
		dropdown.click();
		dropdown.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
		driver.findElement(By.xpath("//button[@type='button']//span[text()='Save']")).click();
		
		List<WebElement> ele = driver
				.findElements(By.xpath("//div[@class='ant-list-item-meta-description' and contains(.,'Head Office')]"));

		System.out.println("Checking if all the employees are from Head Office Dept : ");

		boolean allDepartment = true;
		for (WebElement e : ele) {
			if (!e.getText().contains("Head Office")) {
				allDepartment = false;
				break;
			}
		}
		if (allDepartment) {
			System.out.println("All employees belong to Head Office Department");
		} else {
			System.out.println("Validation Failed: Some employees are not from Head Office");
		}
		Thread.sleep(3000);

		driver.findElement(By.xpath("//button[@type=\"button\"]//span[.='Filter Employees']")).click();

		WebElement dropdown1 = driver.findElement(By.xpath("//input[@id='rc_select_8']"));
		dropdown1.click();
		dropdown1.sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
		driver.findElement(By.xpath("//button[@type='button']//span[text()='Save']")).click();

		List<WebElement> ele1 = driver.findElements(
				By.xpath("//div[@class='ant-list-item-meta-description' and contains(.,'Product Manager')]"));
		System.out.println("Checking if all the employees are from Product Manager Job Title : ");

		boolean allJobTitle = true;
		for (WebElement e : ele1) {
			if (!e.getText().contains("Product Manager")) {
				allJobTitle = false;
				break;
			}
		}
		if (allJobTitle) {
			System.out.println("All employees belong to Product Manager Role");
		} else {
			System.out.println("Validation Failed: Some employees are not from Product Manager Role");
		}

		driver.findElement(
				By.xpath("//i[@class='glyphicon glyphicon-user']/following-sibling::span[contains(.,'IceHrm')]"))
				.click();
		driver.findElement(By.linkText("Sign out")).click();

		Thread.sleep(5000);
		driver.quit();

	}
}
