package com.utility.base;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {
	
	Properties prop;
	
	public  ConfigDataProvider() {
		// TODO Auto-generated constructor stub
		
		try {
			FileInputStream fis=new FileInputStream("./TestData/config.properties");
			prop=new Properties();
			prop.load(fis);
		 }
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("Unable to read properties file "+e.getMessage());
		}
	}


	public String readBrowserName() {
		// TODO Auto-generated method stub
		return prop.getProperty("browser");
	}


	public String readUrl() {
		// TODO Auto-generated method stub
		return prop.getProperty("url");
	}

	
	
}
