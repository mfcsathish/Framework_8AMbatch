package com.testscenarios;

import org.testng.annotations.Test;

import com.objectrepoistory.Locators;
import com.utilities.CommonFunctions;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class Utilities extends CommonFunctions {
	
		
	//Read the data from property file
	
	 
	Locators loc = new Locators();
	  
	  
	@Parameters("browsername")
	@BeforeClass
	public void beforeClass(@Optional("chrome") String browsername) {

		if (browsername.equalsIgnoreCase("Chrome")) {
			chromeBrowserLaunch();
		}

		else if (browsername.equalsIgnoreCase("edge")) {
			edgeBrowserLaunch();
		}

		else if (browsername.equalsIgnoreCase("firefox")) {
			firefoxBrowserLaunch();
		}

		else {

			System.out.println("Give valid Browser Name");

		}
		
	  }
	  
	
  @Test
  public void f() throws Exception {
	  
	
	  FileInputStream propertyfilepath = new FileInputStream("./src/test/resources/testdata/input.properties");	 
	  
	  //Load the property file data to reference
	  
	  prop.load(propertyfilepath);
	  
	  //type fb_url
	  
	  driver.get(prop.getProperty("FB_URL"));
	  
	  driver.manage().window().maximize();
	  
	  sendkeysByAnyLocator(loc.FBlogin_Email_Editbox, prop.getProperty("username"));
	  
	  sendkeysByAnyLocator(loc.FBlogin_Password_Editbox, prop.getProperty("password"));
	  
	  expicitwait(loc.FBlogin_Submit_button);
	  
	  clickbyLocator(loc.FBlogin_Submit_button);
	  
	
	  
	   
	  
  }


  @AfterClass
  public void afterClass() {
	  
	  //driver.close();
	  
	  
  }

}
