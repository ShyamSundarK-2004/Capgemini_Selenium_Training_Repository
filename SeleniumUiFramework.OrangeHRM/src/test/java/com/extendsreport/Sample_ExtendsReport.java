package com.extendsreport;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Sample_ExtendsReport {

	@Test
	public void generateReport() {

		// create new test
		ExtentReports test = new ExtentReports();

		// create a reporter

		ExtentSparkReporter spark = new ExtentSparkReporter("./Reports/sample.html");

		test.attachReporter(spark);

		ExtentTest ref = test.createTest("Sample Test");

		// logging
		ref.info("--excution started--");

		ref.pass("--test passed--");

		ref.fail("--test failed--");

		// push the logs in the report
		test.flush();
	}

}
