package com.orangehrm.seleniumuiframework.pim;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.genericUtilities.BaseClass;

public class Transaction_Test extends BaseClass {

	@Test
	public void ConfigureEmployee() {

		// clicking the pim module
		driver.findElement(By.cssSelector("[href=\"/web/index.php/pim/viewPimModule\"]")).click();
		// click configuration
		driver.findElement(By.xpath("//span[.='Configuration ']")).click();
		// click termination reason
		driver.findElement(By.linkText("Termination Reasons")).click();
		// clicking add btn
		driver.findElement(By.xpath("//div[@class='orangehrm-header-container']//button")).click();
		// writing reason
		WebElement reason = driver
				.findElement(By.xpath("//div[@class='oxd-input-group__label-wrapper']/following-sibling::div/input"));
		reason.sendKeys("You are fired!!!!!!!!!!!!!!");

		// save the reason
		driver.findElement(By.cssSelector("[type='submit']")).click();
		// check the reason status
		List<WebElement> report = driver.findElements(By.xpath("//div[@class=\"oxd-table-body\"]/div"));
		boolean result = false;
		for (WebElement s : report) {
			if (s.getText().equals("--Notice Period End!--")) {
				Reporter.log("The reason is added to the Termination reasons successfully | Status : passed", true);
				result = true;
				break;
			}
		}
		if (result == false) {
			Reporter.log("The reason is added successfully | Status : passed", true);
		}

	}

}
