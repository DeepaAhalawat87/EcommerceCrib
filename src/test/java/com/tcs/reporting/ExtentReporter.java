package com.tcs.reporting;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter {

	 static ExtentReports reports;
	 static ExtentHtmlReporter htmlReporter;
	 
	 public static ExtentReports getExtentReport()
	 {
		
		 htmlReporter = new ExtentHtmlReporter("./Extent_Report/ExtentReport_"+generateDate()+".html");
		 htmlReporter.config().setReportName("Automation Report");
		 htmlReporter.config().setDocumentTitle("Extent Report");
		 htmlReporter.config().setTheme(Theme.DARK);
		 
		 reports=new ExtentReports();
		 reports.attachReporter(htmlReporter);
		 
		 reports.setSystemInfo("Operating system", "Window");
		 reports.setSystemInfo("user name", "Deepa");
		return reports;
		 
		 
	 }
	 
	 
	 public static String generateDate()
	 {
		 Date d=new Date();
		 DateFormat df= new SimpleDateFormat("yyyy-MM-dd-hhmmss");
		 return df.format(d);
	 }
}
