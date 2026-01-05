package com.demowebshop.Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.demowebshop.Utilities.Readconfig;

public class BaseTest {

	public WebDriver driver;
	
	@BeforeMethod(alwaysRun = true)
	public void setup() {
		
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		Readconfig readconfig = new Readconfig();
		driver.get(readconfig.getApplicationUrl());
	}
	
	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		if(driver != null) {
			driver.quit();
		}
		
	}
}
