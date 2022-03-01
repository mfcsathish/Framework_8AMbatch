package com.testscenarios;

import org.testng.annotations.Test;

import com.objectrepoistory.Locators;
import com.utilities.CommonFunctions;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class Template extends CommonFunctions {
	
	
	Locators loc = new Locators();
	
		
	  @BeforeClass
	  public void beforeClass() throws Exception {
		  
		  WebDriverManager.chromedriver().setup();
		  driver = new ChromeDriver();
		  
		  //Read the data from property file
		  
		  FileInputStream propertyfilepath = new FileInputStream("./src/test/resources/testdata/input.properties");
		  
		  //Load the property file data to reference
		  
		  prop.load(propertyfilepath);
		  
		  //type fb_url
		  
		  driver.get(prop.getProperty(""));
		  driver.manage().window().maximize();
	  }
	  
	
  @Test
  public void f() throws Exception {
	  
	
	  FileInputStream propertyfilepath = new FileInputStream("./src/test/resources/testdata/input.properties");	  
	  //Load the property file data to reference	  
	  prop.load(propertyfilepath);
	  
		  
	   
	  
  }


  @AfterClass
  public void afterClass() {
	  
	  //driver.close();
	  
	  
  }

}
