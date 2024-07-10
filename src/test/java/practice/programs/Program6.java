package practice.programs;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Program6 
{
	public static void main(String[] args)throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","C:/Users/Lakshmi/Downloads/chromedriver-win64/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.flipkart.com");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Redmi note 10 pro", Keys.ENTER);
				
		String dynamicXpath="//div[text()='REDMI Note 10 Pro (Dark Night, 128 GB)']/following-sibling::div[@class='fMghEO']//li[text()='6 GB RAM | 128 GB ROM | Expandable Upto 512 GB']/ancestor::div[@class='col col-7-12']/following-sibling::div//div[@class='_30jeq3 _1_WHN1']";
		
		String price=driver.findElement(By.xpath(dynamicXpath)).getText();
		System.out.println(price);
		
		driver.quit();
	}

}
