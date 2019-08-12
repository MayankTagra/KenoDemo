package Test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import PchCom.BaseTest;
import PchCom.KenoHomePage;
import PchCom.KenoLoginedUserHomePage;
import PchCom.KenoResultPage;
import PchCom.KenoSignInPage;

public class TestResult extends BaseTest {
	KenoHomePage kp;
	KenoSignInPage sp;
	KenoLoginedUserHomePage klp;
	KenoResultPage resultPage;
	
	
	@Test
	public void resultTest() throws InterruptedException, IOException
	{	
		test=report.createTest("Result Page Test");
		WebDriver driver;
		driver=getDriverWithoutAddBlocker();
		driver.get("https://keno.qa.pch.com/");
		driver.manage().window().maximize();
		kp=new KenoHomePage(driver);
		kp.clickSignIn();
		sp=new KenoSignInPage(driver);
		sp.Login("res123CH@pchmail.com", "pch123");
		klp=new KenoLoginedUserHomePage(driver);
		klp.clickResultTab();
		resultPage=new KenoResultPage(driver);
		
		resultPage.resultDesktop(20, "11:00 AM ET");
		
		System.out.println("Program successfully Executed");
		
		
		
	}

}
