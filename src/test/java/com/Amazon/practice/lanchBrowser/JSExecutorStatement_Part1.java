package com.Amazon.practice.lanchBrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class JSExecutorStatement_Part1 
{
	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:/Users/Lakshmi/Downloads/chromedriver-win64/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://demoqa.com/");
		WebElement ele = driver.findElement(By.xpath("//h5[text()='Elements']"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("console.log('MOhan lakshmi')");
		js.executeScript("arguments[0].click()",ele);
		js.executeScript("window.location=arguments[0]","https://demoqa.com/text-box");
		WebElement txtFieldEle = driver.findElement(By.id("userName"));
		js.executeScript("arguments[0].value=arguments[1]",txtFieldEle,"Mohan");
		Thread.sleep(3000);
		js.executeScript("location.reload()");
		String title=(String)js.executeScript("return document.title");
		System.out.println("Title of Page ==> "+title);

	}

}
