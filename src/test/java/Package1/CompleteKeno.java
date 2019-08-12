package Package1;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PchCom.KenoHomePage;
import PchCom.KenoLoginedUserHomePage;
import PchCom.KenoSignInPage;

public class CompleteKeno {
	static WebDriver driver=null;
	static WebDriverWait wait=null;
	
	public static void main(String[] args) throws InterruptedException
	{	
		List<WebElement> al=new ArrayList<WebElement>();
		
		
		System.setProperty("webdriver.chrome.driver","C:\\chromeDriver\\chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.setPageLoadStrategy(PageLoadStrategy.NONE);
		driver=new ChromeDriver(options);
		
		driver.get("https://keno.qa.pch.com/");
		driver.manage().window().maximize();
		
		 wait=new WebDriverWait(driver,800);
		KenoHomePage hp=new KenoHomePage(driver);
		hp.clickSignIn();
		KenoSignInPage sp=new KenoSignInPage(driver);
		sp.Login("vip212@pchmail.com","pch123");
		KenoLoginedUserHomePage lgp=new KenoLoginedUserHomePage(driver);
		lgp.submitKenoCard(1, 21, 32, 43, 24, 15, 6, 27, 68, 89);
		lgp.clickSubmit();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='choices__games__pages']")));
		al=driver.findElements(By.xpath("//div[@class='choices__games__page__game choices__games__page__game--playable']"));
		
		//Wait for the element to be clicked
		if(driver.findElements(By.xpath("//div[@class='choices__games__page__game choices__games__page__game--playable'][1]")).size()!=0)			
		{
			String s=driver.findElement(By.xpath("//div[@class='choices__games__page__game choices__games__page__game--playable'][1]//img")).getAttribute("alt");
			System.out.println(s);
			
			if(s.contains("IWPATH"))
			{
				playScratchGame();
			}
			else if(s.contains("set-for-life"))
			{
				playSfl();
				
			}
			else
			{
				externalSlotsLogic();
			}
		}
		if(driver.findElements(By.xpath("//div[@class='choices__games__page__game choices__games__page__game--playable'][2]")).size()!=0)
		{	
			String s=driver.findElement(By.xpath("//div[@class='choices__games__page__game choices__games__page__game--playable'][2]")).getAttribute("alt");
			System.out.println(s);
			if(s.contains("IWPATH"))
			{
				playScratchGame();
			}
			else if(s.contains("set-for-life"))
			{
				playSfl();
			}
			else
			{
				externalSlotsLogic();
			}
			
		}
		if(driver.findElements(By.xpath("//div[@class='choices__games__page__game choices__games__page__game--playable'][3]")).size()!=0)
		{
			String s=driver.findElement(By.xpath("//div[@class='choices__games__page__game choices__games__page__game--playable'][3]//img")).getAttribute("alt");
			System.out.println(s);
			if(s.contains("IWPATH"))
			{
				playScratchGame();
			}
			else if(s.contains("set-for-life"))
			{
				playSfl();
			}
			else
			{
				externalSlotsLogic();
			}
		}
		if(driver.findElements(By.xpath("//div[@class='choices__games__page__game choices__games__page__game--playable'][4]")).size()!=0)
		{
			String s=driver.findElement(By.xpath("//div[@class='choices__games__page__game choices__games__page__game--playable'][4]//img")).getAttribute("alt");
			System.out.println(s);
			if(s.contains("IWPATH"))
			{
				playScratchGame();
			}
			else if(s.contains("set-for-life"))
			{
				playSfl();
			}
			else
			{
				externalSlotsLogic();
			}
			
		}
		
			
		
	}
	
	public static void playScratchGame() throws InterruptedException
	{
		wait=new WebDriverWait(driver,800);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		for(int i=0;i<4;i++)
		{
			
		
			try
			{
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='play_now_button']")));
				
				js.executeScript("document.querySelector(\"div[class='play_now_button']\").click()");
				Thread.sleep(8000);
				js.executeScript("document.querySelector(\"a[id='reveal-all']\").click();");
				Thread.sleep(3400);
				js.executeScript("document.querySelector(\"button[class='btn btn--cardb btn-primary']\").click()");
			}
			catch(Exception e)
			{
				System.out.println("Exception Occured");
				js.executeScript("document.querySelector(\\\"button[class='btn btn--cardb btn-primary']\\\").click()");
				
			}
			
			
		}
		
		
		
		
		
	}
	public static void internalSlotsLogic() throws InterruptedException
	{
		
		Thread.sleep(5600);
		Actions builder=new Actions(driver);
		
		builder.moveToElement(driver.findElement(By.xpath("//canvas[@width='699']"))).moveByOffset(173, 139).click();
	}
	public static  void externalSlotsLogic()
	{
		wait=new WebDriverWait(driver,800);
		
		for(int i=0;i<12;i++)
		{
			try
			{	
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//canvas[@width='699']")));
				internalSlotsLogic();
				
				
			}
			catch(Exception e)
			{
				System.out.println("Exception  Occured");
			}
		}
	}
	
	public static void playSfl()
	{	
		wait=new WebDriverWait(driver,800);
		
			for(int i=0;i<3;i++)
			{
				
			
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//canvas[@width='1072']")));
				
				Actions builder=new Actions(driver);
				builder.moveToElement(driver.findElement(By.xpath("//canvas[@width='1072']"))).moveByOffset(0, 200).click().build().perform();
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//canvas[@width='1072']")));
				builder.moveToElement(driver.findElement(By.xpath("//cnavas[@width='10722']"))).moveByOffset(163, -78)
				.click().build().perform();
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//canvas[@width='1072']")));
				JavascriptExecutor js=(JavascriptExecutor)driver;
				js.executeScript("document.querySelector(\"button[class='btn btn--cardb btn-primary']\").click()");
				
			}
		
		}

}
