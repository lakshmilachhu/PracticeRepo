package com.Amazon.practice.lanchBrowser;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MulitWindowHandling_3 {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:/Users/Lakshmi/Downloads/chromedriver-win64/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://demoqa.com/browser-windows");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement oldStyleDropDownEle = driver.findElement(By.xpath("//button[@id='windowButton']"));
		js.executeScript("arguments[0].scrollIntoView(true)", oldStyleDropDownEle);
		oldStyleDropDownEle.click();
		
		Set<String> set = driver.getWindowHandles();
		for(String windowStr:set) {
			driver.switchTo().window(windowStr);
			if(driver.getCurrentUrl().equalsIgnoreCase("https://demoqa.com/sample"))break;
		}
		
		
		String pageText = driver.findElement(By.id("sampleHeading")).getText();
		System.out.println(pageText);
		Thread.sleep(2000);
		driver.close();
		Thread.sleep(2000);
	
		set = driver.getWindowHandles();
		for(String windowStr:set) {
			driver.switchTo().window(windowStr);
			if(driver.getCurrentUrl().equalsIgnoreCase("https://demoqa.com/browser-windows"))break;
		}
		System.out.println(oldStyleDropDownEle.getText());
		driver.close();
	}

}
