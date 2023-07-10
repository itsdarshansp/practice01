package com.learnautomation.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {
		
	Properties pro;
	public ConfigDataProvider() {
		
		File src= new File("./config/config.properties");
		try {
			FileInputStream fis=new FileInputStream(src);
			pro= new Properties();
			pro.load(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error in COnfig Data provider: "+e.getMessage());
		}
	}
	
	public String getBrowser() {
		return pro.getProperty("Browser");
	}
	
	public String getappURL() {
		return pro.getProperty("appURL");
	}
	
	public String getconfigData(String keyValue) {
		return pro.getProperty(keyValue);
	}
}
