package com.Amazon.practice.lanchBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class LunchMicrosoftEdge 
{
	public static void main(String[] args)
	{
		System.setProperty("webdriver.edge.driver","C:\\Users\\Lakshmi\\Downloads\\edgedriver_win64\\msedgedriver.exe");
		WebDriver driver=new EdgeDriver();
	}

}
