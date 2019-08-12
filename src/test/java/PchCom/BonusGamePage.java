package PchCom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class BonusGamePage
{
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	
	By gameBonus=By.xpath("//div[@class='play_now_button']");
	By gameoverText=By.xpath("//div[@class='gameover-text']");
	
	public BonusGamePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	@Test()
	public void BonusGamePlay() throws InterruptedException
	{	
			js=(JavascriptExecutor)driver;
			wait=new WebDriverWait(driver,100);
			for(int i=0;i<5;i++)
			{		
					try
					{		
						js.executeScript("window.scrollTo(0,0)");
						wait.until(ExpectedConditions.visibilityOfElementLocated(gameBonus));
						Thread.sleep(2300);
						js.executeScript("document.querySelector(\"div[class='play_now_button']\").click()");
						Thread.sleep(5000);
						js.executeScript("document.querySelector(\"a[id='reveal-all']\").click()");
						wait.until(ExpectedConditions.visibilityOfElementLocated(gameoverText));
						js.executeScript("document.querySelector(\"button[class='btn btn--cardf btn-primary']\").scrollIntoView()");
						js.executeScript("document.querySelector(\"button[class='btn btn--cardf btn-primary']\").click()");
					}
					catch(Exception e)
					{	
						System.out.println("Exception Occured in Bonus Game Page");
						
						wait.until(ExpectedConditions.visibilityOfElementLocated(gameoverText));
						js.executeScript("document.querySelector(\"button[class='btn btn--cardf btn-primary']\").scrollIntoView()");
						js.executeScript("document.querySelector(\"button[class='btn btn--cardf btn-primary']\").click()");
						
					}
		
			}
	}
}
