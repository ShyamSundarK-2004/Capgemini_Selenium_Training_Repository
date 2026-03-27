package com.orangehrm.seleniumuiframework.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportUtility {

	public static ExtentReports reports;
	String timeStamp = new SimpleDateFormat("yyyy-MM-dd[hh-mm-ss]").format(new Date());
	String path = "./Reports/Test_Report " + timeStamp + ".html";

	public ExtentReports extentInstance() {

		if (reports == null) {
			ExtentSparkReporter spark = new ExtentSparkReporter(path);

			// report configuratiom
			spark.config().setReportName("OrangeHRM Selenium_UI_Framework Test_Report");
			spark.config().setDocumentTitle("Test Results");
			reports = new ExtentReports();
			reports.attachReporter(spark);
			reports.setSystemInfo("Automation Tester", "Shyam Sundar K");
			reports.setSystemInfo("UI_Automation_Framework", "Selenium + TestNG");

		}

		return reports;
	}

}
