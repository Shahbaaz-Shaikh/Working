package com.utility.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BaseUtility {

public static String ProjectPath=System.getProperty("user.dir");
public static WebDriver driver;
public static Properties prop;

	
	public static void openBrowser(String browsername,String url)
	{
		if(browsername.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", ProjectPath+"/src/test/java/com/project/config/chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(browsername.equalsIgnoreCase("FF")||browsername.equalsIgnoreCase("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", ProjectPath+"/src/test/java/com/project/config/geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else if(browsername.equalsIgnoreCase("IE")||browsername.equalsIgnoreCase("InternetExplorer"))
		{
			DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
			caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
			caps.setCapability("ignoreZoomSetting", true);
			System.setProperty("webdriver.ie.driver", ProjectPath+"/src/test/java/com/project/config/IEDriverServer.exe");
			driver=new InternetExplorerDriver(caps);
		}
		
		driver.manage().window().maximize();
		driver.get(url);		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);  
	}
	
	public String readConfigValue(String configName) throws IOException 
	{
		FileInputStream fis=new FileInputStream(ProjectPath+"/src/test/java/com/project/config/config.properties");
		prop=new Properties();
		prop.load(fis);
		String configValue=prop.getProperty(configName);
		return configValue;
	}
	
	

}