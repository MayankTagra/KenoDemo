package PchCom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PchComSignIn {
	
	WebDriver driver=null;
	WebDriverWait wait=null;
	
	By email=By.id("EM");
	By password=By.id("PW");
	By signInButton=By.id("login-sub-btn");
	
	public PchComSignIn(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void setEmail(String myemail)
	{	
		wait=new WebDriverWait(driver,800);
		wait.until(ExpectedConditions.visibilityOfElementLocated(email));
		
		driver.findElement(email).sendKeys(myemail);
	}
	public void SetPassword(String mypassword)
	{
		driver.findElement(password).sendKeys(mypassword);
	}
	public void clickButton()
	{
		wait=new WebDriverWait(driver,800);
		wait.until(ExpectedConditions.visibilityOfElementLocated(signInButton));
		driver.findElement(signInButton).click();
	}
	public void signIn(String myemail,String mypassword)

	{
		this.setEmail(myemail);
		this.SetPassword(mypassword);
		this.clickButton();
		try
		{	
			Thread.sleep(4000);
			this.clickButton();
			
		}
		catch(Exception e)
		{
			System.out.println("Already clicked");
		}

	}
}
