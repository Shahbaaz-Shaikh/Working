package com.utility.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.swing.text.Element;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseUtility {

public static String ProjectPath=System.getProperty("user.dir");
	/* public static WebDriver driver; */
public static Properties prop;

	
	public static WebDriver openBrowser(String browsername,String url)
	{
		WebDriver driver=null;
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
		return driver;
	}
	
	public static String readConfigValue(String configName) throws IOException 
	{
		try {
			FileInputStream fis=new FileInputStream(ProjectPath+"/src/test/java/com/project/config/config.properties");
			prop=new Properties();
			prop.load(fis);
		 }
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("Unabcle to read properties file "+e.getMessage());
		}
			
		String configValue=prop.getProperty(configName);
		return configValue;
	}
	
	public static void selectRadiobutton(WebElement element,WebDriver driver) {
		
		try {
			if(element.isDisplayed())
			{
				element.click();
				
			}
			else
			{
				WebDriverWait wait=new WebDriverWait(driver, 20);
				
			}
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}