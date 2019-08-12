package Package1;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PchCom.KenoHomePage;
import PchCom.KenoSignInPage;

public class checkDailyBonus {
	public static WebDriver driver;
	public static WebDriverWait wait;
	
	
	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver","C:\\chromeDriver\\chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.setPageLoadStrategy(PageLoadStrategy.NONE);
		driver=new ChromeDriver(options);
		
		driver.get("https://keno.qa.pch.com/");
		driver.manage().window().maximize();
		
		wait=new WebDriverWait(driver,800);
		KenoHomePage homePage=new KenoHomePage(driver);
		homePage.clickSignIn();
		
		KenoSignInPage signInPage=new KenoSignInPage(driver);
		signInPage.Login("xxx123CH@pchmail.com","pch123");
		
		try
		{
			WebDriverWait w=new WebDriverWait(driver,100);
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='modal fade dailybonus in']")));
			System.out.println("Daily Bonus popup Appeared");
			driver.findElement(By.xpath("//div[@class='dailybonus__footer']//button")).click();
			
			
		}
		catch(Exception e)
		{
			System.out.println("Not First Time Login So DailyBonus not appeared");
			
		}
		
		
		
		
		
	}

}
