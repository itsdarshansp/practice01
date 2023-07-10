package com.learnautomation.utilities;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {

	// Take Screenshot
	public static String captureScreenshot(WebDriver driver) {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String screenshotPath=(System.getProperty("user.dir")+"/screenshots/"+getCurrentDateTime()+"_Login.png");
		try {
			FileHandler.copy(src, new File(screenshotPath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Problem in capturing screenshot: " + e.getMessage());
		}
		return screenshotPath;
	}

	// Current date time generator
	public static String getCurrentDateTime() {
		DateFormat dformat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date date = new Date();
		return dformat.format(date);
	}
	
}
