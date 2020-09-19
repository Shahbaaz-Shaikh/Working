package com.project.locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ItemsListHomepage {
	WebDriver ldriver;
	
	public ItemsListHomepage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		ldriver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(className = "search-keyword") public WebElement searchBox;
	@FindBy(className = "searrch-button") public WebElement searchBtn;
	@FindBy(xpath = "//strong[text()='GreenKart']") public WebElement copyright;
	
	public void setSearchText(String itemname)
	{
		searchBox.sendKeys(itemname);
	}
	
	public void clickSearchButton()
	{
		searchBtn.click();
	}
}
