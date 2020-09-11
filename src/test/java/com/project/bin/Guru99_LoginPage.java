package com.project.bin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class Guru99_LoginPage {

	public WebDriver ldriver;
	
	public Guru99_LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		ldriver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="uid") public WebElement userID;
	@FindBy(name="password") public WebElement userPwd;
	@FindBy(name="btnLogin") public WebElement loginBtn;
	
	public void setUsername(String usrName) {
		userID.sendKeys(usrName);
	}
	
	public void setUserPassword(String usrPwd) {
		userPwd.sendKeys(usrPwd);
	}
	
	public void clickSubmitBtn() {
		loginBtn.click();
	}
	
}
