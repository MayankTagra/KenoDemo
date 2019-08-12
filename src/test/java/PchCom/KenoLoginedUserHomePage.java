package PchCom;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class KenoLoginedUserHomePage {
	WebDriver driver;
	WebDriverWait wait;
	
	By home=By.xpath("//nav[@id='mainnav']//ul//li[1]//a");
	By liveDrawing=By.xpath("//nav[@id='mainnav']//ul//li[2]//a");
	By previousDrawing=By.xpath("//nav[@id='mainnav']//ul//li[3]//a");
	By results=By.xpath("//nav[@id='mainnav']//ul//li[4]//a");
	By winners=By.xpath("//nav[@id='mainnav']//ul//li[5]//a");
	By minutes=By.xpath("//div[@class='kenobar']//span[@class='clock__minutes']");
	By seconds=By.xpath("//div[@class='kenobar']//span[@class='clock__seconds']");
	By tokenHistory=By.xpath("//div[@class='uninav__top-bar']//ul//li[3]//a");
	By myAccount=By.xpath("//div[@class='uninav__top-bar']//ul//li[2]//a");
	By signOut=By.xpath("//div[@class='uninav__top-bar']//ul//li[1]//a");
	By earnTokens=By.xpath("//div[@class='uninav__top-bar']//ul//li[4]//a");
	By cardNumbers=By.xpath("//ol[@class='card__numbers']");
	By submitButton=By.xpath("//div[@id='submit-button-container']//button");
	By quickPic=By.xpath("//button[@class='card__controls__btn card__controls__btn--quick btn btn-primary']");
	By clear=By.xpath("//div[@id='submit-button-container']//following-sibling::button[2]");
	By dailyBonusPopup=By.xpath("//div[@class='modal fade dailybonus in']");
	By dailyBonusButton=By.xpath("//div[@class='dailybonus__footer']//button");
	By clickBadge=By.xpath("//div[@class='uninav__logoholder']");
	By closeBadge=By.xpath("//div[@class='vip-message__body']//span[@class='vip-message__close']");

	By mainContent=By.id("main-content");
	
	By firstNumber=By.xpath("//li[@data-number='1']");
	
	JavascriptExecutor js;
	String m,s;
	Integer min,sec,totalTime;
	List<WebElement> al=new ArrayList<WebElement>();
	
	
	
	public KenoLoginedUserHomePage(WebDriver driver)
	{
		this.driver=driver;
		
	}
	
	public void clickHomeTab()
	{
		wait=new WebDriverWait(driver,800);
		wait.until(ExpectedConditions.visibilityOfElementLocated(home));
		driver.findElement(home).click();
		
	}
	public void clickLiveDrawingTab()
	{
		wait=new WebDriverWait(driver,800);
		wait.until(ExpectedConditions.visibilityOfElementLocated(liveDrawing));
		driver.findElement(liveDrawing).click();
	}
	public void clickPreviousDrawingTab()
	{
		wait=new WebDriverWait(driver,800);
		wait.until(ExpectedConditions.visibilityOfElementLocated(previousDrawing));
		driver.findElement(previousDrawing).click();
		
	}
	public void clickResultTab()
	{
		wait=new WebDriverWait(driver,800);
		wait.until(ExpectedConditions.visibilityOfElementLocated(results));
		driver.findElement(results).click();
	}
	public void WinnersTab()
	{
		wait=new WebDriverWait(driver,800);
		wait.until(ExpectedConditions.visibilityOfElementLocated(winners));
		driver.findElement(winners).click();
	}
	public void check_LiveDrawing() throws InterruptedException
	{	
		wait=new WebDriverWait(driver,800);
		wait.until(ExpectedConditions.visibilityOfElementLocated(minutes));
		m=driver.findElement(minutes).getText();
		s=driver.findElement(seconds).getText();
		
		min=Integer.parseInt(m);
		sec=Integer.parseInt(s);
		totalTime=min*60+sec;
		System.out.println(totalTime);
		
		if(totalTime<=90)
		{
			
			Thread.sleep(160000);
			System.out.println("Wait for 150 seconds,Live Drawing yet to be started");
		}
		else
		{	
			
			//Nothing needs to be done in this case 
			
		}
		
		
	
	}
	
	public void clickTokenHistory()
	{
		wait=new WebDriverWait(driver,800);
		wait.until(ExpectedConditions.visibilityOfElementLocated(tokenHistory));
		driver.findElement(tokenHistory).click();
	}
	public void clickMyAccount()
	{
		wait=new WebDriverWait(driver,800);
		wait.until(ExpectedConditions.visibilityOfElementLocated(myAccount));
		driver.findElement(myAccount).click();
		
	}
	public void clickEarnTokens()
	{
		wait=new WebDriverWait(driver,800);
		wait.until(ExpectedConditions.visibilityOfElementLocated(earnTokens));
		driver.findElement(earnTokens).click();
		
	}
	public void clickClear()
	{
		wait=new WebDriverWait(driver,800);
		wait.until(ExpectedConditions.visibilityOfElementLocated(clear));
		driver.findElement(clear).click();
	}
	
	public void clickSubmit()
	{	
		wait=new WebDriverWait(driver,800);
		wait.until(ExpectedConditions.visibilityOfElementLocated(submitButton));
		driver.findElement(submitButton).click();
		
		
	}
	
	public void clickQuickPick()
	{	
		wait=new WebDriverWait(driver,800);
		wait.until(ExpectedConditions.visibilityOfElementLocated(quickPic));
		driver.findElement(quickPic).click();
	
	}
	public void submitKenoCard(int a0,int a1,int a2,int a3,int a4,int a5,int a6,int a7,int a8,int a9) throws InterruptedException
	{
		wait=new WebDriverWait(driver,800);
		wait.until(ExpectedConditions.visibilityOfElementLocated(mainContent));
		wait.until(ExpectedConditions.visibilityOfElementLocated(firstNumber));
		
		Thread.sleep(3400);
		js=(JavascriptExecutor)driver;
		js.executeScript("document.querySelector(\"li[data-number='2']\").scrollIntoView()");
		Thread.sleep(3400);
		
		
	//	al.set(0, null);
		al=driver.findElement(cardNumbers).findElements(By.tagName("li"));
	
			
			
				try
				{
				al.get(a0-1).click();
				}
				catch(Exception e)
				{
					Thread.sleep(5000);
					al.get(a0-1).click();
				}
				try
				{
					al.get(a1-1).click();
				}
				catch(Exception e)
				{	Thread.sleep(5000);
					al.get(a1-1).click();
				}
				try {al.get(a2-1).click();}catch(Exception e) {Thread.sleep(10000); al.get(a2-1).click();}
				try {al.get(a3-1).click();}catch(Exception e) {Thread.sleep(10000); al.get(a3-1).click();}
				try {al.get(a4-1).click();}catch(Exception e) {Thread.sleep(10000); al.get(a4-1).click();}
				try {al.get(a5-1).click();}catch(Exception e) {Thread.sleep(10000); al.get(a5-1).click();}
				try {al.get(a6-1).click();}catch(Exception e) {Thread.sleep(10000); al.get(a6-1).click();}
				try {al.get(a7-1).click();}catch(Exception e) {Thread.sleep(10000); al.get(a7-1).click();}
				try {al.get(a8-1).click();}catch(Exception e) {Thread.sleep(10000); al.get(a8-1).click();}
				try {al.get(a9-1).click();}catch(Exception e) {Thread.sleep(10000); al.get(a9-1).click();}
					
			/*
			 * al.get(a3-1).click(); al.get(a4-1).click(); al.get(a5-1).click();
			 * al.get(a6-1).click(); al.get(a7-1).click(); al.get(a8-1).click();
			 * al.get(a9-1).click();
			 */
				
			
		
		
		
		
		/*
		 * if(driver.findElements(By.xpath("//div[@class='coachingContainer']")).size()=
		 * =0) { al.get(a0-1).click(); } else { Thread.sleep(9000);
		 * al.get(a0-1).click();
		 * 
		 * }
		 * if(driver.findElements(By.xpath("//div[@class='coachingContainer']")).size()=
		 * =0) { al.get(a1-1).click(); } else { Thread.sleep(9000);
		 * al.get(a1-1).click(); }
		 * if(driver.findElements(By.xpath("//div[@class='coachingContainer']")).size()=
		 * =0) { al.get(a2-1).click(); } else { Thread.sleep(9000);
		 * al.get(a2-1).click(); }
		 * 
		 * if(driver.findElements(By.xpath("//div[@class='coachingContainer']")).size()=
		 * =0) { al.get(a3-1).click(); } else { Thread.sleep(9000);
		 * al.get(a3-1).click(); }
		 * 
		 * if(driver.findElements(By.xpath("//div[@class='coachingContainer']")).size()=
		 * =0) { al.get(a4-1).click(); } else { Thread.sleep(9000);
		 * al.get(a4-1).click(); }
		 * 
		 * if(driver.findElements(By.xpath("//div[@class='coachingContainer']")).size()=
		 * =0) { al.get(a5-1).click(); } else { Thread.sleep(9000);
		 * al.get(a5-1).click(); }
		 * 
		 * if(driver.findElements(By.xpath("//div[@class='coachingContainer']")).size()=
		 * =0) { al.get(a6-1).click(); } else { Thread.sleep(9000);
		 * al.get(a6-1).click(); } ;
		 * if(driver.findElements(By.xpath("//div[@class='coachingContainer']")).size()=
		 * =0) { al.get(a7-1).click(); } else { Thread.sleep(9000);
		 * al.get(a7-1).click(); }
		 */
		
		/*
		 * if(driver.findElements(By.xpath("//div[@class='coachingContainer']")).size()=
		 * =0) { al.get(a8-1).click(); } else { Thread.sleep(9000);
		 * al.get(a8-1).click(); }
		 * 
		 * if(driver.findElements(By.xpath("//div[@class='coachingContainer']")).size()=
		 * =0) { al.get(a9-1).click(); } else { Thread.sleep(9000);
		 * al.get(a9-1).click(); }
		 * 
		 */
		
	}
	
	//On logging for First Time During a Day 
	public void checkDailyBonus()
	{
		try
		{
			wait=new WebDriverWait(driver,100);
			wait.until(ExpectedConditions.visibilityOfElementLocated(dailyBonusPopup));
			System.out.println("Popup appeared and is to be clicked");
			driver.findElement(dailyBonusButton).click();
			
		}
		catch(Exception e)
		{
			System.out.println("Exception Occured");
			System.out.println("Daily Bonus Popup not appeared");
		}
	}
	
	public void clickBadge() throws InterruptedException
	{
		wait=new WebDriverWait(driver,800);
		Thread.sleep(15000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(clickBadge));
		driver.findElement(clickBadge).click();
		
	}
	
	public void closeClickBadge() throws InterruptedException
	{
		wait=new WebDriverWait(driver,800);
		///wait.until(ExpectedConditions.visibilityOfElementLocated(""));
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(closeBadge));
		driver.findElement(closeBadge).click();
		
	}
	
	
	
}
