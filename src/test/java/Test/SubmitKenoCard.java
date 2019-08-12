package Test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import PchCom.BaseTest;
import PchCom.KenoHomePage;
import PchCom.KenoLoginedUserHomePage;
import PchCom.KenoSignInPage;

public class SubmitKenoCard extends BaseTest{
	
	WebDriver driver;
	KenoHomePage homePage;
	KenoSignInPage signInPage;
	KenoLoginedUserHomePage loginHomePage;
	
	@Test()
	public void firstKenoCard() throws InterruptedException
	{	
		test=report.createTest("Submit Keno Card");
		driver=getDriverWithoutAddBlocker();
		
		driver.get("https://keno.qa.pch.com/");
		driver.manage().window().maximize();
		homePage=new KenoHomePage(driver);
		homePage.clickSignIn();
		
		signInPage=new KenoSignInPage(driver);
		signInPage.Login("vip212@pchmail.com","pch123");
		
		loginHomePage=new KenoLoginedUserHomePage(driver);
		loginHomePage.submitKenoCard(34, 21, 5, 6, 7, 8, 22, 89, 11, 46);
		
		

		System.out.println("Was Execution Successfull");
		
		
		
		
		
		
	}

}
