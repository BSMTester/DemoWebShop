package com.demowebshop.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;


public class Readconfig {
	
	Properties prop;
	
	public Readconfig() {
		File file = new File("./config.properties");
	try{
			FileInputStream fis = new FileInputStream(file);
			prop = new Properties();
			prop.load(fis);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getApplicationUrl() {
		return prop.getProperty("baseUrl");
	}
	
	public String getMaleGendor() {
		return prop.getProperty("GenderMale");
	}
	
	public String getFemaleGendor() {
		return prop.getProperty("GenderFemale");
	}
	
	public String getFirstName() {
		return prop.getProperty("FirstName");
	}
	
	public String getLastName() {
		return prop.getProperty("LastName");
	}
	
	public String getEmail() {
		
		String str = prop.getProperty("Email");
		str = str + System.currentTimeMillis()+".gmail.com";
		return str;
	}

	public String getInvalidEmail(){
		String str = prop.getProperty("Email");
		str = str + System.currentTimeMillis()+"il.om";
		return str;
	}
	
	public String getPassword() {
		return prop.getProperty("Password");
	}
	
	public String getConfirmPassword() {
		return prop.getProperty("ConformPassword");
	}
	
	public String getLoginEmail() {
		return prop.getProperty("LoginEmail");
	}
	
	public String getLoginPassword() {
		return prop.getProperty("LoginPassword");
	}
	
	public String getEmailErrMsg(){
		return prop.getProperty("EmailErrMsg");
	}
	
	public String getLoginFirstName() {
		return prop.getProperty("LoginFirstname");
	}
	
	public String getLoginLastName() {
		return prop.getProperty("LoginLastname");
	}
}
