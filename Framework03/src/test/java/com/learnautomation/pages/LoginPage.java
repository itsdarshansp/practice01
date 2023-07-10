package com.learnautomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	@FindBy (name="username") WebElement uname;
	@FindBy (name="password") WebElement pswd;
	@FindBy (xpath="//input[@value='Login']") WebElement login;
	
	public void loginToCRM(String usernameApp,String passwordApp) {
		uname.sendKeys(usernameApp);
		pswd.sendKeys(passwordApp);
		login.click();
	}
}
