package ElementsPractice;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertPopup_4 
{
	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:/Users/Lakshmi/Downloads/chromedriver-win64/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/alerts");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		WebElement promptButton=driver.findElement(By.xpath("//button[@id='promtButton']"));
		js.executeScript("arguments[0].scrollIntoView(true)", promptButton);
		promptButton.click();
		
		Alert alertBox=driver.switchTo().alert();
		Thread.sleep(1000);
		alertBox.sendKeys("LakshmiLovesMohan");
		Thread.sleep(1000);
		alertBox.accept();
		
		driver.close();
	}

}
