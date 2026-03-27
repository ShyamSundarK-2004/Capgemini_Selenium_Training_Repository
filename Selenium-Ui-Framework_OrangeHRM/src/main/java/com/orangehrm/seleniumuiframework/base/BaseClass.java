package com.orangehrm.seleniumuiframework.base;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
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
import org.testng.annotations.Listeners;

import com.orangehrm.seleniumuiframework.utilities.ExcelUtility;
import com.orangehrm.seleniumuiframework.utilities.FileUtility;
import com.orangehrm.seleniumuiframework.utilities.WebDriverUtility;
import com.orangehrm.seleniumuiframwork.pages.AddCandidatesPage;
import com.orangehrm.seleniumuiframwork.pages.AddEmployeePage;
import com.orangehrm.seleniumuiframwork.pages.AddVacanciesPage;
import com.orangehrm.seleniumuiframwork.pages.CandidatesPage;
import com.orangehrm.seleniumuiframwork.pages.DashboardPage;
import com.orangehrm.seleniumuiframwork.pages.LoginPage;
import com.orangehrm.seleniumuiframwork.pages.PIMPage;
import com.orangehrm.seleniumuiframwork.pages.RecruitmentPage;
import com.orangehrm.seleniumuiframwork.pages.TerminationPage;
import com.orangehrm.seleniumuiframwork.pages.VacanciesPage;

@Listeners(com.orangehrm.seleniumuiframework.utilities.ListenerUtility.class)
public class BaseClass {

	public WebDriver driver;
	public WebDriverUtility webutility;
	public FileUtility fileUtility;

	public JavascriptExecutor js;

	// Page Objects
	public LoginPage loginPage;
	public DashboardPage dashboardPage;
	public PIMPage pimPage;
	public AddEmployeePage addEmpPage;
	public TerminationPage terminationPage;
	public RecruitmentPage recruitmentPage;
	public AddVacanciesPage addVacanciesPage;
	public VacanciesPage vacancies;
	public CandidatesPage candidatesPage;
	public AddCandidatesPage addCandidates;

	public ExcelUtility excelUtility = new ExcelUtility();

	// loading data from excel

	@DataProvider(name = "VacancyExcelData")
	public Object[][] getVacancyData() throws Exception {
		Reporter.log("----Loading Vacancy data----", true);
		return excelUtility.getExcelDataAsArray("addVacancy");
	}

	@DataProvider(name = "CandidateExcelData")
	public Object[][] getCandidateData() throws Exception {
		Reporter.log("----Loading Candidate data----", true);
		return excelUtility.getExcelDataAsArray("addCandidate");
	}

	@DataProvider(name = "EmployeeExcelData")
	public Object[][] getEmployeeData() throws Exception {
		Reporter.log("----Loading Employee data----", true);
		return excelUtility.getExcelDataAsArray("addEmployee");
	}

	@DataProvider(name = "TerminationExcelData")
	public Object[][] getTerminationData() throws Exception {
		Reporter.log("----Loading Termination data----", true);
		return excelUtility.getExcelDataAsArray("addTermination");
	}

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

		// js executor
		js = (JavascriptExecutor) driver;

		// Page Objects
		loginPage = new LoginPage(driver);
		dashboardPage = new DashboardPage(driver);
		pimPage = new PIMPage(driver);
		addEmpPage = new AddEmployeePage(driver);
		terminationPage = new TerminationPage(driver);
		recruitmentPage = new RecruitmentPage(driver);
		addVacanciesPage = new AddVacanciesPage(driver);
		vacancies = new VacanciesPage(driver);
		candidatesPage = new CandidatesPage(driver);
		addCandidates = new AddCandidatesPage(driver);

	}

//	 Login
	@BeforeClass
	public void login() throws IOException {
		Reporter.log("----Log in----", true);
		webutility.enterURL(fileUtility.getPropertyKeyValue("url"));
		loginPage.login(fileUtility.getPropertyKeyValue("username"), fileUtility.getPropertyKeyValue("password"));
	}

	// logout
	@AfterClass
	public void logout() {
		Reporter.log("----Logout----", true);
		dashboardPage.logout();
	}

	// quit browser
	@AfterTest
	public void quitBrowser() {
		webutility.quitBroswerWindow();
	}
}