package com.tcs.PageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginPage {

	private static final Logger LOGGER= LoggerFactory.getLogger(LoginPage.class);
	WebDriver driver;
	WebDriverWait wait;
	Alert alert;
	
	@FindBy(id="txtLoginName")
	public WebElement username;
	
	@FindBy(id="Password")
	public WebElement password;
	
	@FindBy(id="btnLoginSubmit")
	public WebElement submitBtn;
	
	
	
	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
	this.driver=driver;
	PageFactory.initElements(driver, this);
	wait= new WebDriverWait(driver,10);
	
	}




	public void enterName(String name)
	{
		wait.until(ExpectedConditions.visibilityOf(username));
		this.username.clear();
		this.username.sendKeys(name);
		LOGGER.info("Entered username");
		
		
	}
	
	public void enterPassword(String pwd)
	{
		wait.until(ExpectedConditions.visibilityOf(password));
		this.password.clear();
		this.password.sendKeys(pwd);
		LOGGER.info("Entered password");
	}
	
	public void clickSearchButton()
	{
		wait.until(ExpectedConditions.elementToBeClickable(submitBtn));
		this.submitBtn.click();
		LOGGER.info("Submit button clicked");
	}
	
	public boolean checkAlert()
	{
	  if(wait.until(ExpectedConditions.alertIsPresent()) != null)	
	  {
		  driver.switchTo().alert().accept();
		  return true;
	  }
	  else 
	  return false;
	}
	
	public String getTitle()
	{
		return driver.getTitle();
	}
	
	
	
	
	
	
	
}
