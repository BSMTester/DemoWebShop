package com.demowebshop.Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.beust.jcommander.Parameter;

public class BaseTest {

	protected WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
	}
	
	@AfterMethod
	public void tearDown() {
		if(driver != null) {
			driver.quit();
		}
		
	}
}
