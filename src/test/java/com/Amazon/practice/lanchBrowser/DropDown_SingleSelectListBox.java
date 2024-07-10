package com.Amazon.practice.lanchBrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDown_SingleSelectListBox {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:/Users/Lakshmi/Downloads/chromedriver-win64/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://demoqa.com/select-menu");
		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement oldStyleDropDownEle = driver.findElement(By.xpath("//select[@id='oldSelectMenu']"));
		js.executeScript("arguments[0].scrollIntoView(true)", oldStyleDropDownEle);
		
		Select select=new Select(oldStyleDropDownEle);
		select.selectByIndex(3);

	}

}
