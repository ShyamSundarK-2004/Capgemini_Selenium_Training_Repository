package com.takescreenshot;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.orangehrm.seleniumuiframework.generic_utilities.TakeScreenShotUtility;
import com.orangehrm.seleniumuiframwork.object_repository.LoginPage;

public class TakeScreenShot_Sample {

	@Test
	public void screenShot() throws IOException, InterruptedException {

		WebDriver driver = new ChromeDriver();

		TakeScreenShotUtility tss = new TakeScreenShotUtility();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		LoginPage lp = new LoginPage(driver);

		FileInputStream fis = new FileInputStream("./src/test/resources/orangehrms.commondata/commondata.properties");
		Properties prop = new Properties();
		prop.load(fis);

		driver.get(prop.getProperty("url"));
		lp.login(prop.getProperty("username"), prop.getProperty("password"));

		Thread.sleep(3000);

		tss.takeScreenShot(driver, "Dashboard");

		tss.takeScreenShot(driver.findElement(By.linkText("Admin")), "admin link");
		driver.quit();

	}

}
