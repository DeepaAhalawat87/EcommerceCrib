package com.tcs.reporting;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import com.tcs.utilities.CaptureScreenShot;

public class MyListener implements ITestListener {

	static ExtentReports extent = ExtentReporter.getExtentReport();
	ExtentTest test;
	String imgPath;
	
	public void onTestStart(ITestResult result)
	{
		test=extent.createTest(result.getName());
		
		//System.out.println(result.getName()+" testcase  started ");
		
	}
	
	
	public void onTestSuccess(ITestResult result)
	{
		//test.log(Status.PASS,"Test case success");
		//System.out.println(result.getName() + " test case success ");
		try {
			imgPath=CaptureScreenShot.captureScreenShot(result.getName());
			//test.pass("Passed test " +test.addScreenCaptureFromPath(imgPath));  //working
			//test.log(Status.PASS, test.addScreenCaptureFromPath(imgPath));  //not working
			//test.log(Status.PASS, (Markup) test.addScreenCaptureFromPath(imgPath)); //not working
			
			test.log(Status.PASS, "Test case passed", MediaEntityBuilder.createScreenCaptureFromPath(imgPath).build());  //working
			
		
		
			
			//test.log(Status.PASS,test.addScreenCaptureFromPath(imgPath));
		
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
					}
	}
		
	
	public void onTestFailure(ITestResult result)
	{
		//test.log(Status.FAIL, "Test case failed");
		//System.out.println(result.getName() + " testcase failed");
		try {
			imgPath=CaptureScreenShot.captureScreenShot(result.getName());
			//test.fail("failed test "+test.addScreenCaptureFromPath(imgPath));
			//test.log(Status.FAIL, (Markup) test.addScreenCaptureFromPath(imgPath));
			test.log(Status.FAIL, "Test casefailed", MediaEntityBuilder.createScreenCaptureFromPath(imgPath).build());test.log(Status.FAIL, "Test case failed", MediaEntityBuilder.createScreenCaptureFromPath(imgPath).build());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
	}
	
	public void onTestSkipped(ITestResult result)
	{
		test.log(Status.SKIP, "test case skipped");
		//System.out.println(result.getName() +" test case skipped");
	}
	
	public static void putReport()
	{
		System.out.println("report publishing ");
		extent.flush();
	}
	
}
