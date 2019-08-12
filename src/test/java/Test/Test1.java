package Test;

import java.io.File;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PchCom.KenoHomePage;
import PchCom.KenoSignInPage;

public class Test1 {
	
	KenoHomePage homePage;
	KenoSignInPage signInPage;
	WebDriver driver;
	//WebDriverWait wait=new WebDriverWait(driver,800);
	
	@BeforeTest()
	public void Setup()
	{
		System.setProperty("webdriver.chrome.driver","C:\\chromeDriver\\chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.setPageLoadStrategy(PageLoadStrategy.NONE);
		options.addExtensions(new File("E:\\chrome_Extensions\\chrome1.crx"));
		options.addExtensions(new File("E:\\chrome_Extensions\\chrome1.crx"));
		
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(options.CAPABILITY, options);
		 driver=new ChromeDriver(options);
		 driver.get("https://keno.qa.pch.com/");
		 driver.manage().window().maximize();
		
	}
	@Test()
	public void Signin()
	{	
		String pch=null,add;
		Set<String> al=driver.getWindowHandles();
		Iterator<String> itr=al.iterator();
		while(itr.hasNext())
		{
			pch=itr.next();
			add=itr.next();
		}
		driver.switchTo().window(pch);
		homePage=new KenoHomePage(driver);
		homePage.clickSignIn();
		signInPage=new KenoSignInPage(driver);
		signInPage.Login("vip212@pchmail.com","pch123");
		
		
		
	}
	
	

}
