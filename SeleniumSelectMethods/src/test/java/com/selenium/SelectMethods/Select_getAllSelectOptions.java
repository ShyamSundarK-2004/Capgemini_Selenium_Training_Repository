package com.selenium.SelectMethods;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Select_getAllSelectOptions {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.navigate().to("https://demoapps.qspiders.com/ui/dropdown/multiSelect?sublist=1");
		// locate element
		WebElement ele = driver.findElement(By.xpath("//select[@id='select-multiple-native']"));
		// create a obj for select class
		Select sel = new Select(ele);
		// select a option
		sel.selectByIndex(1);
		sel.selectByIndex(3);
		sel.selectByIndex(2);
		sel.selectByValue("John Hardy Women's Legends Naga Gold & Silver Dragon Station Chain Bracelet");
		sel.selectByVisibleText("Solid Gold Petite Mi...");
		sel.selectByContainsVisibleText("Silicon Power");
		// use select method to select options
		java.util.List<WebElement> list = sel.getAllSelectedOptions();
		for (WebElement el : list)
			System.out.println(el.getText());
		
		System.out.println("Can select multiple options : "+sel.isMultiple());
		driver.quit();

	}

}
