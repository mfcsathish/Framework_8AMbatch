package com.testscenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.objectrepoistory.Locators;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DateandTime  {
	
	WebDriver driver;
		 
	  @BeforeClass
	  public void beforeClass() {
		  WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
		// type jsut recharge url	
		driver.get("https://www.timeanddate.com/weather/india");
		driver.manage().window().maximize();		
		  
	  }
	  
	  
	  @Test
	  public void f() throws Exception {		  
		
		  
		  String state = driver.findElement(By.xpath("//table/tbody/tr[14]/td[5]/a")).getText();		  
		  String tome = driver.findElement(By.xpath("//*[@id=\"p140\"]")).getText();		  
		  String gtxt = driver.findElement(By.xpath("//table/tbody/tr[14]/td[8]")).getText();
		
		  System.out.println(state+ ":" +tome+ ":" +gtxt );
		
		
			
			  Thread.sleep(5000);
			  
	  }
	  
	  

	  @AfterClass
	  public void afterClass() {
		  
		  //driver.close();
		  
	  }

}
