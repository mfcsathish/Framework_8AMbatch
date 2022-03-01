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
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.objectrepoistory.Locators;
import com.utilities.CommonFunctions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PopupHandle extends CommonFunctions {

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
		
		driver.get("https://stqatools.com/demo/Windows.php");
		driver.manage().window().maximize();
		
		String mainwindow = driver.getWindowHandle();
		System.out.println(mainwindow);
		Thread.sleep(5000);
		
		//Do click on to open new window
		
		clickbyLocator(loc.newwindow);
		Set<String> popup = driver.getWindowHandles();
		System.out.println(popup);
		implicitWait(20);
		
	
		
				for (String abc : popup) {
					
					// validate the window name is parent window /Child window?
					
					if (!mainwindow.equals(abc)) {
						// switch to child window
						driver.switchTo().window(abc);
						Thread.sleep(3000);
						
						// Close my child window
						driver.close();
					}
				}
		

	}

	@AfterClass
	public void afterClass() {

		// driver.close();

	}

}
