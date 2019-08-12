package Package1;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
	
public class HandleAsideIframe {
	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver","C:\\chromeDriver\\chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.setPageLoadStrategy(PageLoadStrategy.NONE);
		WebDriver driver=new ChromeDriver(options);
			
		driver.get("http://keno.qa.pch.com");
		driver.manage().window().maximize();
		
		WebDriverWait wait=new WebDriverWait(driver,800);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//aside//iframe")));
		
		/*
		 * List<WebElement> al=new ArrayList<WebElement>(); List<WebElement> all=new
		 * ArrayList<WebElement>();
		 */
		
		
		
		WebElement iframe=driver.findElement(By.xpath("//aside//iframe"));
		driver.switchTo().frame(iframe);
		System.out.println("Entered inside right sided Frame");
		
		
		Dimension d=driver.findElement(By.tagName("body")).getSize();
		System.out.println("Right Side Dimensions");
		System.out.println(d.getHeight());
		System.out.println(d.getWidth());
		
	//The above is size of the body not the Size of the Add
		
		/*
		 * if(driver.findElements(By.xpath("//div[@data-item-id]")).size()!=0) { int
		 * size=driver.findElements(By.xpath("//div[@data-item-id]")).size();
		 * System.out.println(size);
		 * 
		 * List<WebElement> al=new ArrayList<WebElement>();
		 * al=driver.findElements(By.xpath("//div[@data-item-id]"));
		 * 
		 * for(WebElement ww:al) { Dimension dd=ww.getSize();
		 * System.out.println("Dimmensions are"+" "+dd.getHeight()+"X"+dd.getWidth());
		 * 
		 * }
		 * 
		 * 
		 * } else { System.out.println("Only one add that too of same size of body"); }
		 */
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-item-id]")));
		int addSize=driver.findElements(By.xpath("//div[@data-item-id]")).size();
		System.out.println(addSize);
		
		List<WebElement> addList=new ArrayList<WebElement>();
		addList=driver.findElements(By.xpath("//div[@data-item-id]"));
		if(addSize!=0)
		{
			for(WebElement w:addList)
			{
				Dimension ds=w.getSize();
				System.out.println("Dimmensiond are  "+ds.getHeight()+"X"+ds.getWidth());
				
			}
		}
		else
		{
			System.out.println("Add Size is same as Body Size");
		}
		
		
		//Successful Executed
	}

}
