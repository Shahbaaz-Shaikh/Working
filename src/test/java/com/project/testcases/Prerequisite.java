package com.project.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.project.locators.LoginPage;
import com.utility.base.BaseUtility;

public class Prerequisite {
	
	public static WebDriver driver;
	LoginPage login;
	
	@BeforeTest
	  public void setup() throws IOException
	  {
		 driver=BaseUtility.openBrowser(BaseUtility.readConfigValue("browser"), BaseUtility.readConfigValue("url"));	
		 System.out.println("Inside PRe requisite "+driver);
		 login=new LoginPage(driver);
		 login.login();
	 }
		
	@AfterTest
	  public void cleanup()
	  {
		   driver.close();
	  }
	
}
