package com.orangehrm.seleniumuiframework.buzz;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import com.orangehrm.seleniumuiframework.generic_utilities.BaseClass;

public class Buzz_Test extends BaseClass {
	@Test
	public void RecentPost() {
		driver.findElement(By.cssSelector("[href='/web/index.php/buzz/viewBuzz']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea"))).sendKeys("E39");
		driver.findElement(By.xpath("//button[.=' Post ']")).click();
		List<WebElement> search = driver.findElements(By.className("orangehrm-buzz-post-body"));
		boolean found = false;
		for (WebElement check : search) {
			if (check.getText().contains("E39")) {
				found = true;
				break;
			} else {
				found = false;
			}
		}
		if (found)
			System.out.println("Recent post is verified");
		else
			System.out.println("failed");
	}
}
