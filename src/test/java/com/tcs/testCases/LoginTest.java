package com.tcs.testCases;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.tcs.initiateTest.InitClass;

public class LoginTest extends InitClass{

	
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginTest.class);
	
	@Test
	public void testLogin() throws InterruptedException
	{
	    LOGGER.info("TestLogin is running" );
		loginPage.enterName("dmaster-qa");
		//Thread.sleep(3000);
		loginPage.enterPassword("1111");
		loginPage.clickSearchButton();
		
		if(loginPage.checkAlert())
		{
			loginPage.clickSearchButton();
		}
		
		Assert.assertEquals(loginPage.getTitle(), "Autocrib :: AutoCrib :: Home", "Actual and expected url not matching");
		Reporter.log("Actual Url: "+ loginPage.getTitle()+ "  ExpUrl: "+"Autocrib :: AutoCrib :: Home" + " User loggin successfully",true);
		
	
	}
	
}
