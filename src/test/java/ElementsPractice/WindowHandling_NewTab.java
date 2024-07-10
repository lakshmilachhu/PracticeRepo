package ElementsPractice;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandling_NewTab 
{
	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver", "C:/Users/Lakshmi/Downloads/chromedriver-win64/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.get("https://demoqa.com/browser-windows");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		WebElement newTab=driver.findElement(By.id("tabButton"));
		js.executeScript("arguments[0].scrollIntoView(true)", newTab);
		newTab.click();
		
		Set<String> set=driver.getWindowHandles();
		for(String str:set)
		{
			driver.switchTo().window(str);
			if(driver.getCurrentUrl().equalsIgnoreCase("https://demoqa.com/sample"))
				break;
		}
		
		String statement=driver.findElement(By.id("sampleHeading")).getText();
		System.out.println(statement);
		driver.close();
		
		set=driver.getWindowHandles();
		for(String str:set)
		{
			driver.switchTo().window(str);
			if(driver.getCurrentUrl().equalsIgnoreCase("https://demoqa.com/browser-windows"))
				break;
		}
		
		String tabName=driver.findElement(By.id("tabButton")).getText();
		System.out.println(tabName);
		driver.quit();
	}

}
