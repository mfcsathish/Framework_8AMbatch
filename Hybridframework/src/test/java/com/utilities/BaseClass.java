package com.utilities;

import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class BaseClass {
	
	
	public static WebDriver driver;
	
	public static Properties prop = new Properties();
	
	public static String projectDir;
	
	public static String screenshotPath;
	
	public static String className;
	
	public static String methodName;
	
	public static Actions actions;
	
	public static JavascriptExecutor js;

	

}
