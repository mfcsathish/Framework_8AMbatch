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

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class CallingMultipleVaues_Excelsheet extends CommonFunctions {
	
		
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
	  
	  
	  //Calling from Excel Sheet
	  
	  String path = "C:\\Users\\Sathish SP\\git\\Framework_8AMbatch1\\Hybridframework\\src\\test\\resources\\testdata\\td.xlsx";
		FileInputStream fi = new FileInputStream(path);
		Workbook wb = new XSSFWorkbook(fi);
		Sheet s = wb.getSheet("login");
		
		Row r = s.getRow(1);
		Cell c = r.getCell(0);
		String un = c.getStringCellValue(); //getting username form excel (un)
		
		Cell c2 = r.getCell(1);
		String pw = c2.getStringCellValue(); //getting password from excel (pw)
	  
	  sendkeysByAnyLocator(loc.FBlogin_Email_Editbox, un);
	  
	  sendkeysByAnyLocator(loc.FBlogin_Password_Editbox, pw);
	  
	  expicitwait(loc.FBlogin_Submit_button);
	  
	  clickbyLocator(loc.FBlogin_Submit_button);
	  
	  Thread.sleep(5000);
	
	  // Validate error Msg
	  
	  String errmsg = driver.findElement(By.xpath("//*[@id='loginform']/div[2]/div[2]/a")).getText();
	  System.out.println(errmsg);
	  
	  if(errmsg.contains("Forgotten password") || errmsg.contains("Find your account and login")){
	   System.out.println("Error Message displayed :Given credentials are invalid");
	  }else {
		  
		  System.out.println("Error Message not displayed :Given credentials are valid");
	  }
	  
	  
	  
  }


  @AfterClass
  public void afterClass() {
	  
	  //driver.close();
	  
	  
  }

}
