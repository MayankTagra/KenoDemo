package PchCom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SlotsPage {
	WebDriver driver=null;
	WebDriverWait wait=null;
	By slotsBanner=By.xpath("//div[@class='slots__home-featured__container']//img");
	
	
	public SlotsPage(WebDriver driver)
	{
		this.driver=driver;
	}
	public void clickSlotsBanner()
	{	
		wait=new WebDriverWait(driver,800);
		wait.until(ExpectedConditions.visibilityOfElementLocated(slotsBanner));
		driver.findElement(slotsBanner).click();
	}
	

}
