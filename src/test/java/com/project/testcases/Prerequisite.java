package com.project.testcases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import com.project.locators.LoginPage;
import com.utility.base.BaseUtility;
import com.utility.base.ConfigDataProvider;
import com.utility.base.ExcelDataReader;
import com.utility.base.ExtentReportLogger;

public class Prerequisite {
	
	public static WebDriver driver;
	public static ExcelDataReader excel;
	public static ConfigDataProvider config;
	public static Logger logger;
	LoginPage login;
	public ExtentReportLogger extent;
	public String browserName;
	
	
	@BeforeSuite
	public void setUpSuite()
	{
		excel=new ExcelDataReader("Testdata.xlsx");
		config=new ConfigDataProvider();
		logger=Logger.getLogger("PreCondition");
		PropertyConfigurator.configure("log4j.properties");
	}
	
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String browser) throws IOException
	{
		
		if(browserName==null)
		   {
		    driver=BaseUtility.openBrowser(config.readBrowserName(), config.readUrl());
		    browserName=config.readBrowserName();
		   }
		else
		   {
			driver=BaseUtility.openBrowser(browser, config.readUrl());	
			browserName=browser;
		   }
		 System.out.println("Inside PRe requisite "+driver);
		 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		 login=new LoginPage(driver);
		 login.login();
	 }
		
	@AfterClass
	public void cleanup()
	{
		 extent.reportFlush();
		 driver.close();
	}
	
	
	
}
