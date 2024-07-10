package com.Amazon.practice.lanchBrowser;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Program5 
{
	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver","C:/Users/Lakshmi/Downloads/chromedriver-win64/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		
		WebElement electornicEle = driver.findElement(By.xpath("//span[text()='Electronics']"));
		Actions act=new Actions(driver);
		act.moveToElement(electornicEle).pause(Duration.ofSeconds(2)).moveByOffset(100,0).pause(2000).doubleClick().pause(2000).contextClick().perform();
	}

}
