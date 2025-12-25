package com.demowebshop.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistorPage {
	
	WebDriver driver;
	WebDriverWait wait;

	public RegistorPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	@FindBy(id="gender-male")
	WebElement genderMale;

	@FindBy (id = "gender-female")
	WebElement getGender_female;

	@FindBy (id="FirstName")
	WebElement FirstName;

	@FindBy (id = "LastName")
	WebElement LastName;

	@FindBy (id = "Email")
	WebElement email;

	@FindBy (id="Password")
	WebElement password;

	@FindBy(id = "ConfirmPassword")
	WebElement confirmPassword;

	@FindBy(id = "register-button")
	WebElement Register_button;

	@FindBy(xpath = "//h1[text()='Register']")
	WebElement registrationSuccessfulMsg;

	@FindBy(xpath = "//span[@for='Password']")
	WebElement passwordErrMsg;
	
	
	public void selectGender(String gender){
		if(gender.equalsIgnoreCase("male")){
			wait.until(ExpectedConditions.elementToBeClickable(genderMale)).click();
		}else if(gender.equalsIgnoreCase("female")){
			wait.until(ExpectedConditions.elementToBeClickable(getGender_female)).click();
		}
	}

	public void enterFirstName(String fname){
		wait.until(ExpectedConditions.visibilityOf(FirstName));
		FirstName.clear();
		FirstName.sendKeys(fname);
	}

	public void enterLastName(String lname){
		wait.until(ExpectedConditions.visibilityOf(LastName));
		LastName.clear();
		LastName.sendKeys(lname);
	}

	public void enterEmail(String emailId){
		wait.until(ExpectedConditions.visibilityOf(email));
		email.clear();
		email.sendKeys(emailId);
	}

	public void enterPassWord(String pasword){
		wait.until(ExpectedConditions.visibilityOf(password));
		password.clear();
		password.sendKeys(pasword);
	}

	public void enterConfirmPassword(String cpasword){
		wait.until(ExpectedConditions.visibilityOf(confirmPassword));
		confirmPassword.clear();
		confirmPassword.sendKeys(cpasword);
	}

	public void clickRegisterButton(){
		wait.until(ExpectedConditions.elementToBeClickable(Register_button));
		Register_button.click();
	}
	
	public String getPaswordLengthErrMessage() {
		return passwordErrMsg.getText();
	}

	public void registerUser(String gender, String fname, String lname, String emailId,
							 String pasword, String cpasword){
		selectGender(gender);
		enterFirstName(fname);
		enterLastName(lname);
		enterEmail(emailId);
		enterPassWord(pasword);
		enterConfirmPassword(cpasword);
	}

	public String getRegistrationSuccussfulMessgae(){
		return  wait.until(ExpectedConditions.visibilityOf(registrationSuccessfulMsg)).getText();
	}

	public void mandatoryFiledsResgisterUser(String fname, String lname, String emailId,
											 String pasword, String cpasword){
		enterFirstName(fname);
		enterLastName(lname);
		enterEmail(emailId);
		enterPassWord(pasword);
		enterConfirmPassword(cpasword);
	}
}
