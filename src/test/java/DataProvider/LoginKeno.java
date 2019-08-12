package DataProvider;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class LoginKeno extends BaTest {
	
	WebDriver driver;
	XSSFSheet sheet;
	
	@Test()
	public void playKeno() throws IOException
	{
		driver=getDriver();
		driver.get("https://keno.qa.pch.com/");
		driver.manage().window().maximize();
		WebDriverWait wait=new WebDriverWait(driver,800);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//nav[@class='uninav__unrecognized']//ul//li[1]//a")));
		
		driver.findElement(By.xpath("//nav[@class='uninav__unrecognized']//ul//li[1]//a")).click();
		/*
		 * File file=new
		 * File("C:\\Users\\mtagra\\TestngDemo\\src\\test\\java\\DataProvider\\tt.xlsx")
		 * ; FileInputStream fis=new FileInputStream(file);
		 * 
		 * XSSFWorkbook wb=new XSSFWorkbook(fis); XSSFSheet sheet=wb.getSheetAt(0)
		 */;
		 
		 sheet=getSheet();
		 

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("EM")));
		driver.findElement(By.id("EM")).sendKeys(sheet.getRow(1).getCell(0).toString());
		driver.findElement(By.id("PW")).sendKeys(sheet.getRow(1).getCell(1).toString());
		
		driver.findElement(By.id("login-sub-btn")).click();
		try
		{	Thread.sleep(4000);
			driver.findElement(By.id("login-sub-btn")).click();
		}
		catch(Exception e)
		{
			System.out.println("Exception occured");
		}
	}

}
