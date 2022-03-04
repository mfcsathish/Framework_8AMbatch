package com.testscenarios;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.objectrepoistory.Locators;
import com.utilities.CommonFunctions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Iframe_Click_Operator extends CommonFunctions {

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
				driver.get("http://mis.nyiso.com/public/");
				driver.manage().window().maximize();

		Thread.sleep(5000);
	
		// Iframe click operator script
		
		loopAllFramesForElement(loc.zonal);
		clickUsingJavaScript(loc.zonal);
		//clickbyLocator(loc.zonal);
		 
		Thread.sleep(2000);
		
		loopAllFramesForElement(By.xpath("/html/body/table/tbody/tr[8]/td[2]/span"));
		System.out.println(driver.findElement(By.xpath("/html/body/table/tbody/tr[8]/td[2]/span")).getText());
		
	}
		

	

	@AfterClass
	public void afterClass() {

		// driver.close();

	}

}
