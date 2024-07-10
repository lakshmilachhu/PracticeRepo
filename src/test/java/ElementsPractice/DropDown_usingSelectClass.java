package ElementsPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDown_usingSelectClass 
{
	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:/Users/Lakshmi/Downloads/chromedriver-win64/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.navigate().to("https://demoqa.com/select-menu");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		WebElement pointEle=driver.findElement(By.xpath("//select[@id='cars']"));
		js.executeScript("arguments[0].scrollIntoView(true)", pointEle);
		
		Select sct=new Select(pointEle);
		sct.selectByIndex(2);
		sct.selectByValue("audi");
		sct.selectByVisibleText("Volvo");
		
		sct.deselectByIndex(3);
		
		boolean status=sct.isMultiple();
		System.out.println("StandardMultiSelect is multiselect dropdown : "+ status);
		
		WebElement element=sct.getFirstSelectedOption();
		String data1=element.getText();
		System.out.println("1st selected option is:" + data1);
		
		WebElement pointEle2=driver.findElement(By.xpath("//select[@id='oldSelectMenu']"));
		js.executeScript("window.scrollTo(0,document.body.scrollHieght)");
		js.executeScript("arguments[0].scrollIntoView(true)", pointEle2);
		Thread.sleep(2000);
		
		sct=new Select(pointEle2);
		sct.selectByIndex(5);
		
		List<WebElement> elements=sct.getOptions();
		System.out.println("The options contains in Dropdown OldStyleMenu is: ");
		for(WebElement options:elements)
			System.out.println(options.getText());
		
		boolean ele2Status=sct.isMultiple();
		System.out.println("OldStyleMenu is multichoice dopdown:" + ele2Status);
	}

}
