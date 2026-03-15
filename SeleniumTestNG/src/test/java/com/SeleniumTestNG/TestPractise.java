package com.SeleniumTestNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestPractise {
	public WebDriver driver = null;
	public WebDriverWait wait = null;
	public Actions a = null;

	@BeforeSuite
	public void launchingBrowser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		a = new Actions(driver);
	}

	@BeforeTest
	public void beforeTest() {

	}

	@BeforeClass
	public void login() {
		driver.get("https://opensource-demo.orangehrmlive.com/");
		WebElement usrname = driver.findElement(By.name("username"));
		usrname.sendKeys("Admin");
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("admin123");
		WebElement loginbtn = driver.findElement(By.cssSelector("[type='submit']"));
		loginbtn.click();
	}

	@BeforeMethod
	public void beforeMethod() {

	}

	@AfterMethod
	public void AfterMwthod() {

	}

	@AfterClass
	public void logout() {
//		driver.findElement(By.cssSelector("img[alt='profile picture']")).click();
//		driver.findElement(By.linkText("Logout")).click();
	}

	@AfterTest
	public void AfterTest() {

	}

	@AfterSuite
	public void AfterSuite() {

	}

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
		empID.sendKeys("1221");

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
		Assert.assertEquals(name.equals("Shyam Sundar K"), empid.equals("1221"));

		Reporter.log("Verification success", true);
		;

	}
}
