package com.demowebshop.TestCases;

import com.demowebshop.Base.BaseTest;
import com.demowebshop.PageObjects.BasePage;
import com.demowebshop.PageObjects.RegistorPage;
import com.demowebshop.Utilities.Readconfig;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTest extends BaseTest {

	@BeforeMethod
	public void beforeRegistrationTest() {
		BasePage bp = new BasePage(driver);
		bp.clickRegisterLink();
	}

    @Test(description = "XRAY-DEM-67", priority = 1)
    public void TC_Register_with_valid_data(){
        RegistorPage registorPage = new RegistorPage(driver);
        registorPage.registerUser("male","Rama", "Krishna", "ramakrishna"+System.currentTimeMillis()+"@gmail.com", "Password@123", "Password@123");
        Assert.assertEquals(registorPage.getRegistrationSuccussfulMessgae(), "Register", "user not Registered"); ;
    }

    @Test(description = "XRAY-DEM-79",   priority = 2)
    public void TC_All_MandatoryFieldsFilledCorrectly(){
        RegistorPage registorPage = new RegistorPage(driver);
        registorPage.mandatoryFiledsResgisterUser("Rama", "Krishna", "ramakrish"+System.currentTimeMillis()+"@gmail.com","Tester@123", "Tester@123");
        Assert.assertEquals(registorPage.getRegistrationSuccussfulMessgae(), "Register", "user not Registered");
    }

    @Test(description = "XRAY-DEM-80", priority = 3)
    public void tc_ValidEmailIdandInvalidPassword() {
    	RegistorPage registorPage = new RegistorPage(driver);
    	registorPage.selectGender("femaile");
    	registorPage.enterFirstName("Srinivas");
    	registorPage.enterLastName("venkat");
    	registorPage.enterEmail("venkatSrinivas89@gmail.com");
    	registorPage.enterPassWord("Srini");
    	registorPage.enterConfirmPassword("Srini");
    	registorPage.clickRegisterButton();
    	String passErrMsg = registorPage.getPaswordLengthErrMessage();
    	String expectPassErrorMsg = "The password should have at least 6 characters.";
    	Assert.assertEquals(passErrMsg, expectPassErrorMsg, "Password filed error not displayed");
    }

	@Test(description = "XRAY-DEM-81", priority = 4)
	public void tc_InvalidEmailandValidPassword(){
		RegistorPage registorPage = new RegistorPage(driver);
		Readconfig readconfig = new Readconfig();
		registorPage.selectGender(readconfig.getFemaleGendor());
		registorPage.enterFirstName(readconfig.getFirstName());
		registorPage.enterLastName(readconfig.getLastName());
		registorPage.enterEmail(readconfig.getInvalidEmail());
		registorPage.enterPassWord(readconfig.getPassword());
		registorPage.enterConfirmPassword(readconfig.getConfirmPassword());
		registorPage.clickRegisterButton();
		String ExpectedResult = readconfig.getEmailErrMsg();
<<<<<<< Updated upstream
		String ActualResult = registorPage.getEmailErrMessage();
=======
		String ActualResult = registorPage.getEmailErrmsg();
>>>>>>> Stashed changes
		Assert.assertEquals(ActualResult,ExpectedResult,"Invalid email error" );
	}
}
