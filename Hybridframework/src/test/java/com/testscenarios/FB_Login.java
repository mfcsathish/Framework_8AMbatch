package com.testscenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.objectrepoistory.Locators;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FB_Login extends Locators {
	
	WebDriver driver;
		 
	  @BeforeClass
	  public void beforeClass() {
		  WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
		// type jsut recharge url	
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();		
		  
	  }
	  
	  
	  @Test
	  public void f() throws Exception {
		  		  
		  driver.findElement(FBlogin_Email_Editbox).sendKeys("mfc.sathish@gmail.com");
			driver.findElement(FBlogin_Password_Editbox).sendKeys("Br439476#");
			
			
			  Thread.sleep(5000);
			  
			driver.findElement(FBlogin_Submit_button).click();
			
			  Thread.sleep(5000);
			  
	  }
	  
	  

	  @AfterClass
	  public void afterClass() {
		  
		  driver.close();
		  
	  }

}
