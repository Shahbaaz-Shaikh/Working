package com.project.bin;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_Guru99_Login_1 extends PreCondition{
 @Test
 public void main()
 {
	 System.out.println("Started");
	 Guru99_LoginPage lp=new Guru99_LoginPage(driver);
	 logger.info("Url Launched on Browser");
	 lp.setUsername("mngr26593");
	 logger.info("Entered username");
	 lp.setUserPassword("ishal!12");
	 logger.info("Entered password");
	 lp.clickSubmitBtn();
	 logger.error("Error");
	 Assert.assertEquals(driver.getTitle(), "GTPL Bank Manager HomePage");
	 
 }
}
 