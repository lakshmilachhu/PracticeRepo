package ElementsPractice;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandling_withText 
{
	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:/Users/Lakshmi/Downloads/chromedriver-win64/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://demoqa.com/browser-windows");
		
		WebElement tab=driver.findElement(By.id("messageWindowButton"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", tab);
		String parentWindow=driver.getWindowHandle();
		tab.click();
		
		Set<String> set=driver.getWindowHandles();
		for(String word:set)
			if(!word.equalsIgnoreCase(parentWindow)) //if url or title or locators not mentioned in new tab, we should handle like this.
			{
				driver.switchTo().window(word);
				Thread.sleep(2000);
			}
		
		driver.close();
		
		driver.switchTo().window(parentWindow);
		System.out.println(tab.getText());
		
		driver.close();
	}
}
