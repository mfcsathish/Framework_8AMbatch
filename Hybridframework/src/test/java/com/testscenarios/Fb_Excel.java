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
		String path = "C:\\Users\\Sathish SP\\git\\8ambatch\\Hybridframework\\src\\test\\resources\\testdata\\td.xlsx";
		FileInputStream fi = new FileInputStream(path);
		Workbook wb = new XSSFWorkbook(fi);
		// Sheet s = wb.getSheetAt(0);
		Sheet s = wb.getSheet("login");
		
		//Row r = s.getRow(3);
//		Cell c = r.getCell(0);
//		System.out.println(c.getStringCellValue());

		int lastRow = s.getLastRowNum();
		System.out.println("Last Row Number " + lastRow);

//		int lastCell = r.getLastCellNum();
//		System.out.println("Last Cell Number" +lastCell);
		
		for (int i = 0; i <= lastRow; i++) {
			Row row = s.getRow(i);
			int lastCell = row.getLastCellNum();
			
			for (int j = 0; j < lastCell; j++ ) {
				Cell cell = row.getCell(j);
				String value = cell.getStringCellValue();
				System.out.println(value);
		
			}
			
			System.out.println();
		}

	}

}
