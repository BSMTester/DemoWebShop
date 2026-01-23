package com.demowebshop.Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class BaseTest {

	protected  WebDriver driver;
	
	@BeforeSuite(alwaysRun = true)
	public void setup() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
	}
	
	@AfterSuite(alwaysRun = true)
	public void tearDown() {
		if(driver != null) {
			driver.quit();
		}
	}
	
}
