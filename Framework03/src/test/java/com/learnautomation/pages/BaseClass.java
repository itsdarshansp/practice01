package com.learnautomation.pages;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.learnautomation.utilities.BrowserFactory;
import com.learnautomation.utilities.ConfigDataProvider;
import com.learnautomation.utilities.ExcelDataProvider;
import com.learnautomation.utilities.Helper;

public class BaseClass {
		
	public WebDriver driver;
	public ExcelDataProvider edataprovider;
	public ConfigDataProvider cdataprovider;
	public ExtentReports ereport;
	public ExtentTest logger;
	
	@BeforeSuite
	public void setUpSuit() {
		
		Reporter.log("Strating Before suite", true);
		edataprovider = new ExcelDataProvider();
		cdataprovider= new ConfigDataProvider();
		
		ExtentSparkReporter spark=new ExtentSparkReporter(new File(System.getProperty("user.dir")+"/reports/"+Helper.getCurrentDateTime()+"_Reports.html"));
		ereport= new ExtentReports();
		ereport.attachReporter(spark);
		
		Reporter.log("Ending Before suite", true);
	}
	
	@BeforeClass
	public void setUp() {
		
		Reporter.log("Starting Before class", true);
		driver = BrowserFactory.startBrowser(driver, cdataprovider.getBrowser(), cdataprovider.getappURL());
		Reporter.log("Ending Before class", true);
	}
	
	@AfterClass
	public void tearDown() {
		Reporter.log("After class", true);
		BrowserFactory.quitBrowser(driver);
		Reporter.log("Ending After class", true);
	}
	
	@AfterMethod
	public void tearDownMethod(ITestResult result) {
		
		Reporter.log("After method", true);
		if(result.getStatus()==ITestResult.FAILURE) {
			
			logger.fail("After Method - Failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
		else if(result.getStatus()==ITestResult.SUCCESS) {
			
			logger.pass("After Method - Passed ", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
			Reporter.log("Ending After method", true);
		}
	}
	
	@AfterSuite
	public void tearDownSuit() {
		Reporter.log("After suite", true);
		ereport.flush();
		Reporter.log("Ending After method", true);
	}
}
