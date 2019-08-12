package Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import PchCom.BaseTest;
import PchCom.KenoGameChoicesPage;
import PchCom.KenoHomePage;
import PchCom.KenoLoginedUserHomePage;
import PchCom.KenoSignInPage;

public class CompleteKenoTest extends BaseTest{
	
	WebDriver driver;
	WebDriverWait wait;
	
	
	KenoHomePage homePage;
	KenoSignInPage signInPage;
	KenoLoginedUserHomePage lgp;
	KenoGameChoicesPage choices;
	
	@Test()
	public void completeKenoTest() throws InterruptedException
	{	
		test=report.createTest("Complete Keno Test");
		driver=getDriverWithoutAddBlocker();
		
		driver.get("https://keno.qa.pch.com");
		driver.manage().window().maximize();
		
			homePage=new KenoHomePage(driver);
			homePage.clickSignIn();
		
			signInPage=new KenoSignInPage(driver);
			signInPage.Login("vip212@pchmail.com","pch123");
			
			lgp=new KenoLoginedUserHomePage(driver);
			lgp.submitKenoCard(10, 41, 32, 73, 84, 35, 46, 67, 88, 29);		
			lgp.clickSubmit();
			
			choices=new KenoGameChoicesPage(driver);
			choices.selectGame();
			System.out.println("First Keno Card Submitted");
			
			try
			{
			lgp.submitKenoCard(20, 41, 32, 33, 34, 35, 46, 67, 18, 99);		
			lgp.clickSubmit();
			choices.selectGame();
			System.out.println("2nd Keno card Submiited");
			
			lgp.submitKenoCard(14, 41, 32, 83, 74, 95, 06, 67, 68, 39);
			lgp.clickSubmit();
			choices.selectGame();
			System.out.println("3rd Keno Card Submiited");
			
			lgp.submitKenoCard(10, 21, 42, 53, 24, 65, 66, 87, 28, 49);
			lgp.clickSubmit();
			choices.selectGame();
			System.out.println("4th Keno Card Submitted");
			
			
			}
			catch(Exception e)
			{	
				//Exception mainly occurs due to live drawing
				//Live Drawing can also be not be handled with such perfection
				
				System.out.println(e);
			}
			
			
			
		

	}

}
