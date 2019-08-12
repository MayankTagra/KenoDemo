package Package1;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PchCom.KenoHomePage;
import PchCom.KenoLoginedUserHomePage;
import PchCom.KenoSignInPage;


public class CaptureScreenshot {
	public static void main(String[] args) throws IOException
	{
		WebDriver driver = null;
		WebDriverWait wait=null;
		try
		{
			System.setProperty("webdriver.chrome.driver","C:\\chromeDriver\\chromedriver.exe");
			ChromeOptions options=new ChromeOptions();
			options.setPageLoadStrategy(PageLoadStrategy.NONE);
			driver=new ChromeDriver(options);
			driver.get("https://keno.qa.pch.com");
			driver.manage().window().maximize();
			wait=new WebDriverWait(driver,100);
			
			
			KenoHomePage homePage=new KenoHomePage(driver);
			homePage.clickSignIn();
			
			KenoSignInPage signIn=new KenoSignInPage(driver);
			signIn.Login("vi212@pchmail.com","pch123");
			
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='main-content']")));
			//If login user HomePage is not executed then thier is an error definitely.
			System.out.println("Loginned User Home Page");
			

			
			
		}
		catch(Exception e)
		{	
			/*
			 * System.out.println("Exception Occured Due to some unknown reason"); File
			 * screenshotFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			 * FileUtils.copyFile(screenshotFile, new
			 * File("E:\\softwareTeestingMaterial.png"));
			 */
			
			System.out.println("Exception Occured due to Some Unknown Reason");
			File screenshotFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshotFile, new File("E:\\softtwareTeestingMaterial.png"));
			
			System.out.println("");
		
		}
		driver.close();
	}

}
