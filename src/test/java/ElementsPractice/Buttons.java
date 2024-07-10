package ElementsPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Buttons 
{
	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:/Users/Lakshmi/Downloads/chromedriver-win64/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://demoqa.com/");
		WebElement ele=driver.findElement(By.xpath("//h5[text()='Elements']"));

		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)",ele);
		ele.click();
		
		js.executeScript("window.scrollBy(0,300)");
		driver.findElement(By.xpath("//span[text()='Buttons']")).click();
		Thread.sleep(150);
		String text="Click Me";
		WebElement eleAction=driver.findElement(By.xpath("//button[text()='"+text+"']"));
		js.executeScript("arguments[0].scrollIntoView(true)",eleAction);
	
		Actions act=new Actions(driver);
		act.doubleClick(eleAction).perform();
		act.contextClick(eleAction).perform();
		act.click(eleAction).perform();
		
//		if()
	}

}
