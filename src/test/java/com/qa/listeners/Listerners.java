package com.qa.listeners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qa.generic.BaseTest;
import com.qa.utilities.ExtentReportclass;

import io.appium.java_client.AppiumDriver;

public class Listerners extends BaseTest implements ITestListener {

	ExtentTest test;
	//get the method 
	ExtentReports extent=ExtentReportclass.getReports();
	 AppiumDriver driver;

	public void onTestStart(ITestResult result) {//result var holds all info abt the Tests
		// TODO Auto-generated method stub
		test=extent.createTest(result.getMethod().getMethodName());//test is responsible to give info abt particular Tests in our reports
		BaseTest base = new BaseTest();
		ExtentReportclass.startTest(result.getName(), result.getMethod().getDescription()).assignCategory(base.getPlatform() + ":" + base.getDeviceName()+":"+base.getUDID());
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		//test.log(Status.PASS, "Test Passed");
		ExtentReportclass.getTest().log(Status.PASS, "Test  case is Passed: "+result.getMethod().getMethodName());

	}

	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, "Test case is Failed:" +result.getThrowable());
	
		try {
			ExtentReportclass.getTest().addScreenCaptureFromPath(getScreenShotPaths(result.getMethod().getMethodName()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ExtentReportclass.getTest().log(Status.FAIL, "Failed TC:"+result.getMethod().getMethodName());
		
		}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		//test.log(Status.SKIP, "Test Skipped");
		ExtentReportclass.getTest().log(Status.SKIP, "Test Case is  Skipped:"+result.getMethod().getMethodName());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
	}

}
