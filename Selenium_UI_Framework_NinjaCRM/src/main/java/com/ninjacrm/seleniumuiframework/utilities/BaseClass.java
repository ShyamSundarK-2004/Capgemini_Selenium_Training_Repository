package com.ninjacrm.seleniumuiframework.utilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.ninjacrm.seleniumuiframework.pages.CampaignPage;
import com.ninjacrm.seleniumuiframework.pages.DashBoardPage;
import com.ninjacrm.seleniumuiframework.pages.LoginPage;
import com.ninjacrm.seleniumuiframework.pages.createCampaignsPage;

public class BaseClass {

	public WebDriver driver;
	public WebDriverUtility webutility;
	public FileUtility fileUtility;
	public ActionsUtility actionUtility;
	public ExcelUtility excelUtility;

	// pages
	public LoginPage loginpage;
	
	public DashBoardPage dashboardpage;
	public CampaignPage campaignPage;
	public createCampaignsPage createCampaignPage;

	// Launch Browser
	@BeforeTest
	public void launchingBrowser() throws IOException {
		Reporter.log("----Launching Browser----", true);
		fileUtility = new FileUtility();

		String browser = fileUtility.getPropertyKeyValue("browser");

		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else {
			throw new RuntimeException("Invalid browser name in properties file");
		}

		// Utilities
		webutility = new WebDriverUtility(driver);
		// maximize browser
		webutility.configMaximizeBrowser();
		// implicit wait
		webutility.waitForElements(30);
		// actions utility
		actionUtility = new ActionsUtility(driver);
		// excel utility
		excelUtility = new ExcelUtility();

		// pages
		loginpage = new LoginPage(driver);
		dashboardpage = new DashBoardPage(driver);
		campaignPage = new CampaignPage(driver);
		createCampaignPage = new createCampaignsPage(driver);

	}

	@DataProvider(name = "createCampaign")
	public Object[][] createCampaign() throws Exception {
		return excelUtility.getExcelDataAsArray("CreateCampaign");
	}

	// Login
	@BeforeClass
	public void login() throws IOException {
		Reporter.log("----Log in----", true);
		webutility.enterURL(fileUtility.getPropertyKeyValue("url"));
		loginpage.login(fileUtility.getPropertyKeyValue("username"), fileUtility.getPropertyKeyValue("password"));
	}

	// logout
	@AfterClass
	public void logout() {
		Reporter.log("----Logout----", true);

		actionUtility.hoverOnElement(dashboardpage.getUserIcon());
		webutility.waitUntilElementIsVisibility(3000, dashboardpage.getLogoutBtn());
		dashboardpage.clickLogoutBtn();

	}

	// quit browser
	@AfterTest
	public void quitBrowser() {
		webutility.quitBroswerWindow();
	}
}