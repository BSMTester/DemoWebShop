package com.demowebshop.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;
    
    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @FindBy(id="Email")
    WebElement emailTestBox;

    @FindBy(name = "Password")
    WebElement passwordTextBox;

    @FindBy(xpath = "//input[@value='Log in']")
    WebElement LoginButton;

    @FindBy(xpath = "//span[contains(text(), 'Login was unsuccessful.')]")
    WebElement LoginError;

    @FindBy(xpath = "//span[@for='Email']")
    WebElement invalidEmailErr;

    public void enterLoginEmail(String LoginmailId){
        wait.until(ExpectedConditions.visibilityOf(emailTestBox));
        emailTestBox.clear();
        emailTestBox.sendKeys(LoginmailId);
    }

    public void enterLoginPassword(String LoginPassword){
        wait.until(ExpectedConditions.visibilityOf(passwordTextBox));
        passwordTextBox.clear();
        passwordTextBox.sendKeys(LoginPassword);
    }

    public void clickLoginButton(){
    	wait.until(ExpectedConditions.elementToBeClickable(LoginButton));
        LoginButton.click();
    }

    public String getLoginErrMsg(){
        //wait.until(ExpectedConditions.visibilityOf(LoginError));
        return LoginError.getText();
    }

    public String getInvalidMailErrMsg(){
    //    wait.until(ExpectedConditions.elementToBeSelected(invalidEmailErr));
        return invalidEmailErr.getText();
    }

    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }

}