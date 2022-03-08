package com.testscenarios;

import java.io.FileInputStream;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.objectrepoistory.Locators;
import com.utilities.CommonFunctions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Click_UsingJavaScript extends CommonFunctions {

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

		// read the data from property file

		FileInputStream propertyfilepath = new FileInputStream("./src/test/resources/testdata/input.properties");

		// load data from property

		prop.load(propertyfilepath);
		
		driver.get(prop.getProperty("sqta_url"));
		  
		  driver.manage().window().maximize();
	
		
//		WebElement element = driver.findElement(loc.deleteicon);
//		highlightElement(element);
//		JavascriptExecutor executor = (JavascriptExecutor) driver;		
//		executor.executeScript("arguments[0].click();", element);

		//driver.findElement(deleteicon).click();
		
		  
		  clickUsingJavaScript(By.xpath("//table/tbody/tr[2]/td[6]/button"));

		Thread.sleep(2000);

		driver.findElement(loc.closeicon).click();

		Thread.sleep(5000);

	}

	@AfterClass
	public void afterClass() {

		// driver.quit();

	}

}
