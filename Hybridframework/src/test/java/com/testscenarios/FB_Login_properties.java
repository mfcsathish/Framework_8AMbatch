package com.testscenarios;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.objectrepoistory.Locators;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FB_Login_properties extends Locators {
	
	WebDriver driver;
		 
	Properties prop = new Properties();
	
	  @BeforeClass
	  public void beforeClass() throws Exception {
		  WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
			//read the data from property file
			
			
			FileInputStream propertyfilepath = new FileInputStream("./src/test/resources/testdata/input.properties");
			
			//load data from property
			
			prop.load(propertyfilepath);
			
			
		// typefb url	
		driver.get(prop.getProperty("FB_URL"));
		driver.manage().window().maximize();		
		  
	  }
	  
	  
	  @Test
	  public void f() throws Exception {
		  
		  FileInputStream propertyfilepath = new FileInputStream("./src/test/resources/testdata/input.properties");
			
			//load data from property
			
			prop.load(propertyfilepath);
		  		  
		  driver.findElement(FBlogin_Email_Editbox).sendKeys(prop.getProperty("username"));
			driver.findElement(FBlogin_Password_Editbox).sendKeys(prop.getProperty("password"));
			
			
			  Thread.sleep(5000);
			  
			driver.findElement(FBlogin_Submit_button).click();
			
			  Thread.sleep(5000);
			  
	  }
	  
	  

	  @AfterClass
	  public void afterClass() {
		  
		  //driver.close();
		  
	  }

}
