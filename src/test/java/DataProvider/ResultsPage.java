package DataProvider;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PchCom.KenoHomePage;
import PchCom.KenoSignInPage;

public class ResultsPage {
	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","C:\\chromeDriver\\chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.setPageLoadStrategy(PageLoadStrategy.NONE);
		WebDriver driver=new ChromeDriver(options);
		
		driver.get("http://keno.qa.pch.com");
		driver.manage().window().maximize();
		
		KenoHomePage homePage=new KenoHomePage(driver);
		homePage.clickSignIn();
		
		KenoSignInPage signInPage=new KenoSignInPage(driver);
		signInPage.Login("res123CH@pchmail.com","pch123");
		
		WebDriverWait wait=new WebDriverWait(driver,800);
		Thread.sleep(19000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//nav[@id='mainnav']//ul//li[4]")));
		
		driver.findElement(By.xpath("//nav[@id='mainnav']//ul//li[4]")).click();
		System.out.println("result");
		
		
		
		
		
		
	}

}
