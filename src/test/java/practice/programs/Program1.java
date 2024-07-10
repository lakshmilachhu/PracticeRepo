package practice.programs;

import org.openqa.selenium.chrome.ChromeDriver;

//practice of WebDriver interface methods

public class Program1 
{
	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Lakshmi\\Downloads\\chromedriver-win64\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		String url=driver.getCurrentUrl();
		System.out.println("Current Url is: " + url);
		
		String title=driver.getTitle();
		System.out.println("Title of webPage is: " + title);
		
		driver.navigate().back();
		Thread.sleep(2000);
		
		driver.close();
	}

}
