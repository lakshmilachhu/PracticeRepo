package ElementsPractice;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertPopup_2 
{
	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver", "C:/Users/Lakshmi/Downloads/chromedriver-win64/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		WebDriverWait wait=new WebDriverWait(driver,10);
		
		driver.get("https://demoqa.com/alerts");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		WebElement timerButton=driver.findElement(By.xpath("//button[@id='timerAlertButton']"));
		js.executeScript("arguments[0].scrollIntoView(true)",timerButton);
		timerButton.click();
		
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alertBox=driver.switchTo().alert();
		System.out.println(alertBox.getText());
		alertBox.accept();
		
		driver.close();
	}

}
