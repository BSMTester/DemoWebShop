package com.demowebshop.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.demowebshop.Base.BaseTest;
import com.demowebshop.PageObjects.BasePage;
import com.demowebshop.PageObjects.LoginPage;
import com.demowebshop.Utilities.Readconfig;

public class TC_LoginTest_002 extends BaseTest {

	@Test
	public void loginTest() {
		Readconfig readconfig = new Readconfig();
		driver.get(readconfig.getApplicationUrl());
		BasePage basePage = new BasePage(driver);
		basePage.clickLoginLink();
		LoginPage loginPage = new LoginPage(driver);
		String emailid = readconfig.getLoginEmail();
		String password = readconfig.getLoginPassword();
		loginPage.enterLoginEmail(emailid);
		loginPage.enterLoginPassword(password);
		loginPage.clickLoginButton();
		String ExpectedResult = readconfig.getApplicationUrl()+"/";
		String ActualResult = driver.getCurrentUrl();
		Assert.assertEquals(ExpectedResult, ActualResult, "Expected result and Actual Result are not match");
	}
}