package com.utilities;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CommonFunctions extends BaseClass {
	
	/***************** browser **************************************/

	public void chromeBrowserLaunch() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	public void firefoxBrowserLaunch() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
	}

	public void edgeBrowserLaunch() {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().window().maximize();
	}

	public void operaBrowserLaunch() {
		WebDriverManager.operadriver().setup();
		driver = new OperaDriver();
		driver.manage().window().maximize();
	}

	/***************** SendKeys **************************************/

	public void sendkeysByAnyLocator(By locator, String inputdata) {

		try {
			WebElement ele = driver.findElement(locator);
			highlightElement(ele);

				if (ele.isDisplayed() && ele.isEnabled()) {

				ele.clear();

				ele.sendKeys(inputdata);

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	/***************** Click **************************************/

	public void clickbyLocator(By locator) {

		try {
			WebElement ele = driver.findElement(locator);
			highlightElement(ele);

				if (ele.isDisplayed() && ele.isEnabled()) {

				ele.click();

				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	/************* Webdriver Wait ********************************/
	
	public void expicitwait(By locator) {
	  
	  WebElement loginbutton = driver.findElement(locator);	 
	  WebDriverWait ww = new WebDriverWait(driver, Duration.ofSeconds(25));
	  ww.until(ExpectedConditions.elementToBeClickable(loginbutton));
	
	}
	/******************************************************************/
	
	public void implicitWait(int time) {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
		System.out.println("********Implicit Wait method is used**********");
	}
	



/*********** Click Operation by Java Script **********/

public void clickUsingJavaScript(By locator) throws Exception {
	WebElement element = driver.findElement(locator);
	JavascriptExecutor executor = (JavascriptExecutor) driver;
	highlightElement(element);
	executor.executeScript("arguments[0].click();", element);

}

public void highlightElement(WebElement element) throws InterruptedException {
	((JavascriptExecutor) driver).executeScript("arguments[0].style.border='6px groove green'", element);
	Thread.sleep(1000);
	((JavascriptExecutor) driver).executeScript("arguments[0].style.border=''", element);

}

/*********** timestamp **********/
public String timestamp() {
	Date d = new Date();
	DateFormat df = new SimpleDateFormat("ddMMMyyy_HHmmss");
	String timeTamp = df.format(d);
	return timeTamp;
}

/****** takescreenshot ***********/
 
public void takeScreenshot() throws Exception {
	File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	String screenshotPath = ".\\screenshots\\";
	FileHandler.copy(scrFile, new File(screenshotPath + "abi" + timestamp() + ".PNG"));
	System.out.println("Screenshot taken*** ");
}

/****** takescreenshot and capture with folder name, clas name and method name***********/

public void takeScreenshot(ITestResult res) throws Exception {
	projectDir = System.getProperty("user.dir");
	screenshotPath = projectDir + "\\screenshots\\";
	className = res.getTestClass().getName().trim();
	methodName = res.getName().trim();
	// STATUS_PackageName.ClassName_MethodName_Timestamp.PNG
	if (res.getStatus() == ITestResult.SUCCESS) {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(scrFile,
				new File(screenshotPath + "PASS_" + className + "_" + methodName + "_" + timestamp() + ".PNG"));
	}
	if (res.getStatus() == ITestResult.FAILURE) {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(scrFile,
				new File(screenshotPath + "FAIL_" + className + "_" + methodName + "_" + timestamp() + ".PNG"));
	}

}

/****************** Dropdown selection **************************************/

public void selectByVisibleText(By locater, String visibleText) {

	WebElement element = driver.findElement(locater);
	if (element.isDisplayed()) {
		if (element.isEnabled()) {
			Select dropdown = new Select(element);
			dropdown.selectByVisibleText(visibleText);
		} else {
			System.out.println("The webelement is NOT Enabled, please check**************");
		}
	} else {
		System.out.println("The webelement is NOT displayed, please check**************");
	}

}

public void selectByIndex(By locater, int index) {
	WebElement element = driver.findElement(locater);
	if (element.isDisplayed()) {
		// isEnabled()
		if (element.isEnabled()) {
			Select dropdown = new Select(element);
			dropdown.selectByIndex(index);
		} else {
			System.out.println("The webelement is NOT Enabled, please check**************");
		}
	} else {
		System.out.println("The webelement is NOT displayed, please check**************");
	}

}

public void selectByValue(By locater, String value) {
	WebElement element = driver.findElement(locater);
	if (element.isDisplayed()) {
		// isEnabled()
		if (element.isEnabled()) {
			Select dropdown = new Select(element);
			dropdown.selectByValue(value);
		} else {
			System.out.println("The webelement is NOT Enabled, please check**************");
		}
	} else {
		System.out.println("The webelement is NOT displayed, please check**************");
	}

}

public void printAllDropdownValues(By locater) {
	WebElement element = driver.findElement(locater);

	if (element.isDisplayed()) {
		// isEnabled()
		if (element.isEnabled()) {
			Select dropdown = new Select(element);
			List<WebElement> dropdownValues = dropdown.getOptions();
			// Print the size of dropdown values
			System.out.println(dropdownValues.size());
			// Print the dropdown values
			for (WebElement allvalue : dropdownValues) {
				System.out.println(allvalue.getText());
			}
		} else {
			System.out.println("The webelement is NOT Enabled, please check**************");
		}
	} else {
		System.out.println("The webelement is NOT displayed, please check**************");
	}

}

public void selectCustomiseOptionFromTheDropdownValues(By locater, String visibleText) {
	WebElement element = driver.findElement(locater);
	if (element.isDisplayed()) {
		// isEnabled()
		if (element.isEnabled()) {

			Select dropdown = new Select(element);
			List<WebElement> dropdownValues = dropdown.getOptions();
			// Print the size of dropdown values
			System.out.println(dropdownValues.size());
			// Print the dropdown values
			for (int i = 0; i < dropdownValues.size(); i++) {
				System.out.println(dropdownValues.get(i).getText());

				// Select Aug option from the dropdown
				if (dropdownValues.get(i).getText().equals(visibleText)) {
					dropdown.selectByIndex(i);
					break;
				}
			}

		} else {
			System.out.println("The webelement is NOT Enabled, please check**************");
		}
	} else {
		System.out.println("The webelement is NOT displayed, please check**************");
	}

}




}
