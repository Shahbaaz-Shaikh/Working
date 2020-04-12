package com.project.testcases;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.utility.base.BaseUtility;

public class Prerequisite extends BaseUtility {
	@BeforeTest
	  public void setup() throws IOException
	  {
		 openBrowser(readConfigValue("browser"), readConfigValue("url"));
	  }
		
	@AfterTest
	  public void cleanup()
	  {
		  driver.close();
	  }
	
}
