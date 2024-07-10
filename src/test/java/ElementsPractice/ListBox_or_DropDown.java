package ElementsPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ListBox_or_DropDown 
{
	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:/Users/Lakshmi/Downloads/chromedriver-win64/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://demoqa.com/select-menu");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		WebElement selectBox=driver.findElement(By.xpath("//div[text()='Select Option']"));
		js.executeScript("arguments[0].scrollIntoView(true)",selectBox);
		selectBox.click();
		
		String opName=driver.findElement(By.xpath("//div[text()='A root option']")).getText();
		System.out.println("Your selected option is: " + opName);

		WebElement option=driver.findElement(By.xpath("//div[text()='A root option']"));
		js.executeScript("arguments[0].scrollIntoView(true)",option);
		option.click();		
		
		driver.close();
	}

}
