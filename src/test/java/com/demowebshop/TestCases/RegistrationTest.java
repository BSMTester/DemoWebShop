package com.demowebshop.TestCases;

import com.demowebshop.Base.BaseTest;
import com.demowebshop.PageObjects.RegistorPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTest extends BaseTest {

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
}
