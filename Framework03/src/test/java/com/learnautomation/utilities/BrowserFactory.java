package com.learnautomation.utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {
	
	
	public static WebDriver startBrowser(WebDriver driver,String browserName, String appURL) {
		
		if(browserName.equals("Chrome")) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		}
		
		else if(browserName.equals("Firefox")) {
			System.setProperty("webdriver.chrome.driver", "./drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		else if(browserName.equals("Edge")) {
			
		}
		else {
			System.out.println("We do not support this browser type");
		}
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(appURL);
		return driver;
	}
	
	public static void quitBrowser(WebDriver driver) {
		driver.quit();
	}
}
