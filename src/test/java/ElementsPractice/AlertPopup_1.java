package ElementsPractice;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertPopup_1 
{
	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver", "C:/Users/Lakshmi/Downloads/chromedriver-win64/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://demoqa.com/alerts");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		WebElement button=driver.findElement(By.xpath("//button[@id='alertButton']"));
		js.executeScript("arguments[0].scrollIntoView(true)", button);
		button.click();
		
		Alert alertBox=driver.switchTo().alert();
		System.out.println(alertBox.getText());
		alertBox.accept();
		
		driver.close();
	}

}
