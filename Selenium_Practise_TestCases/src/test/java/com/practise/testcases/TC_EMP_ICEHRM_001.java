package com.practise.testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_EMP_ICEHRM_001 {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://icehrmpro.gamonoid.com/login.php");
		String parent = driver.getWindowHandle();
		driver.findElement(By.id("username")).sendKeys("aadmin");
		driver.findElement(By.id("password")).sendKeys("adamin");
		driver.findElement(By.xpath("//button[text()='Log in ']")).click();

		System.out.println(
				"Invalid Username and password : " + driver.findElement(By.xpath("//div[@role='alert']")).getText());

		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("admin");
		driver.findElement(By.xpath("//button[text()='Log in ']")).click();
		if (driver.getCurrentUrl().contains("dashboard")) {
			System.out.println("Login success -> Dashboard page is verified");
		}
		driver.findElement(By.xpath("//li[@ref=\"admin_Admin\"]//span")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[@ref='admin_Employees']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//ul[@id=\"admin_Employees\"]//*/a[contains(.,'Employees')])[1]")).click();
		driver.findElement(By.linkText("Skills")).click();
		driver.findElement(By.xpath("//span[.=' Add New']")).click();
		WebElement divcontainer = driver.findElement(By.className("ant-modal-content"));
		System.out.println("Div Container is displayed : " + divcontainer.isDisplayed());
		driver.findElement(By.xpath("//span[@aria-label=\"close\"]")).click();
		driver.findElement(
				By.xpath("//i[@class='glyphicon glyphicon-user']/following-sibling::span[contains(.,'IceHrm')]"))
				.click();
		driver.findElement(By.linkText("Sign out")).click();
		if (driver.getCurrentUrl().contains("login")) {
			System.out.println("Login page verified");
		}
		Thread.sleep(5000);
		driver.quit();
	}

}
