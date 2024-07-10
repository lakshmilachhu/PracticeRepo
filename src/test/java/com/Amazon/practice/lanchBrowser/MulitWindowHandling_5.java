package com.Amazon.practice.lanchBrowser;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MulitWindowHandling_5 {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:/Users/Lakshmi/Downloads/chromedriver-win64/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://demoqa.com/browser-windows");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		WebElement oldStyleDropDownEle = driver.findElement(By.xpath("//button[@id='messageWindowButton']"));
		js.executeScript("arguments[0].scrollIntoView(true)", oldStyleDropDownEle);
		String parentWindowStr = driver.getWindowHandle();
		oldStyleDropDownEle.click();
		Set<String> set = driver.getWindowHandles();
		
		for(String str:set) {
			if(!str.equalsIgnoreCase(parentWindowStr))
			{
				driver.switchTo().window(str);
				Thread.sleep(2000);
				driver.close();
			}
		}	
	
	    driver.switchTo().window(parentWindowStr);	
		System.out.println(oldStyleDropDownEle.getText());
		driver.close();
	}

}
