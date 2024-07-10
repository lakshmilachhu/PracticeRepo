package com.Amazon.practice.lanchBrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Program1 
{
	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","C:/Users/Lakshmi/Downloads/chromedriver-win64/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.facebook.com/");
		Thread.sleep(2000);
		driver.manage().window().maximize();
		String res=driver.getTitle();
		System.out.println(res);
		
		WebElement emailTxtField = driver.findElement(By.name("email"));
		String placeHolderValue = emailTxtField.getAttribute("placeholder");
		System.out.println(placeHolderValue);
		emailTxtField.sendKeys("user123");
		WebElement passwordTxtField = driver.findElement(By.name("pass"));
		passwordTxtField.sendKeys("password123456");
		Thread.sleep(2000);
		driver.navigate().refresh();
		emailTxtField = driver.findElement(By.name("email"));
		emailTxtField.clear();
		Thread.sleep(2000);
		driver.close();
	}

}
