package com.demowebshop.PageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	@FindBy(xpath = "//a[text()='Log out']")
	WebElement LogoutLink;
	
	public void clickLogoutLink() {
		wait.until(ExpectedConditions.elementToBeClickable(LogoutLink)).click();
	}
	
	@FindBy(xpath = "//a[text()='My account']")
	WebElement myAccountLink;

//	public void scrollToMyAccountLinkEelement() {
//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", myAccountLink);
//	}
	
	public void clickMyAccountLink() {
//		WebElement Account = wait.until(ExpectedConditions.elementToBeClickable(myAccountLink));
//		Account.click();
		wait.until(ExpectedConditions.visibilityOf(myAccountLink));
		myAccountLink.click();
	}
	
}
