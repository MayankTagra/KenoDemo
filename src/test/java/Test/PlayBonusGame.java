package Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import PchCom.BaseTest;
import PchCom.BonusGamePage;
import PchCom.KenoGameChoicesPage;
import PchCom.KenoHomePage;
import PchCom.KenoLoginedUserHomePage;
import PchCom.KenoSignInPage;

public class PlayBonusGame extends BaseTest{
	WebDriver driver;
	WebDriverWait wait;
	KenoHomePage homePage;
	KenoSignInPage signInPage;
	KenoLoginedUserHomePage lgp;
	KenoGameChoicesPage choices;
	BonusGamePage bonus;
	
	
	
	@Test()
	public void reachBonusGamePage() throws InterruptedException
	{	
		test=report.createTest("Play Bonus Game Test");
		driver=getDriverWithoutAddBlocker();
		driver.get("https://keno.qa.pch.com");
		driver.manage().window().maximize();
		
		homePage=new KenoHomePage(driver);
		homePage.clickSignIn();
		signInPage=new KenoSignInPage(driver);
		signInPage.Login("res123CH@pchmail.com","pch123");
		
		lgp=new KenoLoginedUserHomePage(driver);
		lgp.submitKenoCard(23, 11, 12, 53, 64, 65, 76, 87, 98, 19);
		lgp.clickSubmit();
		
		choices=new KenoGameChoicesPage(driver);
		choices.forwardGame();
		lgp.submitKenoCard(23, 31, 22, 93, 47, 57, 66, 87, 98, 19);
		lgp.clickSubmit();
		
		choices.forwardGame();
		lgp.submitKenoCard(21, 31, 92, 23, 04, 65, 46, 57, 18, 49);
		lgp.clickSubmit();
		choices.forwardGame();
		
		lgp.submitKenoCard(05, 16, 27, 99, 04, 55, 46, 07, 88, 67);
		lgp.clickSubmit();
		choices.forwardGame();
		//No game need to be played after this game.
		lgp.submitKenoCard(07,41, 72, 63, 14, 25, 24, 98,01,57);
		lgp.clickSubmit();
		//No Path games are left as they are 4 in number and thier are total of 5 cards
		System.out.println("Proceeded to Bonus Games");
		
		bonus=new BonusGamePage(driver);
		bonus.BonusGamePlay();
		
		
		
	}

}
