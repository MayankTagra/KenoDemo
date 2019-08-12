package PchCom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PchComHomePage {
	WebDriver driver=null;
	WebDriverWait wait=null;
	By signInButton=By.xpath("//nav[@class='uninav__unrecognized']//ul//li[1]//a");
	
	public PchComHomePage(WebDriver driver)
	{	

		this.driver=driver;
	}
	public void clickSignIn()
	{
		wait=new WebDriverWait(driver,800);
		wait.until(ExpectedConditions.visibilityOfElementLocated(signInButton));
		driver.findElement(signInButton).click();
		
	}

}
