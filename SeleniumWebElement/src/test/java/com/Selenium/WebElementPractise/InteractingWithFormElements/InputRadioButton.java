package com.Selenium.WebElementPractise.InteractingWithFormElements;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InputRadioButton {
	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.navigate().to("https://demo.automationtesting.in/Register.html");
		// selecting gender in radio button
		driver.findElement(By.cssSelector("[value='Male']")).click();

	}
}
