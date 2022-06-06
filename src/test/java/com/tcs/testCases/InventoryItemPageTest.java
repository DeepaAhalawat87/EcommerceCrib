package com.tcs.testCases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.tcs.initiateTest.InitClass;
import com.tcs.utilities.ExcelFileUtil;

public class InventoryItemPageTest extends InitClass {

	
	ExcelFileUtil xl;
	
	String outpathExcel="C:\\Users\\deepa\\eclipse-workspace\\Ecommerce\\TestOutputResult\\InventoryOutData.xlsx";
	
	@Test
	public void createExpandableItem() throws Throwable
	{
		
		//1. Login ito autocrib application
		    loginPage.enterName("dmaster-qa");
			//Thread.sleep(3000);
		    System.out.println("Correct pwd");
			loginPage.enterPassword("1111");
			loginPage.clickSearchButton();
			
			if(loginPage.checkAlert())
			{
				loginPage.clickSearchButton();
			}
			
			Assert.assertEquals(loginPage.getTitle(), "Autocrib :: AutoCrib :: Home", "Actual and expected url not matching");
		
		// click automation site
			inventoryItemPage.clickWebAutomationSite();
			inventoryItemPage.clickInventoryLink();
			inventoryItemPage.clickItemsLink();
			inventoryItemPage.clickAddItems();
			
		//Read data from excel and enter into add items page fields and submit
			xl= new ExcelFileUtil("C:\\Users\\deepa\\eclipse-workspace\\Ecommerce\\TestInputData\\InventoryItemList.xlsx");
			int rowCount=xl.rowCount("Expandable");
			int cellCount=xl.cellCount("Expandable");
			System.out.println("row count "+rowCount );
			System.out.println("Column count "+cellCount);
			
			for(int i=1;i<=rowCount;i++)
			{
				String itemNo=xl.getCellData("Expandable", i, 0);
				String description1=xl.getCellData("Expandable", i, 1);
				String description2=xl.getCellData("Expandable", i, 2);
				String itemType=xl.getCellData("Expandable", i, 3);
				String Supplier=xl.getCellData("Expandable", i, 4);
				String SupplierItem=xl.getCellData("Expandable", i, 5);
				String unitCost=xl.getCellData("Expandable", i, 6);
				String unitPrice=xl.getCellData("Expandable", i, 7);
				String issueCost=xl.getCellData("Expandable", i, 8);
				
				try
				{
				inventoryItemPage.enterItem(itemNo);
				inventoryItemPage.enterDescription1(description1);
				inventoryItemPage.enterDescription2(description2);
				inventoryItemPage.selectItemType(itemType);
				inventoryItemPage.selectSupplier(Supplier);
				inventoryItemPage.enterSupplierItem(SupplierItem);
				inventoryItemPage.enterUnitCost(unitCost);
				inventoryItemPage.enterUnitPrice(unitPrice);
				inventoryItemPage.enterIssueCost(issueCost);
				inventoryItemPage.clickSaveButton();
				
				//inventoryItemPage.getNotifocationMessage();
				Assert.assertTrue(inventoryItemPage.getNotifocationMessage().contains("Item added successfully!"), inventoryItemPage.getNotifocationMessage());
				Reporter.log(inventoryItemPage.getNotifocationMessage(), true);
				xl.setCellData("Expandable", i, 9, "PASS", outpathExcel);
				
				
			    }
				
			   catch(AssertionError e)
				{
				   xl.setCellData("Expandable", i, 9, "FAIL", outpathExcel);	 
				}
			   catch(Exception e)
			   {
			    xl.setCellData("Expandable", i, 9, "FAIL", outpathExcel);	
		       }
			}
		}
	
	//Delete an expendable item
	public void deleteAnItem()
	{
		    loginPage.enterName("dmaster-qa");
			loginPage.enterPassword("1111");
			loginPage.clickSearchButton();
			
			if(loginPage.checkAlert())
			{
				loginPage.clickSearchButton();
			}
			Assert.assertEquals(loginPage.getTitle(), "Autocrib :: AutoCrib :: Home", "Actual and expected url not matching");
		
		// click automation site
			inventoryItemPage.clickWebAutomationSite();
			inventoryItemPage.clickInventoryLink();
			inventoryItemPage.clickItemsLink();
	}
	
}

