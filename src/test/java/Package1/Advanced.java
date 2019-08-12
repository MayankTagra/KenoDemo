package Package1;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PchCom.KenoHomePage;
import PchCom.KenoSignInPage;

public class Advanced {
	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","C:\\chromeDriver\\chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.setPageLoadStrategy(PageLoadStrategy.NONE);
		
		WebDriver driver=new ChromeDriver(options);
		
		driver.get("https://keno.qa.pch.com");
		driver.manage().window().maximize();
		
		WebDriverWait wait=new WebDriverWait(driver,800);
		KenoHomePage homePage=new KenoHomePage(driver);
		homePage.clickSignIn();
		
		KenoSignInPage signIn=new KenoSignInPage(driver);
		signIn.Login("res123CH@pchmail.com","pch123");
		
		
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='main-content']")));
		Thread.sleep(20000);
		driver.findElement(By.xpath("//div[@class='uninav__logoholder']")).click();
		System.out.println("Popup will appear after this");
		System.out.println("The Badge is clicked Successfully");
		Thread.sleep(5000);
		//For this span of time popup will remain on screen
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='vip-message__body']//span[@class='vip-message__close']")));
		driver.findElement(By.xpath("//div[@class='vip-message__body']//span[@class='vip-message__close']")).click();
		//click and close
		
		
		
		
		
	}

}
