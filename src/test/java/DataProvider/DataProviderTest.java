package DataProvider;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {
	@DataProvider(name="Authentication")
	public Object getData()
	{
		return new Object[][] {{"vip212@pchmail.com","pch123"},{"nes123CH@pchmail.com","pch123"}};
	}
	@Test(dataProvider="Authentication")
	public void playDemo(String fname,String lname)
	{
		System.setProperty("webdriver.chrome.driver","C:\\chromeDriver\\chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.setPageLoadStrategy(PageLoadStrategy.NONE);
		WebDriver driver=new ChromeDriver(options);
		WebDriverWait wait=new WebDriverWait(driver,800);
		
		driver.get("https://keno.qa.pch.com/");
		driver.manage().window().maximize();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//nav[@class='uninav__unrecognized']//ul//li[1]//a")));
		
		driver.findElement(By.xpath("//nav[@class='uninav__unrecognized']//ul//li[1]//a")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("EM")));
		driver.findElement(By.id("EM")).sendKeys(fname);
		driver.findElement(By.id("PW")).sendKeys(lname);
		driver.findElement(By.id("login-sub-btn")).click();
		try
		{	
			Thread.sleep(4000);
			driver.findElement(By.id("login-sub-btn")).click();
		}
		catch(Exception e)
		{
			System.out.println("already clicked");
		}
		
	}

}
