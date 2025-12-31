package com.demowebshop.TestCases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.demowebshop.Base.BaseTest;
import com.demowebshop.Dataproviders.LoginDataProvider;
import com.demowebshop.PageObjects.BasePage;
import com.demowebshop.PageObjects.LoginPage;

import junit.framework.Assert;

public class LoginTest extends BaseTest{

	@BeforeMethod
	public void beforLoginTest() {
		BasePage basePage = new BasePage(driver);
		basePage.clickLoginLink();
	}
	
	@Test(dataProvider = "LoginData", dataProviderClass = LoginDataProvider.class)
	public void tc_LoginWithDataProvider(String emaiId, String password, String ExpectedResult) {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterLoginEmail(emaiId);
		loginPage.enterLoginPassword(password);
		loginPage.clickLoginButton();
		String ActualResult = loginPage.getLoginErrMsg();
		System.out.println(ActualResult+" ==> "+ExpectedResult);
		Assert.assertEquals(ExpectedResult, ActualResult);
		
	}
}
