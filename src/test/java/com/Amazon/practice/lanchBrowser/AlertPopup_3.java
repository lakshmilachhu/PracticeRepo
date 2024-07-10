package com.Amazon.practice.lanchBrowser;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertPopup_3 {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:/Users/Lakshmi/Downloads/chromedriver-win64/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://demoqa.com/alerts");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement oldStyleDropDownEle = driver.findElement(By.xpath("//button[@id='promtButton']"));
		js.executeScript("arguments[0].scrollIntoView(true)", oldStyleDropDownEle);
		oldStyleDropDownEle.click();
		Alert alert = driver.switchTo().alert();
		alert.sendKeys("Lakshmi Mohan");
		System.out.println(alert.getText());
		Thread.sleep(2000);
		alert.accept();
		
		
	}

}
