package PchCom;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class KenoResultPage extends BaseTest {
	
	WebDriver driver;
	XSSFSheet sheet;
	By desktopOrTablet=By.xpath("//ul[@class='results__nav nav navbar-nav']//li[1]//a");
	By mobile=By.xpath("//ul[@class='results__nav nav navbar-nav']//li[2]//a");
	By app=By.xpath("//ul[@class='results__nav nav navbar-nav']//li[3]//a");
	By spanCalendar=By.cssSelector("label[class='form-label results__form__date']");
//	By selectDate=By.xpath("//tbody//tr//td//button[@data-pika-day=\""+value+"\"]");
	
	By disabledPrevious=By.xpath("//button[@class='pika-prev is-disabled']");
	By disbaledNext=By.xpath("//button[@class='pika-next is-disabled']");
	By enabledPrevious=By.xpath("//button[@class='pika-prev is-enabled']");
	By enabledNext=By.xpath("//button[@class='pika-next is-enabled']");
	By goButton=By.xpath("//button[@type='submit']");
	By selectricScroll=By.xpath("//div[@class='selectric-scroll']");
	By timeLabel=By.xpath("//div[@class='selectric']");
	By timeList=By.xpath("//div[@class='selectric-scroll']//ul");
	Actions builder;
	/*
	 * XPathFactory xpathFactory=XPathFactory.newInstance(); XPath
	 * xpath=xpathFactory.newXPath(); XPathExpression
	 * xPathExpr=xpath.compile("//tbody//tr//td//button[@data-pika-day="+value+"]");
	 */
	
	
	WebDriverWait wait;
	List<String> all=new ArrayList<String>();
	List<WebElement> al=new ArrayList<WebElement>();
	Map<String,WebElement> hm=new HashMap<String,WebElement>();
	Iterator<String> itr;
	Iterator<WebElement> itr1;
	WebElement ws;
	
	
	public KenoResultPage(WebDriver driver)
	{
		this.driver=driver;
	}
	//For Selecting Desktop or Tablet Option
	public void clickDesktopOption()
	{	
		wait=new WebDriverWait(driver,800);
		wait.until(ExpectedConditions.visibilityOfElementLocated(desktopOrTablet));
		driver.findElement(desktopOrTablet).click();
	
	}
	
	//For selecting Mobile Option
	public void clickMobileOption()
	{
		wait=new WebDriverWait(driver,800);
		wait.until(ExpectedConditions.visibilityOfElementLocated(mobile));
		driver.findElement(mobile).click();
	}
	//For selecting App Option
	public void clickAppOption()
	{
		wait=new WebDriverWait(driver,800);
		wait.until(ExpectedConditions.visibilityOfElementLocated(app));
		driver.findElement(app).click();

	}
	//tbody//tr//td//button[@data-pika-day='22']
	
	//This click the calendar Label after this the calendar will get popuped
	public void clickCalendar() throws InterruptedException
	{
		wait=new WebDriverWait(driver,800);
		
		Thread.sleep(43000);
		
		driver.findElement(spanCalendar).click();
		
	}
	//This will select a date from the calendar
	public void selectDate(int day) throws IOException
	{
		sheet=calendarSheet();
		
		try
		{
			if(driver.findElements(By.xpath(""+sheet.getRow(day).getCell(2).toString()+"")).size() !=0)
			{	
				if(driver.findElements(disabledPrevious).size()!=0)
				{
					System.out.println("Date can't be clicked");
				}
				if(driver.findElements(enabledPrevious).size()!=0)
				{
					driver.findElement(enabledPrevious).click();
					if(driver.findElements(By.xpath(""+sheet.getRow(day).getCell(2).toString()+"")).size()!=0)
					{
						System.out.println("Date can't be clicked");
					}
					else
					{
						driver.findElement(By.xpath(""+sheet.getRow(day).getCell(1).toString()+"")).click();
						
					}
				}
				
			}
			else
			{
				driver.findElement(By.xpath(""+sheet.getRow(day).getCell(1)+"")).click();
				
			}
		}
		catch(Exception e)
		{	System.out.println(e);
		
			System.out.println("Exception Occured");
		}
	}
	//Clicking the GoButton
	public void clickGoButton()
	{
		wait=new WebDriverWait(driver,800);
		wait.until(ExpectedConditions.visibilityOfElementLocated(goButton));
		driver.findElement(goButton).click();
	}
	//Select the Desired Time
	public void SelectTime(String time) throws InterruptedException
	{
		wait=new WebDriverWait(driver,800);
		Thread.sleep(2300);
		driver.findElement(timeLabel).click();
		Thread.sleep(3400);
		al=driver.findElement(selectricScroll).findElements(By.tagName("li"));	
		
		for(WebElement g:al)
		{
			System.out.println(g);
		}
	
	//	wait.until(ExpectedConditions.visibilityOfElementLocated(selectricScroll));
		
		for(int i=0;i<al.size();i++) {
			//String tagTeat=driver.findElement(By.xpath("//div[@class='selectric-scroll']//ul//li["+i+"]")).getText();
			
			String value=al.get(i).getText();
			all.add(value);
			
			
			
		}
		for(String s:all)
		{
			System.out.println(s);
		}
		
		itr=all.iterator();
		itr1=al.iterator();
		
		
		while(itr.hasNext() && itr1.hasNext())
		{
			hm.put(itr.next(),itr1.next());
		}
		System.out.println(hm);
		builder=new Actions(driver);
		for(String s:all)
		{
			if(s.equalsIgnoreCase(time))
			{
				ws=hm.get(s);
				if(ws.getAttribute("class").contains("disabled"))
				{
					System.out.println("Element Unclickable");
				}
				else
				{
					builder.moveToElement(ws).click().build().perform();
				}
			}
		}
		
	}
	
	public void resultDesktop(int d,String t) throws InterruptedException, IOException
	{	
		//provide date as 1,2,3--31  and time 02:00 PM ET or 02:00 AM ET
		this.clickDesktopOption();
		this.clickCalendar();
		this.selectDate(d);
		this.SelectTime(t);
		this.clickGoButton();
		
	}
	public void resultMobile(int d,String t) throws InterruptedException, IOException
	{	
		//provide date as 1,2,3--31  and time 02:00 PM ET or 02:00 AM ET
		this.clickMobileOption();
		this.clickCalendar();
		this.selectDate(d);
		this.SelectTime(t);
		this.clickGoButton();
	}
	public void resultApp(int d,String t) throws InterruptedException, IOException
	{	
		//provide date as 1,2,3--31  and time 02:00 PM ET or 02:00 AM ET
		this.clickAppOption();
		this.clickCalendar();
		this.selectDate(d);
		this.SelectTime(t);
		this.clickGoButton();
		
	}
	
}
