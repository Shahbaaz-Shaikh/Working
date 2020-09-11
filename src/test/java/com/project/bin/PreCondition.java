package com.project.bin;


import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import com.utility.base.BaseUtility;
import com.utility.base.ConfigDataProvider;

public class PreCondition {

	public static ConfigDataProvider config;
	public static WebDriver driver;
	public static Logger logger;
	
	
	@BeforeClass
	public void setUp()
	{
		driver=BaseUtility.openBrowser("chrome", "http://demo.guru99.com/V1/index.php");
		logger=Logger.getLogger("PreCondition");
		PropertyConfigurator.configure("log4j.properties");
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
}
