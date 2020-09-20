package com.project.testcases;

import java.lang.reflect.Method;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.project.locators.ItemsListHomepage;
import com.utility.base.ExtentReportLogger;

public class TC_002_Verify_user_can_remove_items_from_cart extends Prerequisite{
	
	@BeforeMethod
	  public void beforeTest(Method method) 
	  {
		extent=new ExtentReportLogger(method.getName(),browserName,driver);
		System.out.println("The test that will run : "+ method.getName() );
	  }
	
	  @Test
	  public void Verify_user_can_remove_items_from_cart() 
	  {
	    driver.navigate().to("https://rahulshettyacademy.com/seleniumPractise/#/");
	    extent.reportLog("Site Launched successfully", "Pass");
	    ItemsListHomepage itemlist=new ItemsListHomepage(driver);
	    Actions action=new Actions(driver);
	    action.moveToElement(itemlist.copyright);
	    action.perform();
	    extent.reportLog("Scrolled", "Pass");
	    
	    
	    driver.get("https://demoqa.com/browser-windows");
	    
       String handle=driver.getWindowHandle();
       
       System.out.println(handle);
       
       driver.findElement(By.id("windowButton")).click();
       
       Set<String> handles=driver.getWindowHandles();
       for(String whandle:handles) {
    	   driver.switchTo().window(whandle);
       }
       
       driver.close();
       driver.switchTo().window(handle);
       driver.navigate().to("https://demoqa.com/frames");
       driver.switchTo().frame("frame1");
       Boolean value=driver.findElement(By.id("sampleHeading")).isDisplayed();
       System.out.println(value);

	  }
	  
	  @AfterMethod
	  public void after(ITestResult result) 
	  {
		System.out.println("The test that ran : "+ result.getName() );
	  }

}
