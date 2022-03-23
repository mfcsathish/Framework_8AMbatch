package com.testscenarios;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.objectrepoistory.Locators;
import com.utilities.CommonFunctions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Popup_Toyoto_calci extends CommonFunctions {

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
		
		
				driver.get("https://www.toyota.co.uk/");
				driver.manage().window().maximize();

		Thread.sleep(5000);
		
		//click agree
		
		clickbyLocator(loc.agr);
		
		Thread.sleep(2000);
		
	     //click calci
		
		 clickUsingJavaScript(By.xpath("//*[@id='ctaBar']/a[4]/span[1]"));
       
		// String windowHandle = driver.getWindowHandle();
		 
		 // ******Move to next tab to use this code*************************************
		 
		ArrayList<String> allTabs = new ArrayList<String>(driver.getWindowHandles());
			
			driver.switchTo().window(allTabs.get(1));
			
			 // ******Move to next tab to use this code*************************************
			
			  selectByVisibleText(By.id("codeweaversModels"), "Land Cruiser");
		

		Thread.sleep(8000);
		
		
		
		String ftext = driver.findElement(By.xpath("//*[@id='cw_qfq_wrapper']/div/h5")).getText();
		System.out.println("Land Cruiser :" +ftext );
		
		Thread.sleep(5000);
		
		String ftext2 = driver.findElement(By.cssSelector("#codeweaversFinanceTab0 > div.codeweaversFinanceQuote")).getText();
	//String ftext3 = driver.findElement(By.xpath("//*[@id='codeweaversFirstPayment']")).getText();
	System.out.println( ftext2 );

	}

	@AfterClass
	public void afterClass() {

		// driver.close();

	}

}
