package Package1;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PchCom.KenoHomePage;
import PchCom.KenoSignInPage;

public class MytimeTokens {
	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","C:\\chromeDriver\\chromedriver.exe");
		ChromeOptions options =new ChromeOptions();
		options.setPageLoadStrategy(PageLoadStrategy.NONE);
		WebDriver driver=new ChromeDriver(options);
		
		driver.get("https://keno.qa.pch.com");
		driver.manage().window().maximize();
		
		
		
		WebDriverWait wait=new WebDriverWait(driver,800);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe[@id]")));
		
		KenoHomePage homePage=new KenoHomePage(driver);
		homePage.clickSignIn();
		KenoSignInPage signInPage=new KenoSignInPage(driver);
		signInPage.Login("vip212@pchmail.com","pch123");
		
		Thread.sleep(41000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='uninav__token-center-alltime__tokens uninav__token-balance uninav__token-center-alltime__tokens--has-message']")));
		
		driver.findElement(By.xpath("//div[@class='uninav__token-center-alltime__tokens uninav__token-balance uninav__token-center-alltime__tokens--has-message']")).click();
		System.out.println("Top Area Clicked");
		
		
		
		WebElement w=driver.findElement(By.xpath("//iframe[@name='google_osd_static_frame']"));
		driver.switchTo().frame(w);
		System.out.println("Moved inside the Frame");
		
	
		driver.findElement(By.xpath("//a[@class='token-feedback__links_link']")).click();
		driver.switchTo().defaultContent();
		
		System.out.println("Moved to Token  History");
		
		Thread.sleep(45000);
		driver.close();
		driver.quit();
		
		
		
		
		
	}

}
