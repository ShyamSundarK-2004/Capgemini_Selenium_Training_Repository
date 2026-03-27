package com.orangehrm.seleniumuiframework.generic_utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.orangehrm.seleniumuiframwork.object_repository.AddCandidatesPage;
import com.orangehrm.seleniumuiframwork.object_repository.AddEmployeePage;
import com.orangehrm.seleniumuiframwork.object_repository.AddVacanciesPage;
import com.orangehrm.seleniumuiframwork.object_repository.CandidatesPage;
import com.orangehrm.seleniumuiframwork.object_repository.DashboardPage;
import com.orangehrm.seleniumuiframwork.object_repository.LoginPage;
import com.orangehrm.seleniumuiframwork.object_repository.PIMPage;
import com.orangehrm.seleniumuiframwork.object_repository.RecruitmentPage;
import com.orangehrm.seleniumuiframwork.object_repository.TerminationPage;
import com.orangehrm.seleniumuiframwork.object_repository.Vacancies;

public class BaseClass {
	public WebDriver driver = null;
	public WebDriverWait wait = null;
	public Actions a = null;
	public LoginPage loginPage = null;
	public DashboardPage dashboardPage = null;
	public PIMPage pimPage = null;
	public AddEmployeePage addEmpPage = null;
	public TerminationPage terminationPage = null;
	public RecruitmentPage recruitmentPage = null;
	public Vacancies vacancies = null;
	public AddVacanciesPage addVacanciesPage = null;
	public CandidatesPage candidatesPage = null;
	public AddCandidatesPage addCandidates = null;

	public Properties prop;
	public FileInputStream fs;

	public JavascriptExecutor js = null;

	@BeforeSuite
	public void loadData() throws IOException {
		fs = new FileInputStream("./src/test/resources/orangehrms.commondata/commondata.properties");
		prop = new Properties();
		prop.load(fs);

	}

//	@Parameters("browser")
	@BeforeTest
	public void launchingBrowser() {
		String browser = prop.getProperty("browser");
		if (browser.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equals("edge")) {
			driver = new EdgeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		a = new Actions(driver);
		js = (JavascriptExecutor) driver;
		loginPage = new LoginPage(driver);
		dashboardPage = new DashboardPage(driver);
		pimPage = new PIMPage(driver);
		addEmpPage = new AddEmployeePage(driver);
		terminationPage = new TerminationPage(driver);
		recruitmentPage = new RecruitmentPage(driver);
		addVacanciesPage = new AddVacanciesPage(driver);
		vacancies = new Vacancies(driver);
		candidatesPage = new CandidatesPage(driver);
		addCandidates = new AddCandidatesPage(driver);

	}

	@BeforeClass
	public void login() {
		driver.get(prop.getProperty("url"));
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@AfterClass
	public void AfterClass() {
//		dashboardPage.logout();
//		driver.quit();
	}

}
