package com.tcs.initiateTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.tcs.PageObjects.InventoryItemPage;
import com.tcs.PageObjects.LoginPage;
import com.tcs.reporting.MyListener;
import com.tcs.utilities.PropertyFileUtil;

public class InitClass {

	public static WebDriver driver;
	protected LoginPage loginPage;
	protected InventoryItemPage inventoryItemPage;
	
	@BeforeClass
	public void setup() throws Throwable
	{
	  if(PropertyFileUtil.getPropertyValue("driver").equalsIgnoreCase("chrome"))
	  {
	  System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\CommonDrivers\\chromedriver.exe");
	  driver=new ChromeDriver();
	  }
	  else
		 Reporter.log("driver does not exist", true);
	  
	  driver.manage().window().maximize();
	  createObjects();
	 
	}
	
	public void createObjects()
	{
		loginPage=new LoginPage(driver);
		inventoryItemPage= new InventoryItemPage(driver);
	}
	
	@BeforeMethod
	public void LaunchUrl() throws Throwable
	{
		driver.get(PropertyFileUtil.getPropertyValue("url"));
	}
	
	@AfterClass
	public void tearDown()
	{
		MyListener.putReport();
		System.out.println("report published");
		//driver.close();
	}
	
	
}
