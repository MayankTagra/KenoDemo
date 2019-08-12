package Package1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestFrameHome {
	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","C:\\chromeDriver\\chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.setPageLoadStrategy(PageLoadStrategy.NONE);
		WebDriver driver=new ChromeDriver(options);
		
		driver.get("https://keno.qa.pch.com");
		driver.manage().window().maximize();
		
		List<WebElement> al=new ArrayList<WebElement>();
		List<WebElement> all=new ArrayList<WebElement>();
		
		WebDriverWait wait=new WebDriverWait(driver,800);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='main-content']")));
		Thread.sleep(23000);
		
		int s=driver.findElements(By.xpath("//div[@id]")).size();
		System.out.println(s);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//aside//iframe")));
		int iframeSize=driver.findElements(By.xpath("//iframe[@id]")).size();
		System.out.println("IFrame Size"+" "+iframeSize);
		
		al=driver.findElements(By.xpath("//iframe[@id]"));
		for(WebElement w:al)
		{
			if(w.getAttribute("id").contains("google_ads_iframe"))
			{
				all.add(w);
				
				
			}
		}
		//Iframe that contains add
		System.out.println("Frames that contains add");
		
		Iterator<WebElement> itr=all.iterator();
		while(itr.hasNext())
		{
			System.out.println(itr.next());
			
		}
		
		
		/*
		 * al=driver.findElements(By.xpath("//iframe[@id]")); System.out.println(al);
		 * System.out.println(al.size());
		 * 
		 * int size=driver.findElements(By.tagName("iframe")).size();
		 * 
		 * 
		 * System.out.println("Size"+" "+size);
		 */
		
	
		
		
		
		
		
		
	}

}
