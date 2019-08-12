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

public class AddSizeDefault {
	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","C:\\chromeDriver\\chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.setPageLoadStrategy(PageLoadStrategy.NONE);
		WebDriver driver=new ChromeDriver(options);
		
		driver.get("https://keno.qa.pch.com");
		driver.manage().window().maximize();
		
		WebDriverWait wait=new WebDriverWait(driver,800);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='card__clock']")));
		
		Thread.sleep(10000);
		System.out.println("On HomePage");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='main-content']//iframe")));
		Thread.sleep(5000);
		WebElement frame=driver.findElement(By.xpath("//div[@id='main-content']//iframe"));
		//Switch to Frame where in the add is present
		driver.switchTo().frame(0);
		System.out.println("Inside the Frame now");
		List<WebElement> al=new ArrayList<WebElement>();
		
		Dimension d=driver.findElement(By.tagName("body")).getSize();
		
		
		System.out.println("Height");
		System.out.println(d.getHeight());
		
		System.out.println("Width");
		System.out.println(d.getWidth());
		
		
		
		
	}

}
