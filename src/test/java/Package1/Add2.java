package Package1;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Add2 {
	public static void main(String[] args)
	{	
		
		System.setProperty("webdriver.chrome.driver","C:\\chromeDriver\\chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.setPageLoadStrategy(PageLoadStrategy.NONE);
		WebDriver driver=new ChromeDriver(options);
		
		driver.get("https://keno.qa.pch.com");
		driver.manage().window().maximize();
		
		WebDriverWait wait=new WebDriverWait(driver,800);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//aside//iframe")));
		
		//As all the adds are located inside a frame so you have to switch to that specific frame
		driver.switchTo().frame(1);
		Dimension dd=driver.findElement(By.tagName("body")).getSize();
		System.out.println("Dimmenions of this add are");
		System.out.println("Height");
		System.out.println(dd.getHeight());
		
		System.out.println("Width");
		System.out.println(dd.getWidth());
		
		
		
	
		
	}

}
