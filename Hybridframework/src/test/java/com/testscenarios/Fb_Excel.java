package com.testscenarios;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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

public class Fb_Excel {

	

	@Test
	public void f() throws Exception {
    // Read test data from Excel 
		String path = "./src/test/resources/testdata/td.xlsx";
		FileInputStream fi = new FileInputStream(path);
		Workbook wb = new XSSFWorkbook(fi);
		//Sheet s = wb.getSheetAt(0);
		Sheet s = wb.getSheet("test");
		Row r = s.getRow(1);
		Cell c = r.getCell(0);
		System.out.println(c.getStringCellValue());
		
	}

	

}
