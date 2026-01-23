package com.demowebshop.TestCases;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import com.demowebshop.Base.BaseTest;
import com.demowebshop.PageObjects.BasePage;
import com.demowebshop.PageObjects.CustomerInfoPage;
import com.demowebshop.PageObjects.HomePage;
import com.demowebshop.PageObjects.LoginPage;
import com.demowebshop.Utilities.Readconfig;
import junit.framework.Assert;

public class TC_ViewProfileTest_004 extends BaseTest{

	//@Test (description = "DEM-286", dependsOnGroups = "login") 
//* dependsonMethods and Groups are not working in UI in different classes, but same class have methods, it is working
	@Test (description = "DEM-286", groups = "login")
	public void viewProfileTest() {
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
		//----
		HomePage hp = new HomePage(driver);
		JavascriptExecutor js =  (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 500);");
		hp.clickMyAccountLink();
		CustomerInfoPage cip = new CustomerInfoPage(driver);
		String ActualGender = cip.getGendor();
		String ActualFirstName = cip.getFirstName();
		String ActualLastName = cip.getLastName();
		String ActualEmail = cip.getEmail();
		Readconfig config = new Readconfig();
		String ExpectGender = config.getMaleGendor();
		String ExpectFirstName =  config.getLoginFirstName();
		String ExpectLastName = config.getLoginLastName();
		String ExpectEmail = config.getLoginEmail();
		
		Assert.assertEquals(ActualGender, ExpectGender);
		Assert.assertEquals(ActualFirstName, ExpectFirstName);
		Assert.assertEquals(ActualLastName, ExpectLastName);
		Assert.assertEquals(ActualEmail, ExpectEmail); 
	}
}
