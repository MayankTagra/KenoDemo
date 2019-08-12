package PchCom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PchComRegister {
	
	WebDriver driver;
	WebDriverWait wait;
	By signInButton=By.xpath("//button[@class='uni-nav-btn']");
	By title=By.name("title");
	By firstName=By.name("firstname");
	By lastName=By.name("lastname");
	By streetAddress=By.name("street");
	By city=By.name("city");
	By state=By.name("state");
	By zip=By.name("zip");
	By month=By.name("month");
	By day=By.name("day");
	By year=By.name("year");
	By email=By.name("email");
	By confirmEmail=By.name("confirm-email");
	
	public PchComRegister(WebDriver driver)
	{
		this.driver=driver;
	}
	public void SelectMr()
	{
		wait=new WebDriverWait(driver,800);
		wait.until(ExpectedConditions.visibilityOfElementLocated(title));
		Select t=new Select(driver.findElement(title));
		t.selectByIndex(1);
		
	}
	public void SelectMrs()
	{
		wait=new WebDriverWait(driver,800);
		wait.until(ExpectedConditions.visibilityOfElementLocated(title));
		Select t=new Select(driver.findElement(title));
		t.selectByIndex(2);
		
	}
	public void SelectMs()
	{	
		wait=new WebDriverWait(driver,800);
		wait.until(ExpectedConditions.visibilityOfElementLocated(title));
		Select t=new Select(driver.findElement(title));
		t.selectByIndex(3);
	}
	public void setFirstName(String fname)
	{
		driver.findElement(firstName).sendKeys(fname);
	}
	public void setLastName(String lname)
	{
		driver.findElement(lastName).sendKeys(lname);
	}
	public void setStreetAddress(String address)
	{
		driver.findElement(streetAddress).sendKeys(address);
	}
	public void setCity(String cityname)
	{
		driver.findElement(city).sendKeys(cityname);
	}
	public void SelectState(String statename)
	{
		Select st=new Select(driver.findElement(state));
		st.selectByVisibleText(statename);
	}
	public void setZipCode(String zipc)
	{
		driver.findElement(zip).sendKeys(zipc);
	}
	public void selectMonth(String monthname)
	{
		Select m=new Select(driver.findElement(month));
		m.selectByVisibleText(monthname);
				
	}
	public void selectDate(String dt)
	{
		Select d=new Select(driver.findElement(day));
		d.selectByVisibleText(dt);
		
	}
	public void selectYear(String yr)
	{
		Select y=new Select(driver.findElement(year));
		y.selectByVisibleText(yr);
	}
	public void SetEmail(String em)
	{
		driver.findElement(email).sendKeys(em);
		
	}
	public void setConfirmemail(String cemail)
	{
		driver.findElement(confirmEmail).sendKeys(cemail);
	}
	
	/*
	 * public void SubmitEntry(String fname,String lname,String streetAddress,String
	 * city,String state,String zip) ,String mnth,String dy,String yr,String
	 * em,String cem){
	 * 
	 * }
	 */
	public void SubmitEntry(String fname,String lname,String saddress,String city,String state,String zipcode,String month,String day,String year,String email,String cemail)
	{
		this.SelectMr();			//1
		this.setFirstName(fname);	
		this.setLastName(lname);
		this.setStreetAddress(saddress);
		this.setCity(city);
		this.SelectState(state);
		this.setZipCode(zipcode);
		this.selectDate(day);
		this.selectMonth(month);
		this.selectYear(year);
		this.setConfirmemail(cemail);
		this.SetEmail(email);
		
	}
	public void clickSignInButton()
	{
		driver.findElement(signInButton).click();
		
	}

}
