package com.viger.businesLibrary;

import org.openqa.selenium.WebDriver;

import com.vtiger.objectRepository.LoginPage;

public class LoginPage_Actions extends LoginPage{

	public LoginPage_Actions(WebDriver driver) {
		super(driver);
	}
	
	public void loginAction(String username, String password) {
		userNameTxtField.sendKeys(username);
		passwordTxtField.sendKeys(password);
		loginBtn.click();
	}

}
