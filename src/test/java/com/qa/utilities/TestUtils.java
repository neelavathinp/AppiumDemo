package com.qa.utilities;

import java.io.File;
import java.io.IOException;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;



import io.appium.java_client.AppiumDriver;

public class TestUtils  {
	
	
	//WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10)) in baseTest
	//inorder to avoid hard cording we created util class and kept the wait here
	public static final long WAIT = 10;
	public static  String NodeExePath="C:\\Program Files\\nodejs\\node.exe";
	public  static String NodeJSPath="C:\\Users\\neelavathi\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js";
	public static  String ServerAddress="127.0.0.1";
	
	public String dateTime() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		Date date = new Date();
		return dateFormat.format(date);
	}
	 public static Logger log() {
			return (Logger) LogManager.getLogger(Thread.currentThread().getStackTrace()[2].getClassName());
			   
		   }
}
