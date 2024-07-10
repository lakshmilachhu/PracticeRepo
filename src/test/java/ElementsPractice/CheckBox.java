package ElementsPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBox 
{
	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver", "C:/Users/Lakshmi/Downloads/chromedriver-win64/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://demoqa.com/");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,200)");
		
		driver.findElement(By.xpath("//h5[text()='Elements']")).click();
		driver.findElement(By.xpath("//span[text()='Check Box']")).click();
		
		WebElement arrowEle=driver.findElement(By.xpath("//*[@class='rct-icon rct-icon-expand-close']"));
		js.executeScript("arguments[0].scrollIntoView(true)",arrowEle);
		arrowEle.click();
		
		String cbName="Documents";
		WebElement ele=driver.findElement(By.xpath("//span[text()='"+cbName+"']/preceding-sibling::span[@class='rct-checkbox']/*[name()='svg']"));
		ele.click();
		
		String result=driver.findElement(By.id("result")).getText();
		if(result.toLowerCase().contains(cbName.toLowerCase()))
			System.out.println("You have Selected rigth one");
		else
			System.out.println("You have Selected wrong one");
		
		driver.quit();
			
	}

}
