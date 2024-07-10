package ElementsPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TextBox 
{
	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:/Users/Lakshmi/Downloads/chromedriver-win64/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://demoqa.com/");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		WebElement ele=driver.findElement(By.xpath("//h5[text()='Elements']"));
		js.executeScript("arguments[0].scrollIntoView(true)", ele);
		ele.click();
		
		driver.findElement(By.xpath("//span[text()='Text Box']")).click();
		
		driver.findElement(By.id("userName")).sendKeys("Lakshmi");
		driver.findElement(By.id("userEmail")).sendKeys("lakshmi@gmail.com");
		driver.findElement(By.id("currentAddress")).sendKeys("Bangalore");
		driver.findElement(By.id("permanentAddress")).sendKeys("Bhadravathi");
		
		WebElement submitButton=driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
		js.executeScript("arguments[0].scrollIntoView(true)",submitButton); //using JS
		submitButton.click();
		
//		js.executeScript("arguments[0].click()",submitButton);  //internally click on Submit button using JS
		
//		Actions act=new Actions(driver);
//		act.moveToElement(submitButton).click().perform(); // by moving cursor point to element and clicking that by using Actions class
		
	}

}
