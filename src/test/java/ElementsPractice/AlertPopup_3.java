package ElementsPractice;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertPopup_3 {
	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver", "C:/Users/Lakshmi/Downloads/chromedriver-win64/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/alerts");
		String parentWindow=driver.getWindowHandle();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		WebElement confirmButton=driver.findElement(By.xpath("//button[@id='confirmButton']"));
		js.executeScript("arguments[0].scrollIntoView(true)",confirmButton);
		confirmButton.click();
		
		Alert alertBox=driver.switchTo().alert();
		System.out.println(alertBox.getText());
		alertBox.dismiss();
		
		driver.switchTo().window(parentWindow);
		System.out.println(driver.findElement(By.xpath("//span[@id='confirmResult']")).getText());
		driver.close();
	}
}
