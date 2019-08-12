package Package1;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MatchWebElements {
	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","C:\\chromeDriver\\chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.setPageLoadStrategy(PageLoadStrategy.NONE);
		
		WebDriver driver=new ChromeDriver(options);
		
		driver.get("http://keno.qa.pch.com");
		driver.manage().window().maximize();
		WebDriverWait wait=new WebDriverWait(driver,800);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//aside//iframe")));
		Thread.sleep(23000);
	
		WebElement w=driver.findElement(By.xpath("//iframe[@height='600']"));
		WebElement w1=driver.findElement(By.xpath("//aside//iframe"));
		if(w.equals(w1))
		{
			System.out.println("Match successful");
		}
		else
		{
			System.out.println("Match Unsuccessful");
		}
		
	}

}
