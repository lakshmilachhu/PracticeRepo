package com.Amazon.practice.lanchBrowser;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Frame_2 
{
	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","C:/Users/Lakshmi/Downloads/chromedriver-win64/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.get("https://demoqa.com/frames");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		driver.switchTo().frame("frame2"); //name or id
		
		WebElement ele=driver.findElement(By.xpath("//h1[@id='sampleHeading']"));
		js.executeScript("arguments[0].scrollIntoView(true)", ele);
		System.out.println(ele.getText());
		Thread.sleep(1000);
		
		driver.switchTo().parentFrame();
		
		WebElement abc=driver.findElement(By.xpath("//h1[@class='text-center']"));
		js.executeScript("arguments[0].scrollIntoView(true)", abc);
		System.out.println(abc.getText());
		
		
		//driver.close();
	}

}
