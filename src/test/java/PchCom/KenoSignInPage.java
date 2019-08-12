package PchCom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class KenoSignInPage {
	WebDriver driver;
	By email=By.id("EM");
	By password=By.id("PW");
	By button=By.id("login-sub-btn");
	
	WebDriverWait wait;
	
	public KenoSignInPage(WebDriver driver)
	{
		this.driver=driver;
	}

	public void setEmail(String userEmail)
	{		
		wait=new WebDriverWait(driver,800);
		wait.until(ExpectedConditions.visibilityOfElementLocated(email));
		driver.findElement(email).sendKeys(userEmail);
	}
	public void setPassword(String userPassword)
	{		
		wait=new WebDriverWait(driver,800);
		wait.until(ExpectedConditions.visibilityOfElementLocated(password));
		driver.findElement(password).sendKeys(userPassword);
	}
	
	public void clickLogin()
	{		
		wait=new WebDriverWait(driver,800);
		wait.until(ExpectedConditions.visibilityOfElementLocated(button));
		driver.findElement(button).click();
		try
		{
			Thread.sleep(4000);
			driver.findElement(button).click();
		}
		catch(Exception e)
		{
			System.out.println("Already Clicked");
		}
	}
	
	public void Login(String userEmail,String userPassword)
	{
		this.setEmail(userEmail);
		this.setPassword(userPassword);
		this.clickLogin();
	}
	
}
