package com.utility.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BaseUtility {

public static String ProjectPath=System.getProperty("user.dir");
public static WebDriver driver;
	
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
		driver.get(url);
	}

}