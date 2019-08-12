package DataProvider;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ResultTrust {
	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","C:\\chromeDriver\\chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.setPageLoadStrategy(PageLoadStrategy.NONE);
		WebDriver driver=new ChromeDriver(options);
		driver.get("https://keno.qa.pch.com/");
		driver.manage().window().maximize();
		WebDriverWait wait=new WebDriverWait(driver,800);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//nav[@class='uninav__unrecognized']//ul//li[1]//a")));
		driver.findElement(By.xpath("//nav[@class='uninav__unrecognized']//ul//li[1]//a")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("EM")));
		driver.findElement(By.id("EM")).sendKeys("vip212@pchmail.com");
		driver.findElement(By.id("PW")).sendKeys("pch123");
		
		driver.findElement(By.id("login-sub-btn")).click();
		try
		{
			Thread.sleep(4000);
			driver.findElement(By.id("login-sub-btn")).click();
			
		}
		catch(Exception e)
		{
			System.out.println("Already Clicked");
		}
		
		//Now we click on results
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//nav[@id='mainnav']//ul//li[4]//a")));
		driver.findElement(By.xpath("//nav[@id='mainnav']//ul//li[4]//a")).click();
		Thread.sleep(44000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@class='form-label results__form__date']//span[@class='glyphicon glyphicon-triangle-bottom']")));
		driver.findElement(By.xpath("//label[@class='form-label results__form__date']//span[@class='glyphicon glyphicon-triangle-bottom']")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
		driver.findElement(By.xpath(""));
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@class='form-label results__form__date']//span[@class='form-label__display']")));
		//driver.findElement(By.xpath("//label[@class='form-label results__form__date']//span[@class='form-label__display']")).click();
		
		Thread.sleep(66000);
		
		
		
	}

}
