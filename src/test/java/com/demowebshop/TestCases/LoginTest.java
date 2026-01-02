package com.demowebshop.TestCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.demowebshop.Base.BaseTest;
import com.demowebshop.Dataproviders.LoginDataProvider;
import com.demowebshop.PageObjects.BasePage;
import com.demowebshop.PageObjects.LoginPage;

import junit.framework.Assert;

public class LoginTest extends BaseTest{

	@BeforeClass
	public void beforLoginTest() {
		BasePage basePage = new BasePage(driver);
		basePage.clickLoginLink();
	}
	
	@Test(dataProvider = "LoginData", dataProviderClass = LoginDataProvider.class)
	public void tc_LoginWithDataProvider(String emaiId, String password, String ExpectedResult, String ExpectedMessgae) {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterLoginEmail(emaiId);
		loginPage.enterLoginPassword(password);
		loginPage.clickLoginButton();
		if(ExpectedResult.equalsIgnoreCase("Success")) {
			Assert.assertEquals(ExpectedMessgae, loginPage.getCurrentUrl());
		}else if(ExpectedResult.equalsIgnoreCase("Error")){
			String ActualResult = loginPage.getLoginErrMsg();
			Assert.assertEquals(ExpectedMessgae, ActualResult);
		}
	}
}
