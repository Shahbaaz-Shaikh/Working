package com.utility.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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
		
		driver.get(url);
	}

}