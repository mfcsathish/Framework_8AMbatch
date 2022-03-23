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

public class JavaScriptUtil extends CommonFunctions {

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

		driver.get("https://www.twoplugs.com/");

		driver.manage().window().maximize();

		// Flashing the button using the script

		// WebElement blink = driver.findElement(By.xpath("/html/body/div/header/div/ul/li[2]/a"));
		// flash(blink,driver);

		 Thread.sleep(2000);

		// Scroll to page till we find the element
	  
		//WebElement img = driver.findElement(By.xpath("//*[@id='threeColumn']/li[4]/div[1]/span"));

		//scrolview(img, driver);
		
		 //Thread.sleep(5000);

	scrolldownpage(driver);

	}

	@AfterClass
	public void afterClass() {

		// driver.quit();

	}

}
