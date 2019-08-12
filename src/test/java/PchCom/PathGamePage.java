package PchCom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PathGamePage {
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	
	By playNow250=By.xpath("//div[@class='play_now_button']");
	By gameOverButton250=By.className("btn btn--cardb btn-primary");
	By gameOverText=By.xpath("//div[@class='gameover-text']");
	
	By canvasSfl=By.xpath("//canvas[@width='1072']");
	By canvasSlots=By.xpath("//canvas[@width='699']");
	
	
	Actions builder;
	
	public PathGamePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void playScratchGame() throws InterruptedException
	{	
		wait=new WebDriverWait(driver,800);
		js=(JavascriptExecutor)driver;
		
		for(int i=0;i<4;i++)
		{
			
				System.out.println(i);
				System.out.println();
				js.executeScript("window.scrollTo(0,0)");
				
			try
			{
				js.executeScript("window.scrollTo(0,0)");
				wait.until(ExpectedConditions.visibilityOfElementLocated(playNow250));
			
				//driver.findElement(playNow250).click();
				//wait for that much period of time
				Thread.sleep(2300);
				js.executeScript("document.querySelector(\"div[class='play_now_button']\").click()");
				Thread.sleep(5600);
				js.executeScript("document.querySelector(\"a[id='reveal-all']\").click()");
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(gameOverText));
				js.executeScript("document.querySelector(\"button[class='btn btn--cardb btn-primary']\").scrollIntoView()");
				js.executeScript("document.querySelector(\"button[class='btn btn--cardb btn-primary']\").click()");
				System.out.println(i);
				
			}
			catch(Exception e)
			{
				System.out.println("Exception Occured");
				if(driver.findElements(gameOverText).size()!=0)
				{
				wait.until(ExpectedConditions.visibilityOfElementLocated(gameOverText));
				js.executeScript("document.querySelector(\"button[class='btn btn--cardb btn-primary']\").scrollIntoView()");
				js.executeScript("document.querySelector(\"button[class='btn btn--cardb btn-primary']\").click()");
				}
				else
				{
					System.out.println("Proceed Further");
				}
	
			}
		}
		
			
		
	}
	
	public void playSlots() throws InterruptedException
	{
		wait=new WebDriverWait(driver,800);
		builder=new Actions(driver);
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(canvasSlots));
			System.out.println("Slots Loaded");
		}
		catch(Exception e)
		{
			driver.navigate().to("https://keno.qa.pch.com/continue");
		}
		
		for(int i=0;i<14;i++)
		{	
			try
			{
				wait.until(ExpectedConditions.visibilityOfElementLocated(canvasSlots));
				Thread.sleep(5600);
				
				builder.moveToElement(driver.findElement(canvasSlots)).moveByOffset(173, 139).click().build().perform();
			}
			catch(Exception e)
			{
					System.out.println("Exception Occured");
					Thread.sleep(9900);
			}
		}
	}
	
	public void playSfl() throws InterruptedException
	{	js=(JavascriptExecutor)driver;
		builder=new Actions(driver);
		
		wait=new WebDriverWait(driver,800);
		for(int i=0;i<3;i++)
		{	
			
			js.executeScript("window.scrollTo(0,0)");
		
			
			Thread.sleep(50000);
			js.executeScript("window.scrollBy(0,150)");
	
			builder.moveToElement(driver.findElement(canvasSfl)).moveByOffset(0, 200).click().build().perform();
			
			Thread.sleep(10000);
			builder.moveToElement(driver.findElement(canvasSfl)).moveByOffset(163, -78)
			.click().build().perform();
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(gameOverText));
			Thread.sleep(3400);
			//js.executeScript("document.querySelector(\"button[class='btn btn--cardb btn-primary']\").scrollIntoView()");
			
			js.executeScript("document.querySelector(\"button[class='btn btn--cardb btn-primary']\").click()");
			
		}
		
		
	}
	
	public void forwardScratchGame()
	{
		wait=new WebDriverWait(driver,800);
		wait.until(ExpectedConditions.visibilityOfElementLocated(playNow250));
		driver.navigate().to("https://keno.qa.pch.com/continue");
		
	}
	public void forwardSlots()
	{
		wait=new WebDriverWait(driver,800);
		wait.until(ExpectedConditions.visibilityOfElementLocated(canvasSlots));
		driver.navigate().to("https://keno.qa.pch.com/continue");
	}
	public void forwardSfl()
	{
		wait=new WebDriverWait(driver,800);
		wait.until(ExpectedConditions.visibilityOfElementLocated(canvasSfl));
		driver.navigate().to("https://keno.qa.pch.com/continue");
	}
	
	/*
	 * public void allternativeScrathGamecode() { wait=new
	 * WebDriverWait(driver,800); js=(JavascriptExecutor)driver;
	 * 
	 * for(int i=0;i<4;i++) { System.out.println(i); System.out.println();
	 * js.executeScript("window.scrollTo(0,0)");
	 * 
	 * try { wait.until(ExpectedConditions.visibilityOfElementLocated(playNow250));
	 * Thread.sleep(2300); driver.findElement(playNow250).click(); } catch(Exception
	 * e) {
	 * 
	 * 
	 * 
	 * }
	 */
	

}
