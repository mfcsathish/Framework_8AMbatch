package com.testscenarios;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.*;
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

public class ReadDatafromExcel2_Simple  {
	
	public static void main(String[] args) throws IOException, Exception {
	
 
	WebDriver driver;
	
	// TODO Auto-generated method stub
	
	 WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
	  driver.get("https://tirupatibalaji.ap.gov.in/#/registration");
	  driver.manage().window().maximize();
	  
	  FileInputStream file = new FileInputStream("./src/test/resources/testdata/td.xlsx");
	  XSSFWorkbook wb = new XSSFWorkbook(file);
	  XSSFSheet sheet = wb.getSheet("Recharge");
	  
	  int rowcount = sheet.getLastRowNum();
	  
	  for(int i=1;i<=rowcount;i++)
		  
	  {
		  
		  XSSFRow row = sheet.getRow(i);
		  
		  XSSFCell namc = row.getCell(0);
		  String name = namc.getStringCellValue();
		  
					  
		  XSSFCell mobc = row.getCell(1);
		 Double mobile = (Double)mobc.getNumericCellValue();
		  
		  XSSFCell emac = row.getCell(2);
		 String email = emac.getStringCellValue();
		  
		  XSSFCell pwc = row.getCell(3);
		  String password =pwc.getStringCellValue();
		  
				
		//Registration Process
		
		
		
		driver.findElement(By.name("fName")).sendKeys(String.valueOf(name));
				
		driver.findElement(By.name("lName")).sendKeys(String.valueOf(name));
		
		driver.findElement(By.name("mobNo")).sendKeys(String.valueOf(mobile));
		//signup_email
		
		driver.findElement(By.name("emailId")).sendKeys(String.valueOf(email));
		//signup_password
		
		driver.findElement(By.name("password")).sendKeys(String.valueOf(password));
		//checkbox
		
		driver.findElement(By.name("repassword")).sendKeys(String.valueOf(password));
		
				
		Thread.sleep(5000);
		

		driver.findElement(By.name("fName")).clear();
		
		driver.findElement(By.name("lName")).clear();
		
		driver.findElement(By.name("mobNo")).clear();
		//signup_email
		
		driver.findElement(By.name("emailId")).clear();
		//signup_password
		
		driver.findElement(By.name("password")).clear();
		//checkbox
		
		driver.findElement(By.name("repassword")).clear();
		
		
		}
		
		
		
	}

}
	
// Workbook wb = new XSSFWorkbook(fi);
// Sheet s = wb.getSheet("login");

//		Row r = s.getRow(3);
//		Cell c = r.getCell(0);
//		System.out.println(c.getStringCellValue());

//		int lastRow = s.getLastRowNum();
//		System.out.println("Last Row Number " + lastRow);

//		int lastCell = r.getLastCellNum();
//		System.out.println("Last Cell Number" +lastCell);
//		
//		for (int i = 0; i <= lastRow; i++) {
//			Row row = s.getRow(i);
//			int lastCell = row.getLastCellNum();
//			
//			for (int j = 0; j < lastCell; j++ ) {
//				Cell cell = row.getCell(j);
//				String value = cell.getStringCellValue();
//				System.out.println(value);
//		
//			}
//			
//			System.out.println();
//		}
