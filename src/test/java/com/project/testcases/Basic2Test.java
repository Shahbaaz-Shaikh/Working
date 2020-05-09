package com.project.testcases;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

public class Basic2Test extends Prerequisite 
{
	 	
	  @Test
	  public void mainTest() 
	  {
	    System.out.println("My first Code"+driver);
	    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	    driver.navigate().back();
	  }
  
}
