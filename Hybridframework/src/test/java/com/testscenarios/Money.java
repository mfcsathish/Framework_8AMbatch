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

public class Money {

	public static void main(String[] args) throws IOException, Exception {
		
		WebDriver driver;
		
		// TODO Auto-generated method stub
		
		 WebDriverManager.chromedriver().setup();
		  driver = new ChromeDriver();
		  driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html#result");
		  driver.manage().window().maximize();
		  
		  FileInputStream file = new FileInputStream("./src/test/resources/testdata/td.xlsx");
		  XSSFWorkbook wb = new XSSFWorkbook(file);
		  XSSFSheet sheet = wb.getSheet("Money");
		  
		  int rowcount = sheet.getLastRowNum();
		  
		  for(int i=1;i<=rowcount;i++)
			  
		  {
			  
			  XSSFRow row = sheet.getRow(i);
			  
			  XSSFCell princ = row.getCell(0);
			  int principle = (int)princ.getNumericCellValue();
			  
			  XSSFCell roi = row.getCell(1);
			  int rateofinterest = (int)roi.getNumericCellValue();
			  
			  XSSFCell poy = row.getCell(2);
			  int period = (int)poy.getNumericCellValue();
			  
			  XSSFCell fer = row.getCell(3);
			  String frequency = fer.getStringCellValue();
			  
			  XSSFCell mv = row.getCell(4);
			  int maturity= (int)mv.getNumericCellValue();
			  
			  driver.findElement(By.name("principal")).sendKeys(String.valueOf(principle));
			  
			  driver.findElement(By.name("interest")).sendKeys(String.valueOf(rateofinterest));
			  
			  driver.findElement(By.name("tenure")).sendKeys(String.valueOf(period));
			  
			  Select periodcombo = new Select (driver.findElement(By.name("tenurePeriod")));
			  periodcombo.selectByVisibleText("year(s)");			  
				  
			  Select frequ = new Select (driver.findElement(By.name("frequency")));
			  frequ.selectByVisibleText("Simple Interest");
			  
			  Thread.sleep(2000);
			  
			 ////*[@id="fdMatVal"]/div[2]/a[1]/img
			  
			  driver.findElement(By.xpath("//*[@id='fdMatVal']/div[2]/a[1]/img")).click();
			  
			  Thread.sleep(5000);
			  
			  String act_value = driver.findElement(By.xpath("//*[@id='resp_matval']/strong")).getText();
			  
			  Thread.sleep(2000);
			  
			  // convert String to Interger ---> Interger.parseInt()
			  
			  // conver String to Double --- >Double.parseDouble()
			  
			  if((Double.parseDouble(act_value)) == maturity)
				  
			  {
				 
				  System.out.println("Test is passed");
				  
			  }
			  
			  else
				 
				  System.out.println("Test is failed");		
			  
			  driver.findElement(By.xpath("//*[@id='fdMatVal']/div[2]/a[2]/img")).click();
			  
		  }
		  

		  driver.close();
		  driver.quit();
		  
		  
	}

}
