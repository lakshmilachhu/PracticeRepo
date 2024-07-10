package com.Amazon.practice.lanchBrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Program3 
{
	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","C:/Users/Lakshmi/Downloads/chromedriver-win64/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.flipkart.com/");
		Thread.sleep(1000);
		driver.manage().window().maximize();
		
//		driver.findElement(By.className("Pke_EE")).sendKeys("mobiles under 15000");
//		driver.findElement(By.className("Pke_EE")).submit();
		driver.findElement(By.className("Pke_EE")).sendKeys("mobiles under 5000");
		Thread.sleep(2000);
		driver.findElement(By.className("Pke_EE")).sendKeys(Keys.chord(Keys.CONTROL,"A"+"X"));
		Thread.sleep(2000);
		driver.findElement(By.className("Pke_EE")).sendKeys("mobiles under 15000",Keys.ENTER);
		Thread.sleep(2000);
		driver.findElement(By.name("q")).sendKeys(Keys.chord(Keys.CONTROL,"A"));
		Thread.sleep(2000);
		driver.findElement(By.name("q")).sendKeys(Keys.chord(Keys.CONTROL,"V",Keys.ENTER));
		
		
		Thread.sleep(4000);
	}

}
