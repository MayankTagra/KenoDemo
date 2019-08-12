package DataProvider;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.Test;

public class FluentWaitExample {
	@Test()
	public void carryTestCaseWithFluentWait()
	{
		System.setProperty("webdriver.chrome.driver","C:\\chromeDriver\\chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.setPageLoadStrategy(PageLoadStrategy.NONE);
	
		WebDriver driver=new ChromeDriver(options);
		driver.get("https://keno.qa.pch.com/");
		driver.manage().window().maximize();
		FluentWait<WebDriver> wait=new FluentWait<WebDriver>(driver);
		
		wait.pollingEvery(5,TimeUnit.SECONDS);
		wait.withTimeout(60,TimeUnit.SECONDS);
		
		
		
		
		

		
		
	}

}
