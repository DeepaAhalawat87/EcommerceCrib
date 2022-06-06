package com.tcs.PageObjects;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InventoryItemPage {
	
	WebDriver driver;
	Select s;
	WebDriverWait wait;
	Actions act;

 public InventoryItemPage(WebDriver driver) {
// TODO Auto-generated constructor stub
	
	this.driver=driver;
	PageFactory.initElements(driver, this);
	wait=new WebDriverWait(driver,10);
	act=new Actions(driver);
	//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}


@FindBy(xpath="(//ul[@class='box-inner-listing-menu']/li/a)[14]")
public WebElement webAutomationApiSite;
	
@FindBy(xpath="//i[@class='icon inventory-icon']/following-sibling::span")
public WebElement inventoryLink;


@FindBy(xpath="//a[@href='/Inventory/Item']")
public WebElement itemsLink;

//@FindBy(xpath="//ul[@class='treeview-menu treeview-submenu']/li/a[@href='/Inventory/Item/Add']")
@FindBy(xpath="//a[@href='/Inventory/Item/Add']")
public WebElement addItemLink;

@FindBy(id="Code")
public WebElement itemNo;

@FindBy(id="Description1")
public WebElement description1;

@FindBy(id="Description2")
public WebElement description2;

@FindBy(id="ItemType")
public WebElement itemType;

@FindBy(id="Vendor")
public WebElement supplier;

@FindBy(id="VendorItem")
public WebElement supplierItem;

@FindBy(id="Cost")
public WebElement unitCost;

@FindBy(id="AvgUnitCost")
public WebElement unitPrice;

@FindBy(id="IssueCost")
public WebElement issueCost;

@FindBy(id="btnSubmit")
public WebElement saveBtn;

@FindBy(xpath="//div[@class='alert alert-info']")
public WebElement notificationMsg;

public void clickWebAutomationSite()
{
	
    JavascriptExecutor js= (JavascriptExecutor)driver;
    js.executeScript("window.scrollBy(0,200)");
    wait.until(ExpectedConditions.elementToBeClickable(webAutomationApiSite));
    act.moveToElement(webAutomationApiSite).click().perform();
	//this.webAutomationApiSite.click();
}

public void clickInventoryLink()
{
	wait.until(ExpectedConditions.elementToBeClickable(inventoryLink));
	this.inventoryLink.click();
}

public void clickItemsLink()
{
	wait.until(ExpectedConditions.elementToBeClickable(itemsLink));
	this.itemsLink.click();
}

public void clickAddItems()
{
	try {
	wait.until(ExpectedConditions.elementToBeClickable(addItemLink));
	this.addItemLink.click();
	}
	catch(TimeoutException e)
	{
		e.printStackTrace();
	}
	catch(NoSuchElementException e)
	{
		e.printStackTrace();
	}
}

public void enterItem(String item)
{
	this.itemNo.sendKeys(item);
}

public void enterDescription1(String description1)
{
 this.description1.sendKeys(description1);	
}

public void enterDescription2(String description2)
{
 this.description2.sendKeys(description2);	
}

public void selectItemType(String itemType)
{
	s= new Select(this.itemType);
	s.selectByVisibleText(itemType);
}

public void selectSupplier(String index1)
{
	int index = Integer.valueOf(index1);
	s=new Select(this.supplier);
	s.selectByIndex(index);
	//List<WebElement>e=s.getAllSelectedOptions();
}


public void enterSupplierItem(String supItem)
{
	this.supplierItem.sendKeys(supItem);
}

public void enterUnitCost(String unitCost)
{
   this.unitCost.clear();
   this.unitCost.sendKeys(unitCost);
}

public void enterUnitPrice(String unitPrice)
{
	this.unitPrice.clear();
	this.unitPrice.sendKeys(unitPrice);
}

public void enterIssueCost(String issueCost)
{
    this.issueCost.clear();
	this.issueCost.sendKeys(issueCost);
}

public void clickSaveButton()
{   
	JavascriptExecutor js=(JavascriptExecutor)driver;
    js.executeScript("window.scrollBy(0,600)");
	wait.until(ExpectedConditions.elementToBeClickable(saveBtn));
	this.saveBtn.click();
}

public String getNotifocationMessage()
{
	wait.until(ExpectedConditions.visibilityOf(notificationMsg));
	return this.notificationMsg.getText();
	

}

	
	
	
}
