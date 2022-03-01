package com.testscenarios;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.objectrepoistory.Locators;
import com.utilities.CommonFunctions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Screenshot_Assingment extends CommonFunctions {

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

		// load data from property

		prop.load(propertyfilepath);
		
		
		// typefb url
		
		driver.get(prop.getProperty("FB_URL"));
		
		driver.manage().window().maximize();	
		
		  sendkeysByAnyLocator(loc.FBlogin_Email_Editbox, prop.getProperty("username"));
		  
		  sendkeysByAnyLocator(loc.FBlogin_Password_Editbox, prop.getProperty("password"));
		
		
		  Thread.sleep(5000);
		  
		  clickbyLocator(loc.FBlogin_Submit_button);
		  
		  Thread.sleep(5000);
		  


			}
		
	@Test
	public void g() throws Exception {

		FileInputStream propertyfilepath = new FileInputStream("./src/test/resources/testdata/input.properties");

		// load data from property

		prop.load(propertyfilepath);

		
		driver.get(prop.getProperty("sqta_url"));
		  
		  driver.manage().window().maximize();
		  
		Thread.sleep(3000);
		
	
			}
	
	@AfterMethod 
	
	public void takescreenshotofeachmethod (ITestResult res) throws Exception {
		
		takeScreenshot(res);
		
		
	}
	

	@AfterClass
	public void afterClass() {

	//driver.quit();

	}

}
