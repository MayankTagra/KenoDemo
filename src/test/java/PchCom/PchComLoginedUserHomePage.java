package PchCom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PchComLoginedUserHomePage {
	WebDriver driver=null;
	WebDriverWait wait=null;
	
	By home=By.xpath("//ul[@class='menu']//li[1]//a");
	By vip=By.xpath("//ul[@class='menu']//li[2]//a");
	By tokenGames=By.xpath("//ul[@class='menu']//li[3]//a");
	By slots=By.xpath("//ul[@class='menu']//li[4]//a");
	By instantWin=By.xpath("//ul[@class='menu']//li[5]//a");
	By scratchOffs=By.xpath("//ul[@class='menu']//li[6]//a");
	By sweepStakes=By.xpath("//ul[@class='menu']//li[7]//a");
	By winners=By.xpath("//ul[@class='menu']//li[8]//a");
	By tourPch=By.xpath("//ul[@class='menu']//li[9]//a");
	
	public	PchComLoginedUserHomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void clickHomeTab()
	{
		wait=new WebDriverWait(driver,800);
		wait.until(ExpectedConditions.visibilityOfElementLocated(home));
		driver.findElement(home).click();
		
	}
	public void clickVipTab()
	{	
		wait=new WebDriverWait(driver,800);
		wait.until(ExpectedConditions.visibilityOfElementLocated(vip));
		driver.findElement(vip).click();
		
		
	}
	
	public void clickTokenGames()
	{
		wait=new WebDriverWait(driver,800);
		wait.until(ExpectedConditions.visibilityOfElementLocated(tokenGames));
		driver.findElement(tokenGames).click();		
	}
	
	public void clickSlots()
	{	
		wait=new WebDriverWait(driver,800);
		wait.until(ExpectedConditions.visibilityOfElementLocated(slots));
		driver.findElement(slots).click();
		
		
	}
	
	public void clickInstantWin()
	{
		wait=new WebDriverWait(driver,800);
		wait.until(ExpectedConditions.visibilityOfElementLocated(instantWin));
		driver.findElement(instantWin).click();
	}
	public void clickScratchOffs()
	{
		wait=new WebDriverWait(driver,800);
		wait.until(ExpectedConditions.visibilityOfElementLocated(scratchOffs));
		driver.findElement(scratchOffs).click();
	}
	public void clickSweepStakes()
	{	
		wait=new WebDriverWait(driver,800);
		wait.until(ExpectedConditions.visibilityOfElementLocated(sweepStakes));
		driver.findElement(sweepStakes).click();
		
	}
	public void clickWinners()
	{
		wait=new WebDriverWait(driver,800);
		wait.until(ExpectedConditions.visibilityOfElementLocated(winners));
		driver.findElement(winners).click();
		
	}
	public void clickTourPch()
	{
		wait=new WebDriverWait(driver,800);
		wait.until(ExpectedConditions.visibilityOfElementLocated(tourPch));
		driver.findElement(tourPch).click();
	}
	
}
