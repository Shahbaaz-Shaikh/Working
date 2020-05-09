package com.project.locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage  {

WebDriver driver;
		
	public LoginPage(WebDriver driver) 
	  {
		// TODO Auto-generated constructor stub
		 this.driver=driver;
		 PageFactory.initElements(driver, this);
		 System.out.println("Inside Login page "+driver);
	  }

	@FindBy(xpath = "//*[text()='Login']") public WebElement loginButton;
	@FindBy(xpath = "//input[@type='email']") public  WebElement emailInputFied;
	@FindBy(xpath = "//input[@type='password']") public  WebElement pwdInputFied;
	
	public void login()
	{
		loginButton.click();
		emailInputFied.sendKeys("adilshaikh098@gmail.com");
		pwdInputFied.sendKeys("addy12");
	}
	
	public void clearFields()
	{
		emailInputFied.sendKeys("");
		pwdInputFied.sendKeys("");
	}
	
}
