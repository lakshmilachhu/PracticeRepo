package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	protected LoginPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}	
	
	//declaration
	@FindBy(xpath = "//input[@name='user_name']") 
	protected WebElement userNameTxtField;
	
	@FindBy(name = "user_password") 
	protected WebElement passwordTxtField;
	
	@FindBy(id = "submitButton") 
	protected WebElement loginBtn;
	
	@FindAll({@FindBy(id="password"), @FindBy(name="user_password"), 
		@FindBy(xpath="//input[@name='user_password']")}) 
	protected WebElement passwordTxtField2;
	
	
	

}
