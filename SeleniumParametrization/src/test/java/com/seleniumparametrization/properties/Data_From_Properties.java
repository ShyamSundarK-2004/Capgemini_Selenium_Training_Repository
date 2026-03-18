package com.seleniumparametrization.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class Data_From_Properties {
	WebDriver driver;
	@FindAll({ @FindBy(id = "user-name"), @FindBy(name = "username") })
	public WebElement user;
	@FindAll({ @FindBy(id = "password"), @FindBy(name = "password") })
	public WebElement pass;
	@FindAll({ @FindBy(id = "login-button"), @FindBy(css = "[type='submit']") })
	public WebElement login;

	@Test
	public void practice() throws IOException {
		driver = new ChromeDriver();
		FileInputStream fls = new FileInputStream("./src/test/resources/orangehrms.commondata/commondata.properties");
		Properties prop = new Properties();
		prop.load(fls);
		PageFactory.initElements(driver, this);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(prop.getProperty("url"));
		user.sendKeys(prop.getProperty("username"));
		pass.sendKeys(prop.getProperty("password"));
		login.click();

	}

}