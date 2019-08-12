package PchCom;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SlotsTournamentPage {
	WebDriver driver;
	WebDriverWait wait;
	Actions builder;
	HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
	List<WebElement> wl=new ArrayList<WebElement>();
	List<Integer> al=new ArrayList<Integer>();
	Integer myScore;
	
	
	
	
	By canvas=By.xpath("//canvas[@width='799']");
	By tokenPayout=By.xpath("//div[@class='token-payout-box']//ul");
	By score=By.className("score");
	By token=By.className("token");
	By gos=By.xpath("//div[@class='gos--main']");
	By yourScore=By.xpath("//div[@class='gos-payout gos__text-color--white']//div[@class='gos-payout__amt']");
	By tokenEarned=By.xpath("//div[@class='gos-payout gos__text-color--gold']//div[@class='gos-payout__amt']");
	
	
	public SlotsTournamentPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void TokenPayout()
	{
		//builder.moveToElement(target).moveByOffset().click().build().perform();
		//canvas centres are reached as follows 799x432->398x216
		//PlayButton Desired Coordinates ->126x151
		builder=new Actions(driver);
		wait=new WebDriverWait(driver,800);
		wait.until(ExpectedConditions.visibilityOfElementLocated(canvas));
		builder.moveToElement(driver.findElement(canvas)).moveByOffset(126, -151).click().build().perform();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(tokenPayout));
		int size=driver.findElement(tokenPayout).findElements(By.tagName("li")).size();
		wl=driver.findElement(tokenPayout).findElements(By.tagName("li"));
		
		System.out.println("Size"+" "+size);
		for(int i=1;i<size;i++)
		{	
			String  score=wl.get(i).findElement(By.className("score")).getText();

			
			
			//String score=driver.findElement(By.xpath("//div[@class='token-payout-box']//ul//li["+i+"]//span[@class='score']")).getText();
			System.out.println(score);
			int n=score.length();
			String fscore=score.substring(0, n-1);
			Integer finalScore=Integer.parseInt(fscore);
			System.out.println("finalScore");
			
			//String tokens=driver.findElement(By.xpath("//div[@class='token-payout-box']//ul//li["+i+"]//span[@class='token']")).getText();
			String tokens=wl.get(i).findElement(By.className("token")).getText();
			
			System.out.println(tokens);
			Integer finalToken=Integer.parseInt(tokens);
			System.out.println(finalToken);
			
			hm.put(finalScore,finalToken);
			al.add(finalScore);
			
			
		}
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='token-payout-box__close']")));
		driver.findElement(By.xpath("//div[@class='token-payout-box__close']")).click();
	}
		public void clickSpin()
		{	
			builder=new Actions(driver);
			wait=new WebDriverWait(driver,800);
			wait.until(ExpectedConditions.visibilityOfElementLocated(canvas));
	
			builder.moveToElement(driver.findElement(canvas)).moveByOffset(198, 159).click().build().perform();

			
		}
		public void evaluateGOS()
		{
			//div[@class='gos--main']//div[@class='gos-payout__amt']
			wait=new WebDriverWait(driver,800);
			wait.until(ExpectedConditions.visibilityOfElementLocated(gos));
			
			String score=driver.findElement(yourScore).getText();
			System.out.println("Score"+" "+score);
			
			char[] c=new char[score.length()];
			StringBuilder sb=new StringBuilder(score);
				
			for(int i=0;i<score.length();i++) {
				if(score.charAt(i)==',')
				{
					sb.deleteCharAt(i);
					
				}
			}
			String finalScore=sb.toString();
			System.out.println("FinalScore"+" "+finalScore);
			Integer fScore=Integer.parseInt(finalScore);
			
			
			
			String tokens=driver.findElement(tokenEarned).getText();
			System.out.println("Tokens Earned"+" "+tokens);
			Integer tScore=Integer.parseInt(tokens);
			
			//Now to find where does your score lie and how many tokens you must be awarded.
			for(int i=0;i<al.size();i++)
			{
				if(al.get(0)==0)
				{
					myScore=0;
					break;
				}
				if((fScore>al.get(i))&&(fScore<=al.get(i+1)))
				{
					myScore=hm.get(al.get(i));
					break;
				}
			}
			//To Evaluate whether score is as per the table
			if(myScore==tScore)
			{
				System.out.println("Test case passed Successfully");
			}
			else
			{
				System.out.println("Test case Failed");
			}
		}
	
	

}
