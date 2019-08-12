package PchCom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class KenoRegisterationPage {
	WebDriver driver;
	WebDriverWait wait=null;
	By select=By.xpath("//select[@name='title']");
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
	By password=By.className("password");
	By confirmPassword=By.className("confirm-password");
	//By continueButton;
	By continueButton=By.id("sub_btn");
	
	public KenoRegisterationPage(WebDriver driver)
	{
		this.driver=driver;
	}
	public void selectMr()
	{
		wait=new WebDriverWait(driver,800);
		wait.until(ExpectedConditions.visibilityOfElementLocated(select));
		Select title=new Select(driver.findElement(select));
		title.selectByIndex(1);	
	}
	public void selectMrs()
	{
		wait=new WebDriverWait(driver,800);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(select));
		Select title=new Select(driver.findElement(select));
		title.deselectByIndex(2);
	}
	public void selectMs()
	{
		wait=new WebDriverWait(driver,800);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(select));
		Select title=new Select(driver.findElement(select));	
	}
	public void setFirstName(String firstname)
	{
		driver.findElement(firstName).sendKeys(firstname);
	}
	public void setLastName(String lastname)
	{
		driver.findElement(lastName).sendKeys(lastname);
		
	}
	public void setStreetAddress(String address)
	{
		driver.findElement(streetAddress).sendKeys(address);
	}
	public void setCity(String cityName)
	{
		driver.findElement(city).sendKeys(cityName);
		
	}
	public void SelectState(String stateName)
	{
		Select mystate=new Select(driver.findElement(state));
		mystate.selectByVisibleText(stateName);
	}
	public void setZipCode(String zipCode)
	{
		driver.findElement(zip).sendKeys(zipCode);
		
	}
	public void SelectMonth(String mnth) {
		
		Select m=new Select(driver.findElement(month));
		m.selectByVisibleText(mnth);
			
	}
	public void SelectDay(String dy)
	{
		Select d=new Select(driver.findElement(day));
		d.selectByVisibleText(dy);
	}
	public void SelectYear(String yr)
	{
		Select y=new Select(driver.findElement(year));
		y.selectByVisibleText(yr);
	}
	
	public void setEmail(String em)
	{
		driver.findElement(email).sendKeys(em);
		
	}
	public void setConfirmEmail(String confirmEm)
	{
		driver.findElement(confirmEmail).sendKeys(confirmEm);
		
	}
	public void setPassword(String pswrd)
	{
		driver.findElement(password).sendKeys(pswrd);
	}
	public void setConfirmPassword(String confirmp)
	{
		driver.findElement(confirmPassword).sendKeys(confirmp);
	}
	public void ClickSubmit()
	{
		driver.findElement(continueButton).click();
	}
	public void Register(String fname,String lname,String saddress,String zcode,String cty,String stat,String m,String d,String yer,String e,String ce,String p,String cp)
	{
		this.selectMr();
		this.setFirstName(fname);
		this.setLastName(lname);
		this.setStreetAddress(saddress);
		this.setZipCode(zcode);
		this.setCity(cty);
		this.SelectState(stat);
		this.SelectMonth(m);
		this.SelectDay(d);
		this.SelectYear(yer);
		this.setEmail(e);
		this.setConfirmEmail(ce);
		this.setPassword(p);
		this.setConfirmPassword(cp);
		
	}
}

