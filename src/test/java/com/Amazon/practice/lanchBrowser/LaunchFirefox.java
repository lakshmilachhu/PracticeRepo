package com.Amazon.practice.lanchBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LaunchFirefox {

	
	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver","C:\\Users\\Lakshmi\\Downloads\\geckodriver-v0.34.0-win32\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
	}
	
}
