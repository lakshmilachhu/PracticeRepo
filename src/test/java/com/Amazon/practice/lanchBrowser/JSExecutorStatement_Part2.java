package com.Amazon.practice.lanchBrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class JSExecutorStatement_Part2 
{
	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:/Users/Lakshmi/Downloads/chromedriver-win64/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://demoqa.com/");
		WebElement ele = driver.findElement(By.xpath("//h5[text()='Elements']"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,300)"); //it will do relative point calculation
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,300)");
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,-300)");
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,300)");
		Thread.sleep(1000);
		js.executeScript("window.scrollTo(0,300)");//it will do absolute point calculation
		Thread.sleep(1000);
		js.executeScript("window.scrollTo(0,0)"); //scroll to top
		Thread.sleep(1000);
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)"); //scroll to bottom
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
		
	}

}
