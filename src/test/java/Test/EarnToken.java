package Test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import PchCom.BaseTest;
import PchCom.KenoAccountsPage;
import PchCom.KenoHomePage;
import PchCom.KenoLoginedUserHomePage;
import PchCom.KenoSignInPage;

public class EarnToken extends BaseTest{
	KenoHomePage homePage;
	KenoSignInPage signInPage;
	KenoLoginedUserHomePage loginnedUser;
	KenoAccountsPage accountsPage;
	
	
	
	
	WebDriver driver;		
	@Test()
	public void earnToearn() throws InterruptedException
	{
		test=report.createTest("Earn Token");
		
		driver=getDriverWithoutAddBlocker();
		driver.get("https://keno.qa.pch.com/");
		driver.manage().window().maximize();
		homePage=new KenoHomePage(driver);
		homePage.clickSignIn();
		
		signInPage=new KenoSignInPage(driver);
		signInPage.Login("vip212@pchmail.com","pch123");
		
		loginnedUser=new KenoLoginedUserHomePage(driver);
		loginnedUser.clickTokenHistory();
		Thread.sleep(33000);
		accountsPage=new KenoAccountsPage(driver);
		
		accountsPage.openEarnToken();
		accountsPage.closeEarnToken();
		
		
		
		
		
	}

}
