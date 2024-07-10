package ElementsPractice;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandling_NewWindow 
{
	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:/Users/Lakshmi/Downloads/chromedriver-win64/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://demoqa.com/browser-windows");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		WebElement tab=driver.findElement(By.id("windowButton"));
		js.executeScript("arguments[0].scrollIntoView(true)",tab);
		tab.click();
		Thread.sleep(1000);
		
		Set<String> set=driver.getWindowHandles();
		for(String str:set)
		{
			driver.switchTo().window(str);
			if(driver.getCurrentUrl().equalsIgnoreCase("https://demoqa.com/sample"))
				break;
		}
		System.out.println(driver.findElement(By.id("sampleHeading")).getText());
		driver.close();
		
		set=driver.getWindowHandles();
		for(String str:set)
		{
			driver.switchTo().window(str);
			if(driver.getCurrentUrl().equalsIgnoreCase("https://demoqa.com/browser-windows"))break;
		}
		
		System.out.println(driver.findElement(By.id("windowButton")).getText());
		driver.quit();
	}

}
