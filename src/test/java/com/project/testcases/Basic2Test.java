package com.project.testcases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.utility.base.BaseUtility;

public class Basic2Test extends BaseUtility {

  @BeforeTest
  public void setup()
  {
	 openBrowser("ie", "https://www.google.com");
  }
	
  @Test
  public void mainTest() {
    System.out.println("My first Code");
  }
  
  @AfterTest
  public void cleanup()
  {
	  driver.close();
  }
}
