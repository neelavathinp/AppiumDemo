package com.qa.utilities;

import java.util.HashMap;
import java.util.Map;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportclass {
	static ExtentReports extent;
	static Map<Integer, ExtentTest> extentTestMap = new HashMap();
	
	public synchronized static ExtentReports getReports() {
		if (extent==null) {
		String path=System.getProperty("user.dir")+"\\reports\\extentreport.html";
		ExtentSparkReporter spark = new ExtentSparkReporter(path);
		 // Name of the report
		spark.config().setReportName("POC Automation Reports");
		spark.config().setDocumentTitle("POC Reports");	
		spark.config().setTheme(Theme.DARK);
		// Create an object of Extent Reports
		extent =new ExtentReports();
		extent.attachReporter(spark);
		extent.setSystemInfo("Device", "Android");
		}
		return extent;
	}
	 public static synchronized ExtentTest getTest() {
	        return  extentTestMap.get((int) (Thread.currentThread().getId()));
	    }

	    public static synchronized ExtentTest startTest(String testName, String desc) {
	        ExtentTest test = extent.createTest(testName, desc);
	        extentTestMap.put((int) (Thread.currentThread().getId()), test);
	        return test;
	    }
}