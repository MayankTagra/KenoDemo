package Package1;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Garb {
	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","C:\\chromeDriver\\chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.setPageLoadStrategy(PageLoadStrategy.NONE);
		WebDriver driver=new ChromeDriver(options);
		
		driver.get("https://keno.qa.pch.com/");
		driver.manage().window().maximize();
		
		WebDriverWait wait=new WebDriverWait(driver,800);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='card__clock']")));
		Thread.sleep(9000);
	String s=	driver.findElement(By.xpath("//div[@class='card__clock']")).getAttribute("class");
	System.out.println(s);
	
		
	
	}

}
