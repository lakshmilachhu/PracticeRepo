package com.Amazon.practice.lanchBrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Program4 
{
	public static void main(String[] args)throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","C:/Users/Lakshmi/Downloads/chromedriver-win64/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		driver.get("https://www.gmail.com");
		Thread.sleep(2000);
		
		driver.findElement(By.className("dropdown__label")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("For my personal use")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.id("firstName")).sendKeys("lakshmi");
		driver.findElement(By.id("lastName")).sendKeys("mohan");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@class='VfPpkd-vQzf8d' and text()='Next']")).click();
		
	}

}
