package com.Amazon.practice.lanchBrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Program2 
{
	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","C:/Users/Lakshmi/Downloads/chromedriver-win64/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.google.com/");
		Thread.sleep(2000);
		driver.manage().window().maximize();
		
		WebElement languageElement = driver.findElement(By.partialLinkText("ಕನ್ನ"));
		Thread.sleep(2000);
		languageElement.click();
		
		
		Thread.sleep(4000);
		driver.quit();
	}

}
