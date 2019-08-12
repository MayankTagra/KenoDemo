package DataProvider;

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

public class HandlePopup {
	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","C:\\chromeDriver\\chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.setPageLoadStrategy(PageLoadStrategy.NONE);
		WebDriver driver=new ChromeDriver(options);
		
		driver.get("https://keno.qa.pch.com");
		driver.manage().window().maximize();
		
		KenoHomePage homePage=new KenoHomePage(driver);
		homePage.clickSignIn();
		KenoSignInPage signInPage=new KenoSignInPage(driver);
		signInPage.Login("vip212@pchmail.com","pch123");
	
		WebDriverWait wait=new WebDriverWait(driver,800);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='uninav__token-center-alltime__tokens-amount uninav__token-balance__amount']")));
		Thread.sleep(24000);
		driver.findElement(By.xpath("//p[@class='uninav__token-center-alltime__tokens-amount uninav__token-balance__amount']")).click();
		System.out.println("Popup Occured");
		
		//Switch to Frame
		WebElement w=driver.findElement(By.xpath("//iframe[@name='google_osd_static_frame']"));

		
		driver.switchTo().frame(w);
		System.out.println("Moved inside the Frame");
		Thread.sleep(500);
		/*
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * "//a[@class='token-feedback__links__link']")));
		 */
		
		driver.findElement(By.xpath("//a[@class='token-feedback__links__link']")).click();
		System.out.println("Token History Clicked");
		Thread.sleep(20000);
	
		
		
		
	}

}
