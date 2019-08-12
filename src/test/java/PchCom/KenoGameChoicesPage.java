package PchCom;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class KenoGameChoicesPage {
	WebDriver driver;
	WebDriverWait wait;
	List<WebElement> playable;
	List<WebElement> unplayable;
	
	By playableGame=By.xpath("//div[@class='choices__games__page__game choices__games__page__game--playable']");
	By completedGames=By.xpath("//div[@class='choices__games__page__game choices__games__page__game--completed']");
	By game1=By.xpath("//div[@class='choices__games__page__game choices__games__page__game--playable'][1]");
	
	By game2=By.xpath("//div[@class='choices__games__page__game choices__games__page__game--playable'][2]");
	
	By game3=By.xpath("//div[@class='choices__games__page__game choices__games__page__game--playable'][3]");
	
	By game4=By.xpath("//div[@class='choices__games__page__game choices__games__page__game--playable'][4]");
	By image1=By.xpath("//div[@class='choices__games__page__game choices__games__page__game--playable'][1]//img");
	By image2=By.xpath("//div[@class='choices__games__page__game choices__games__page__game--playable'][2]//img");
	By image3=By.xpath("//div[@class='choices__games__page__game choices__games__page__game--playable'][3]//img");
	By image4=By.xpath("//div[@class='choices__games__page__game choices__games__page__game--playable'][4]//img");
	By choices=By.xpath("//div[@class='choices__games__page']");
	
	PathGamePage gp;
	
	
	public KenoGameChoicesPage(WebDriver driver)
	{
		this.driver=driver;
	}
	public void palyGames()
	{
		playable=new ArrayList<WebElement>();
		playable=driver.findElements(playableGame);
		
		unplayable=new ArrayList<WebElement>();
		unplayable=driver.findElements(completedGames);
		
		
	}
	public void selectGame() throws InterruptedException
	{
		wait=new WebDriverWait(driver,800);
		wait.until(ExpectedConditions.visibilityOfElementLocated(choices));
		gp=new PathGamePage(driver);
		
		
		if(driver.findElements(game1).size()!=0)
		{
			String s=driver.findElement(image1).getAttribute("alt");
			System.out.println(s);
			driver.findElement(game1).click();
			
			if(s.contains("IWPATH"))
			{
				gp.playScratchGame();
			}
			else if(s.contains("set-for-life"))
			{
				gp.playSfl();
			}
			else
			{
				gp.playSlots();
			}
		}
		if(driver.findElements(game2).size()!=0)
		{
			String s=driver.findElement(image2).getAttribute("alt");
			System.out.println(s);
			driver.findElement(game2).click();
			if(s.contains("IWPATH"))
			{
				gp.playScratchGame();
			}
			else if(s.contains("set-for-life"))
			{
				gp.playSfl();
			}
			else
			{
				gp.playSlots();
			}
		}
		if(driver.findElements(game3).size()!=0)
		{
			String s=driver.findElement(image3).getAttribute("alt");
			System.out.println(s);
			driver.findElement(game3).click();
			if(s.contains("IWPATH"))
			{
				gp.playScratchGame();
			}
			else if(s.contains("set-for-life"))
			{
				gp.playSfl();
			}
			else
			{
				gp.playSlots();
			}
			
		}
		if(driver.findElements(game4).size()!=0)
		{
			String s=driver.findElement(image4).getAttribute("alt");
			System.out.println(s);
			driver.findElement(game4).click();
			if(s.contains("IWPATH"))
			{
				gp.playScratchGame();
			}
			else if(s.contains("set-for-life"))
			{
				gp.playSfl();
			}
			else
			{
				gp.playSlots();
			}
			
		}
	}
	
	//when you want to skip the game to reach Bonus Game Page early
	public void forwardGame()
	{
		wait=new WebDriverWait(driver,800);
		wait.until(ExpectedConditions.visibilityOfElementLocated(choices));
		gp=new PathGamePage(driver);
		
		if(driver.findElements(game1).size()!=0)
		{
			String s=driver.findElement(image1).getAttribute("alt");
			System.out.println(s);
			driver.findElement(game1).click();
			
			if(s.contains("IWPATH"))
			{
				gp.forwardScratchGame();
			}
			else if(s.contains("set-for-life"))
			{
				gp.forwardSfl();
			}
			else
			{
				gp.forwardSlots();
			}
		}
		if(driver.findElements(game2).size()!=0)
		{
			String s=driver.findElement(image2).getAttribute("alt");
			System.out.println(s);
			driver.findElement(game2).click();
			if(s.contains("IWPATH"))
			{
				gp.forwardScratchGame();
			}
			else if(s.contains("set-for-life"))
			{
				gp.forwardSfl();
			}
			else
			{
				gp.forwardSlots();
			}
		}
		if(driver.findElements(game3).size()!=0)
		{
			String s=driver.findElement(image3).getAttribute("alt");
			System.out.println(s);
			driver.findElement(game3).click();
			if(s.contains("IWPATH"))
			{
				gp.forwardScratchGame();
			}
			else if(s.contains("set-for-life"))
			{
				gp.forwardSfl();
			}
			else
			{
				gp.forwardSlots();
			}
			
		}
		if(driver.findElements(game4).size()!=0)
		{
			String s=driver.findElement(image4).getAttribute("alt");
			System.out.println(s);
			driver.findElement(game4).click();
			if(s.contains("IWPATH"))
			{
				gp.forwardScratchGame();
			}
			else if(s.contains("set-for-life"))
			{
				gp.forwardSfl();
			}
			else
			{
				gp.forwardSlots();
			}
			
		}
		
	}
	
	
	

	

}
