package PchCom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class KenoAccountsPage {
	WebDriver driver;
	WebDriverWait wait;
	
	
	By myinfo=By.xpath("//ul[@class='tabset']//li[1]//a");
	By tokenHistory=By.xpath("//ul[@class='tabset']//li[2]//a");
	By rewards=By.xpath("//ul[@class='tabset']//li[3]//a");
	By firstName=By.xpath("//input[@name='FN']");
	By lastName=By.xpath("//input[@name='LN']");
	By streetAddress=By.xpath("//input[@name='A1']");
	By city=By.xpath("//input[@name='CI']");
	By state=By.xpath("//select[@name='ST']");
	By zip=By.xpath("//input[@name='ZI']");
	By month=By.xpath("//select[@name='MN']");
	By date=By.xpath("//select[@id='DY']");
	By year=By.xpath("//select[@name='YR']");
	By title=By.xpath("//select[@name='TI']");
	By updateButton=By.xpath("//input[@id='sub-myaccount-btn']");
	By earnToken=By.xpath("//div[@class='uninav__top-bar']//ul//li[4]//a");	
	By closeEarnToken=By.xpath("//div[@class='close']");
	
	Select selectState;
	Select selectMonth;
	Select selectDate;
	Select selectYear;
	Select selectTitle;

	
	public KenoAccountsPage(WebDriver driver)
	{
		this.driver=driver;
		
	}
	public void clickMyInfo()
	{
		wait=new WebDriverWait(driver,800);
		wait.until(ExpectedConditions.visibilityOfElementLocated(myinfo));
		driver.findElement(myinfo).click();
	}
	
	public void clickTokenHistory()
	{
		wait=new WebDriverWait(driver,800);
		wait.until(ExpectedConditions.visibilityOfElementLocated(tokenHistory));
		driver.findElement(tokenHistory).click();
	}
	public void clickRewards()
	{
		wait=new WebDriverWait(driver,800);
		wait.until(ExpectedConditions.visibilityOfElementLocated(rewards));
		driver.findElement(rewards).click();
	}
	
	public void selectState(String stateName)
	{	
		wait=new WebDriverWait(driver,800);
		wait.until(ExpectedConditions.visibilityOfElementLocated(state));
		selectState=new Select(driver.findElement(state));
		selectState.selectByVisibleText(stateName);

	}
	public void selectMonth(String monthName)
	{	
		wait=new WebDriverWait(driver,800);
		wait.until(ExpectedConditions.visibilityOfElementLocated(month));
		selectMonth=new Select(driver.findElement(month));
		selectMonth.selectByVisibleText(monthName);
	
	}
	public void selectDate(String dateName)
	{
		wait=new WebDriverWait(driver,800);
		wait.until(ExpectedConditions.visibilityOfElementLocated(date));
		selectDate=new Select(driver.findElement(date));
		selectDate.selectByVisibleText(dateName);
	}
	
	public void selectYear(String yearName)
	{
		wait=new WebDriverWait(driver,800);
		wait.until(ExpectedConditions.visibilityOfElementLocated(year));
		selectYear=new Select(driver.findElement(year));
		selectYear.selectByVisibleText(yearName);
		
	}
	public void selectTitle()
	{
		wait=new WebDriverWait(driver,800);
		wait.until(ExpectedConditions.visibilityOfElementLocated(title));
		selectTitle=new Select(driver.findElement(title));
		selectTitle.selectByIndex(1);
		
	}
	
	public void setFirstName(String fname)
	{
		wait=new WebDriverWait(driver,800);
		wait.until(ExpectedConditions.visibilityOfElementLocated(firstName));
		driver.findElement(firstName).clear();	//Clear the text Field First
		
		driver.findElement(firstName).sendKeys(fname);
	}
	
	public void setLastName(String lname)
	{
		wait=new WebDriverWait(driver,800);
		wait.until(ExpectedConditions.visibilityOfElementLocated(lastName));
		driver.findElement(lastName).clear();
		driver.findElement(lastName).sendKeys(lname);
		
	}
	
	public void setStrretAddress(String address)
	{
		wait=new WebDriverWait(driver,800);
		wait.until(ExpectedConditions.visibilityOfElementLocated(streetAddress));
		driver.findElement(streetAddress).clear();
		driver.findElement(streetAddress).sendKeys(address);
	}
	
	public void setCity(String cityName)
	{
		wait=new WebDriverWait(driver,800);
		wait.until(ExpectedConditions.visibilityOfElementLocated(city));
		driver.findElement(city).clear();//Clear the already entered input
		driver.findElement(city).sendKeys(cityName);
	}
	
	public void clickUpdate()
	{
		wait=new WebDriverWait(driver,800);
		wait.until(ExpectedConditions.visibilityOfElementLocated(updateButton));
		driver.findElement(updateButton).click();
	}
	public void setZip(String zipcode)
	{
		wait=new WebDriverWait(driver,800);
		wait.until(ExpectedConditions.visibilityOfElementLocated(zip));
		driver.findElement(zip).clear(); //Used for clearing the input if it exists.
		driver.findElement(zip).sendKeys(zipcode);

	}
	public void updateDetails(String firstname,String lastname,String addressname,String cityname,String statename,String yourZip,String m,String d,String y)
	{	
		this.selectTitle();
		this.setFirstName(firstname);
		this.setLastName(lastname);
		this.setStrretAddress(addressname);
		this.setCity(cityname);
		this.selectState(statename);
		this.setZip(yourZip);
		this.selectMonth(m);
		this.selectDate(d);
		this.selectYear(y);
		this.clickUpdate();
		//This will all be done for updation	
	
	}
	public void openEarnToken()
	{	
		wait=new WebDriverWait(driver,800);
		wait.until(ExpectedConditions.visibilityOfElementLocated(earnToken));
		driver.findElement(earnToken).click();
	}
	
	public void closeEarnToken()
	{
		wait=new WebDriverWait(driver,800);
		wait.until(ExpectedConditions.visibilityOfElementLocated(closeEarnToken));
		driver.findElement(closeEarnToken).click();
		
	}


}
