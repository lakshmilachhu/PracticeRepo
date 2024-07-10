package practice.programs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Program3 
{
	public static void main(String[] args)throws InterruptedException
	{
		System.setProperty("webdriver.edge.driver","C:\\Users\\Lakshmi\\Downloads\\edgedriver_win64\\msedgedriver.exe");
		WebDriver driver=new EdgeDriver();
		
		driver.get("https://www.google.com");
		Thread.sleep(1000);
		
		String title=driver.getTitle();
		if(title.equals("Google"))
			System.out.println("It is showing correct title");
		else
			System.out.println("It is showing wrong title");
		
		String url=driver.getCurrentUrl();
		if(url.contains("google"))
			System.out.println("Link is Correct");
		else
			System.out.println("Not correct");
		
		driver.quit();
	}

}
