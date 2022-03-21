package com.testscenarios;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RechargePhoneNumber_usingExcel {

	public static void main(String[] args) throws IOException, Exception {
		
		WebDriver driver;
		
		// TODO Auto-generated method stub
		
		 WebDriverManager.chromedriver().setup();
		  driver = new ChromeDriver();
		  driver.get("https://www.justrechargeit.com/SignUp.aspx");
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
			  int mobile = (int)mobc.getNumericCellValue();
			  
			  XSSFCell emac = row.getCell(2);
			 String email = emac.getStringCellValue();
			  
			  XSSFCell pwc = row.getCell(3);
			  String password =pwc.getStringCellValue();
			  
					  
			  driver.findElement(By.name("signup_name")).sendKeys(String.valueOf(name));
			  
			  driver.findElement(By.name("signup_mobileno")).sendKeys(String.valueOf(mobile));
			  
			  driver.findElement(By.name("signup_email")).sendKeys(String.valueOf(email));
			  
			  driver.findElement(By.name("signup_password")).sendKeys(String.valueOf(password));
			  
			  Thread.sleep(2000);
			  
				driver.findElement(By.id("checkbox")).click();
				//imgbtnSubmit
				
				driver.findElement(By.name("imgbtnSubmit")).click(); //register button
				
				Thread.sleep(2000);
		  }
		  
		  
		  driver.findElement(By.name("signup_name")).clear();
			//name clear
			
			driver.findElement(By.name("signup_mobileno")).clear();
			//mobile no clear
			
			driver.findElement(By.name("signup_email")).clear();
			//email clear
			
			driver.findElement(By.name("signup_password")).clear();
			//pwd clear
			

		  driver.close();
		  
		  driver.quit();
		  
		  
	}

}
