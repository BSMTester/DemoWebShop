package com.demowebshop.Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.demowebshop.Utilities.Readconfig;

public class BaseTest {

	public WebDriver driver;
	
	@BeforeClass
	public void setup() {
		
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		Readconfig readconfig = new Readconfig();
		driver.get(readconfig.getApplicationUrl());
	}
	
	@AfterClass
	public void tearDown() {
		if(driver != null) {
			driver.quit();
		}
		
	}
}
