package com.tcs.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.tcs.initiateTest.InitClass;

public class CaptureScreenShot
{
	//WebDriver driver;
	 public static String captureScreenShot(String testcaseName) throws IOException
	 {
		 File file= ((TakesScreenshot)InitClass.driver).getScreenshotAs(OutputType.FILE);
		String destPath= System.getProperty("user.dir")+"\\Screenshot\\"+testcaseName+"_"+generateDate()+".png";
		FileUtils.copyFile(file, new File(destPath));
		
		return destPath;
		 
	 }
	 
	 public static String generateDate()
	 {
		 
		Date d= new Date();
		SimpleDateFormat df= new SimpleDateFormat("yyyy-MM-dd-hhmmss");
		return df.format(d);
		 
	 }
}
