package com.project.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.project.locators.LoginPage;
import com.utility.base.BaseUtility;
import com.utility.base.ConfigDataProvider;
import com.utility.base.ExcelDataReader;

public class Prerequisite {
	
	public static WebDriver driver;
	public static ExcelDataReader excel;
	public static ConfigDataProvider config;
	LoginPage login;
	
	@BeforeSuite
	public void setUpSuite()
	{
		excel=new ExcelDataReader("Testdata.xlsx");
		config=new ConfigDataProvider();
	}
	
	@BeforeTest
	  public void setup() throws IOException
	  {
		 driver=BaseUtility.openBrowser(config.readBrowserName(), config.readUrl());	
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
