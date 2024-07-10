package com.Amazon.practice.lanchBrowser;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ToolTip {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:/Users/Lakshmi/Downloads/chromedriver-win64/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://demoqa.com/tool-tips");
				
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement oldStyleDropDownEle = driver.findElement(By.xpath("//button[@id='toolTipButton']"));
		js.executeScript("arguments[0].scrollIntoView(true)", oldStyleDropDownEle);
		Actions act=new Actions(driver);
		act.moveToElement(oldStyleDropDownEle).perform();
		String toolTipTxt = driver.findElement(By.xpath("//div[@class='tooltip-inner']")).getText();
		if(toolTipTxt.equalsIgnoreCase("You hovered over the Button")) {
			System.out.println("TC Pass");
		}else {
			System.out.println("TC Fail");
		}
		

	}

}
