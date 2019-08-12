package Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import PchCom.BaseTest;
import PchCom.KenoHomePage;

public class AddTest extends BaseTest{
	
	WebDriver driver;
	WebDriverWait wait;
	
	KenoHomePage homePage;
	
	@Test()
	public void testAddOnHomePage() throws InterruptedException
	{	
		test=report.createTest("Add Size Check Test Case");
		
		driver=getDriverWithoutAddBlocker();
		driver.get("https://keno.qa.pch.com");
		driver.manage().window().maximize();
		
		homePage=new KenoHomePage(driver);
		homePage.getAddsSize();
		System.out.println("Execution Successful");
		
		
		
		
		
	}
}
