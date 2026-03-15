package com.practise.testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsMethods {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demoapps.qspiders.com/ui/clickHold?sublist=0");
		WebElement img = driver.findElement(By.cssSelector("[id='circle']"));
		Actions a = new Actions(driver);
		a.clickAndHold(img).perform();

		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://demoapps.qspiders.com/ui/mouseHover?sublist=0");
		WebElement hover = driver.findElement(By.cssSelector("[src='/assets/message-hint-nbRmWGWf.png']"));
		a.moveToElement(hover).perform();

		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://demoapps.qspiders.com/ui/dragDrop?sublist=0");
		WebElement area = driver.findElement(By.xpath("//div[text()='Drag Me']"));
		System.out.println(area.getRect().x);
		System.out.println(area.getRect().y);
		a.clickAndHold(area).moveByOffset(600, 253).release().perform();

		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://doubleclicktest.com/click-counter.html");
		WebElement plus = driver.findElement(By.xpath("(//button[@type='button'])[1]"));
		a.moveToElement(plus).doubleClick().perform();
		Thread.sleep(2000);
		driver.quit();
	}

}
