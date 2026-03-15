package com.genericUtilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseClass {
	public WebDriver driver = null;
	public WebDriverWait wait = null;
	public Actions a = null;


	@BeforeSuite
	public void beforeSuite() {

	}

	@Parameters("browser")
	@BeforeTest
	public void launchingBrowser(@Optional("chrome") String browser) {
		if (browser.equals("chrome")) {
			ChromeOptions option = new ChromeOptions();
			option.addArguments("--headless=new");
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equals("edge")) {
			driver = new EdgeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		a = new Actions(driver);
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
		driver.findElement(By.cssSelector("img[alt='profile picture']")).click();
		driver.findElement(By.linkText("Logout")).click();
	}

	@AfterTest
	public void AfterTest() {
		driver.quit();
	}

	@AfterSuite
	public void AfterSuite() {

	}
}
