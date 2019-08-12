package PchCom;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseTest {
	
	WebDriver driver;
	XSSFSheet sheet;
	public static  ExtentHtmlReporter htmlReporter;
	public	static ExtentReports report;
	public static  ExtentTest test;
	
	public WebDriver  getDriverWithAddBlocker()
	{	
		System.setProperty("webdriver.chrome.driver", "C:\\chromeDriver\\chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.setPageLoadStrategy(PageLoadStrategy.NONE);
		options.addExtensions(new File("E:\\chrome_Extensions\\chrome.crx"));
		options.addExtensions(new File("E:\\chrome_Extensions\\chrome1.crx"));
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(options.CAPABILITY,options);
		WebDriver driver=new ChromeDriver(options);
		
		return driver;
	}
	public WebDriver getDriverWithoutAddBlocker()
	{	
		System.setProperty("webdriver.chrome.driver","C:\\chromeDriver\\chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.setPageLoadStrategy(PageLoadStrategy.NONE);
		WebDriver driver=new ChromeDriver(options);
		
		return driver;
	}
	
	
	public XSSFSheet calendarSheet() throws IOException
	{	
		File src=new File("C:\\Users\\mtagra\\TestngDemo\\src\\test\\java\\PchCom\\Calendar.xlsx");
		FileInputStream fis=new FileInputStream(src);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheetAt(0);
		return sheet;
		
	}
	@BeforeSuite
	public static  void setup()
	{
		htmlReporter=new ExtentHtmlReporter("Report.html");
		report=new ExtentReports();
		report.attachReporter(htmlReporter);
	
	}
	@AfterMethod
	public static  void getResult(ITestResult result) 
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+"Test Case Failed due to following Reason",ExtentColor.RED));
			test.fail(result.getThrowable());
			
			//Capturing the Screeenshot and copying it to the File named screenShot.png
			/*
			 * File
			 * screenShotFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			 * FileUtils.copyFile(screenShotFile,new File("screenshot.PNG"));
			 */
			//Fixed Piece of  Code Need not be changed
			//if IO gives an error then problem with File.
			
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			//test.log(Status.PASS,MarkupHelper.createLabel(result.getName()+"Test case passed successfullu",ExtentColor.GREEN));
			
			test.log(Status.PASS,MarkupHelper.createLabel(result.getName()+"Test Passed", ExtentColor.GREEN));
			
		}
		else
		{
			System.out.println("The Test Case has been skipped");
		}
	}
	
	@AfterSuite
	public static  void tearDown()
	{
		report.flush();
	}
}
