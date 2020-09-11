package com.project.testcases;

import java.lang.reflect.Method;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.project.locators.ItemsListHomepage;
import com.utility.base.ExtentReportLogger;

public class TC_001_Search_and_add_Item_to_the_cart extends Prerequisite 
{
	 	
	 @BeforeMethod
	  public void beforeTest(Method method) 
	  {
		extent=new ExtentReportLogger(method.getName(),browserName,driver);
		System.out.println("The test that will run : "+ method.getName() );
	  }
	
	  @Test
	  public void Add_Item_to_the_Cart() 
	  {
	    driver.navigate().to("https://rahulshettyacademy.com/seleniumPractise/#/");
	    extent.reportLog("Site Launched successfully", "Pass");
	    ItemsListHomepage itemlist=new ItemsListHomepage(driver);
	    itemlist.setSearchText("cucumber");
	    extent.reportLog("Searched for an item", "Pass");
	    itemlist.clickSearchButton();
	    extent.reportLog("Clicked on search button sucessfully", "Pass");
	  }
	  
	  @AfterMethod
	  public void after(ITestResult result) 
	  {
		System.out.println("The test that ran : "+ result.getName() );
	  }
  
}
