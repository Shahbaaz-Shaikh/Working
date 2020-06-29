package com.project.locators;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PracticePage {
	WebDriver driver;
	
	public PracticePage(WebDriver driver) 
	  {
		// TODO Auto-generated constructor stub
		 this.driver=driver;
		 PageFactory.initElements(driver, this);
		 System.out.println("Inside Automation Practice page "+driver);
	  }
	
	
	
	
	 @FindBy (xpath="//input[@name='radioButton']") WebElement radioBtn;

}
