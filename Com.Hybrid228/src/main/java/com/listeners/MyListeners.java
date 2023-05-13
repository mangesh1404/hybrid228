package com.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.base.BaseClass;
import com.utilities.DriverUtils;

public class MyListeners extends BaseClass implements ITestListener {

	public void onTestStart(ITestResult result) {
		test=report.createTest(result.getName());
	}
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Testcase success with name: "+result.getName());
	}
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, "Testcase failed with name: "+result.getName());
		String path =DriverUtils.captureScreenshot(result.getName());
		test.addScreenCaptureFromPath(path);	
	}

	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, "Testcase skip with name: "+result.getName());
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	public void onStart(ITestContext context) {
		
		
	}

	public void onFinish(ITestContext context) {
		report.flush(); // To save data in the extent report
		
	}

	
	
}
