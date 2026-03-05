package com.Selenium.WebElementPractise.InteractingWithFormElements;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InputDropDown {
	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.navigate().to("https://demo.automationtesting.in/Register.html");
		// selecting a value in the dropdown when visible
		driver.findElement(By.xpath("//option[@value='C']")).click();

		driver.navigate().refresh();
		driver.findElement(By.id("Skills")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//option[text()='C']")).click();
	}

}
