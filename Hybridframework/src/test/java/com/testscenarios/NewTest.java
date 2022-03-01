package com.testscenarios;

import org.testng.annotations.Test;

import com.objectrepoistory.Locators;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class NewTest extends Locators {
	
	WebDriver driver;
	 
	Properties prop = new Properties();
  @Test
  public void f() throws Exception {
	  
	  FileInputStream propertyfilepath = new FileInputStream("./src/test/resources/testdata/input.properties");
		
		//load data from property
		
		prop.load(propertyfilepath);	  		  

		driver.findElement(deleteicon).click();
		

		Thread.sleep(2000);
					
		driver.findElement(closeicon).click();
		
		Thread.sleep(5000);
  }
  
  
  @BeforeClass
  public void beforeClass() throws Exception {
	  
	  
	  WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		//read the data from property file
		
		
		FileInputStream propertyfilepath = new FileInputStream("./src/test/resources/testdata/input.properties");
		
		//load data from property
		
		prop.load(propertyfilepath);
		
		
	// typefb url	
		
	driver.get(prop.getProperty("sqta_url"));
			
	driver.manage().window().maximize();		
  }

  @AfterClass
  public void afterClass() {
  }

}
