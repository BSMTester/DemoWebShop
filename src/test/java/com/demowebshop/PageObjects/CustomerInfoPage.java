package com.demowebshop.PageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomerInfoPage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public CustomerInfoPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	@FindBy(xpath = "//input[@value='M']")
	WebElement maleGender;
	
	@FindBy(xpath = "//input[@value='F']")
	WebElement femaleGencer;
		
		@FindBy(id = "FirstName")
		WebElement firstName;
		
	public String  getFirstName() {
		wait.until(ExpectedConditions.visibilityOf(firstName));
		return firstName.getAttribute("value");
	}
	
	@FindBy(id = "LastName")
	WebElement lastName;
	
	public String  getLastName() {
		wait.until(ExpectedConditions.visibilityOf(lastName));
		return lastName.getAttribute("value");
	}
	
	@FindBy(id = "Email")
	WebElement email;
	
	public String  getEmail() {
	wait.until(ExpectedConditions.visibilityOf(email));
	return email.getAttribute("value");
	}
	
	public String getGendor() {
		String gender = "";
		if(maleGender.isSelected())
			gender =  "male";
		else if(femaleGencer.isSelected())
			gender = "female";
		
		return gender;
	}
	
}
