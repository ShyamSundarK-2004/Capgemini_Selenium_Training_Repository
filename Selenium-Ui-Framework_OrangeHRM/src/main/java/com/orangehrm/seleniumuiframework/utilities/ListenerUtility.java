package com.orangehrm.seleniumuiframework.utilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.orangehrm.seleniumuiframework.base.BaseClass;

public class ListenerUtility implements ITestListener {

	ExtentReports reports = new ExtentReportUtility().extentInstance();
	ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();

	TakeScreenShotUtility screenshot = new TakeScreenShotUtility();

	@Override
	public void onTestStart(ITestResult result) {
		test.set(reports.createTest(result.getMethod().getMethodName()));
	}
	// Returns the test method object
	// Returns the name of the test method
	// result
	// Object of ITestResult
	// Contains details about the current test execution

	@Override
	public void onTestSuccess(ITestResult result) {
		test.get().pass("Test Status : Pass");

		Object obj = result.getInstance();
		BaseClass base = (BaseClass) obj;
		WebDriver driver = base.driver;

		try {
			String path = screenshot.takeScreenShot(driver, result.getMethod().getMethodName());
			test.get().addScreenCaptureFromPath(path, result.getMethod().getMethodName());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.get().fail("Test Status : Fail");
		test.get().fail(result.getThrowable());

		Object obj = result.getInstance();
		BaseClass base = (BaseClass) obj;

		WebDriver driver = base.driver;

		try {
			String path = screenshot.takeScreenShot(driver, result.getMethod().getMethodName());
			test.get().addScreenCaptureFromPath(path, result.getMethod().getMethodName());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.get().skip("Test status:Skip");
	}

	@Override
	public void onFinish(ITestContext context) {
		reports.flush();
	}

}
