package practice.programs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Program5 
{
	public static void main(String[] args)throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","C:/Users/Lakshmi/Downloads/chromedriver-win64/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		//changes done
		driver.get("https://www.facebook.com/");
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//*[@class='inputtext _55r1 _6luy _9npi']")).sendKeys("Lakshmi");
		Thread.sleep(2000);
		
		driver.quit();
	}	
}
