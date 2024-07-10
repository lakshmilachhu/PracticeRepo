package com.Amazon.practice.lanchBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class LaunchInternetExplorer 
{
	public static void main(String[] args)
	{
		System.setProperty("webdriver.ie.driver","C:\\Users\\Lakshmi\\Downloads\\IEDriverServer_x64_4.14.0\\IEDriverServer.exe");
		WebDriver driver=new InternetExplorerDriver();
		
		
	}

}
