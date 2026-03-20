package com.orangehrm.seleniumgrid.tests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class Launching_Firefox_SeleniumGrid {

	@Test
	public void launchingBrowser() throws MalformedURLException, InterruptedException {
		FirefoxOptions options = new FirefoxOptions();

		WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444"), options);
		// navigatin to an application
		driver.get("https://www.amazon.in");
		Thread.sleep(2000);
		driver.quit();
	}

}
