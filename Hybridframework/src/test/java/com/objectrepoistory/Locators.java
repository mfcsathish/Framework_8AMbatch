package com.objectrepoistory;

import org.openqa.selenium.By;

public class Locators {
	
	public final By FBlogin_Email_Editbox = By.name("email");
	public final By FBlogin_Password_Editbox = By.name("pass");
	public final By FBlogin_Submit_button = By.name("login");
	
	//sqta locators
	
	public final By deleteicon = By.xpath("//table/tbody/tr[2]/td[6]/button");
	public final By closeicon = By.xpath("(//button[text()='close'][2])");
	
	//https://stqatools.com/demo/Windows.php
	public final By newwindow = By.xpath("/html/body/div[1]/div/div[2]/a[2]/button");
	
	//https://demoqa.com/browser-windows
	
	public final By nwindow = By.xpath("//*[@id='windowButton']");
	public final By ntab = By.xpath("//*[@id='tabButton']");
	

}
//Thread.sleep(5000);