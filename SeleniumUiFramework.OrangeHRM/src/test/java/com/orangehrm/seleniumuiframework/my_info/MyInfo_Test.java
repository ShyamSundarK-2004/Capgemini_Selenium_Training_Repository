package com.orangehrm.seleniumuiframework.my_info;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.genericUtilities.BaseClass;

public class MyInfo_Test extends BaseClass {

	@Test
	public void MyInfoTest() throws InterruptedException {
		// clicking myinfo module
		driver.findElement(By.cssSelector("[href='/web/index.php/pim/viewMyDetails']")).click();
		// changing firstname
		WebElement firstname = driver.findElement(By.name("firstName"));
		Thread.sleep(3000);
		firstname.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
		firstname.sendKeys("Shyam");

		// changing middle name
		WebElement middlename = driver.findElement(By.name("middleName"));
		Thread.sleep(3000);
		middlename.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
		middlename.sendKeys(".");

		// changing lastname
		WebElement lastname = driver.findElement(By.name("lastName"));
		Thread.sleep(3000);
		lastname.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
		lastname.sendKeys("Sundar K");

		// changing the empId
		WebElement empID = driver
				.findElement(By.xpath("//label[.='Employee Id']/parent::div/following-sibling::div/input"));
		Thread.sleep(3000);
		empID.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
		empID.sendKeys("1211");

		// clicking save btn
		driver.findElement(By.cssSelector("[type='submit']")).click();

		// logout
		driver.findElement(By.xpath("//span[@class='oxd-userdropdown-tab']//img[@alt='profile picture']")).click();
		driver.findElement(By.linkText("Logout")).click();

		// login
		WebElement usrname = driver.findElement(By.name("username"));
		usrname.sendKeys("Admin");
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("admin123");
		WebElement loginbtn = driver.findElement(By.cssSelector("[type='submit']"));
		loginbtn.click();

		// checking the usr presence
		driver.findElement(By.cssSelector("[href='/web/index.php/pim/viewMyDetails']")).click();
		String name = wait
				.until(ExpectedConditions
						.visibilityOf(driver.findElement(By.xpath("//h6[@class='oxd-text oxd-text--h6 --strong']"))))
				.getText();
		String empid = wait
				.until(ExpectedConditions.visibilityOf(driver
						.findElement(By.xpath("//label[.='Employee Id']/parent::div/following-sibling::div/input"))))
				.getText();
		Assert.assertEquals(name.equals("Shyam Sundar K"), empid.equals("1211"));

		Reporter.log("Verification success", true);
		;

	}

}
