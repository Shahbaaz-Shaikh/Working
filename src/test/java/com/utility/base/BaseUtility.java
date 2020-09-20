package com.utility.base;


import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BaseUtility {

public static String ProjectPath=System.getProperty("user.dir");
	
public static Properties prop;

	
	@SuppressWarnings("deprecation")
	public static WebDriver openBrowser(String browsername,String url)
	{
		WebDriver driver=null;
		if(browsername.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(browsername.equalsIgnoreCase("FF")||browsername.equalsIgnoreCase("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else if(browsername.equalsIgnoreCase("IE")||browsername.equalsIgnoreCase("InternetExplorer"))
		{
			DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
			caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
			caps.setCapability("ignoreZoomSetting", true);
			System.setProperty("webdriver.ie.driver", "./Drivers/IEDriverServer.exe");
			driver=new InternetExplorerDriver(caps);
		}
		
		driver.manage().window().maximize();
		driver.get(url);		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);  
		return driver;
	}
	
	
	public static void selectRadiobutton(WebElement element,WebDriver driver) {
		
		try {
			if(element.isDisplayed())
			{
				element.click();
				
			}
			else
			{
				//WebDriverWait wait=new WebDriverWait(driver, 20);
				
			}
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	
	public static String extractDigits(String strValue)
	{
	    String str=strValue.trim();
	    String extNum="";
	    for(int i=0;i<str.length();i++)
	    {
	    	char ch=str.charAt(i);
	    	if(Character.isDigit(ch))
	    		extNum=extNum+ch;
	    }
		return extNum;
	}
	

}