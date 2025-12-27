package com.demowebshop.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath = "//a[@href='/register']")
    WebElement RegisterLink;

    @FindBy (xpath = "//a[@href='/login']")
    WebElement LoginLink;

    public void clickRegisterLink(){
        RegisterLink.click();
    }

    public void clickLoginLink(){
        LoginLink.click();
    }
}
