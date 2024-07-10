package ElementsPractice;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandling_with_getWindowHandle 
{
	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver", "C:/Users/Lakshmi/Downloads/chromedriver-win64/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://demoqa.com/browser-windows");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		WebElement tab=driver.findElement(By.xpath("//button[@id='windowButton']"));
		js.executeScript("arguments[0].scrollIntoView(true)",tab);
		String parentWindow=driver.getWindowHandle();
		tab.click();
		
		Set<String> str=driver.getWindowHandles();
		for(String word:str)
		{
			driver.switchTo().window(word);
			if(driver.getCurrentUrl().equalsIgnoreCase("https://demoqa.com/sample"))break;
		}
		System.out.println(driver.findElement(By.id("sampleHeading")).getText());
		driver.close();
		
		driver.switchTo().window(parentWindow);
		System.out.println(driver.findElement(By.xpath("//button[@id='windowButton']")).getText());
		driver.close();
		
	}

}
