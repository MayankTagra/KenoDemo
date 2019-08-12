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

public class PopupHandle {
	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","C:\\chromeDriver\\chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.setPageLoadStrategy(PageLoadStrategy.NONE);
		WebDriver driver=new ChromeDriver(options);
		
		driver.get("http://keno.qa.pch.com");
		driver.manage().window().maximize();
		
		WebDriverWait wait=new WebDriverWait(driver,800);
		driver.manage().window().maximize();
		
		KenoHomePage homePage=new KenoHomePage(driver);
		homePage.clickSignIn();
		
		KenoSignInPage signInPage=new KenoSignInPage(driver);
		signInPage.Login("vip212@pchmail.com","pch123");
		Thread.sleep(24000);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='uninav__token-center-alltime__tokens uninav__token-balance uninav__token-center-alltime__tokens--has-message")));
		
		driver.findElement(By.xpath("//div[@class='uninav__token-center-alltime__tokens uninav__token-balance uninav__token-center-alltime__tokens--has-message")).click();
		System.out.println("toast message appeared");
		
		
		WebElement web=driver.findElement(By.xpath("//iframe[@name='google_osd_static_frame']"));
		driver.switchTo().frame(web);
		System.out.println("Moved inside the Frame");
		
		WebElement tokenHistory=driver.findElement(By.xpath("//a[@class='token-feedback__links__link']"));
		tokenHistory.click();
		System.out.println("Clicked");
		
		driver.switchTo().defaultContent();
		System.out.println("Moved out of Frame");
		
		Thread.sleep(34000);
		System.out.println("end");
		driver.close();
		
		
		
		
		
		
		
		
		
	}

}
