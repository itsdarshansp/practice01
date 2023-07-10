package com.learnautomation.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.learnautomation.pages.BaseClass;
import com.learnautomation.pages.LoginPage;

public class Login01 extends BaseClass {
	@Test
	public void loginApp() {
		
		logger = ereport.createTest("Login to CRM");
		
		LoginPage loginpage=PageFactory.initElements(driver, LoginPage.class);
		
		logger.info("This is info");
		
		loginpage.loginToCRM(edataprovider.getStringData("Inputdata", 0, 0), edataprovider.getStringData(0, 0, 1));
		
		logger.pass("Test Passed");
		
	}
	
	@Test
	public void logoutApp() {
		
		logger = ereport.createTest("Logout CRM");
		
		logger.fail("Test Failed verified");
		
	}
	
}
