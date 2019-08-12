package PchCom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class KenoHomePage {
	WebDriver driver;
	By signin=By.xpath("//nav[@class='uninav__unrecognized']//ul//li[1]//a");
	By register=By.xpath("//nav[@class='uninav__unrecognized']//ul//li[2]//a");
	By howItWorks=By.xpath("//div[@class='kenobar__controls']//button[2]");
	By payTable=By.xpath("//div[@class='kenobar__controls']//button[1]");
	By closePayTable=By.xpath("//div[@class='kenobar__paytable']//button[@class='close']");
	By next=By.xpath("//div[@class='tutorial__controls']//button[2]");//Next button under how it works
	By previous=By.xpath("//div[@class='tutorial__controls']//button[1]");//Previous button under how it works
	By firstFrame=By.xpath("//div[@id='main-content']//iframe");
	By framesOnPage=By.xpath("//iframe[@id]");
	By asideFrame=By.xpath("//aside//iframe");
	By rightframe=By.xpath("//iframe[@height='600']");
	
	
	By addinFrame=By.xpath("//div[@data-item-id]");
	By frameId=By.xpath("//iframe[@id]");
	By adds=By.xpath("//iframe[@data-google-container-id]");
	
	
	WebDriverWait wait;
	List<WebElement> al;
	List<WebElement> all;
	List<WebElement> asideList;
	
	
	
	
	public KenoHomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void clickSignIn()
	{	wait=new WebDriverWait(driver,800);
		wait.until(ExpectedConditions.visibilityOfElementLocated(signin));
		driver.findElement(signin).click();
	}
	public void clickRegister()
	{	wait=new WebDriverWait(driver,800);
		wait.until(ExpectedConditions.visibilityOfElementLocated(register));
		driver.findElement(register).click();
	}
	public void Click_HowItWorks() throws InterruptedException
	{
		wait=new WebDriverWait(driver,800);
		wait.until(ExpectedConditions.visibilityOfElementLocated(howItWorks));
		Thread.sleep(1300);
		driver.findElement(howItWorks).click();		
	}
	public void ClickNext_HowItWorks()
	{
		wait=new WebDriverWait(driver,800);
		wait.until(ExpectedConditions.visibilityOfElementLocated(next));
		driver.findElement(next).click();
		
	}
	public void ClickPrevious_HowItWorks()
	{
		wait=new WebDriverWait(driver,800);
		wait.until(ExpectedConditions.visibilityOfElementLocated(previous));
		driver.findElement(previous).click();
		
	}
	public  void clickPayTable()
	{
		wait=new WebDriverWait(driver,800);
		wait.until(ExpectedConditions.visibilityOfElementLocated(payTable));
		driver.findElement(payTable).click();
		
	}
	public void closePayTable() throws InterruptedException
	{
		wait=new WebDriverWait(driver,800);
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(closePayTable));
		driver.findElement(closePayTable).click();
		
	}

	public void getAddsSize() throws InterruptedException
	{
		wait=new WebDriverWait(driver,800);
		wait.until(ExpectedConditions.visibilityOfElementLocated(frameId));
		Thread.sleep(25000);
		
		int length=driver.findElements(adds).size();
		System.out.println("Number of Frames containing adds"+" "+length);
		try
		{
			for(int i=1;i<=length;i++)
			{
				WebElement w=driver.findElement(By.xpath("//iframe[@data-google-container-id=\""+i+"\"]"));
				driver.switchTo().frame(w);
				System.out.println("Entered inside the Frame");
				if(driver.findElements(addinFrame).size()!=0)
				{
					int size=driver.findElements(addinFrame).size();
					System.out.println("Size"+" "+size);
					al=driver.findElements(addinFrame);
					for(WebElement ss:al)
					{
						Dimension d=ss.getSize();
						System.out.println("Dimensions of add are"+d.getWidth()+"x"+d.getHeight());
					}
				}
				else
				{
					Dimension ds=driver.findElement(By.tagName("body")).getSize();
					System.out.println("Dimmensions of add are"+ds.getWidth()+"x"+ds.getHeight());
				}
				
				driver.switchTo().defaultContent();
				System.out.println("Moved out of the Frame");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();

		}
	}
	

}
