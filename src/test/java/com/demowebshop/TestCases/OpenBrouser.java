package com.demowebshop.TestCases;

import org.testng.annotations.Test;

import com.demowebshop.Base.BaseTest;

public class OpenBrouser extends BaseTest{
	
	@Test
	public void openFirefox() {
		driver.get("https://demowebshop.tricentis.com/");
	}

}
