package com.pages;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.Utility.BrowserIntialize;
import com.Utility.ConfigDataProvider;
import com.Utility.ExcelDataProvider;
import com.Utility.Helper;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseClass {
	
	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	
	public ExtentReports report;
	public ExtentTest logger;
	
	@BeforeSuite
	public void setUp()
	{
		excel = new ExcelDataProvider();
		config = new ConfigDataProvider();
		
		ExtentHtmlReporter extent = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Report/test "+Helper.getCurrentDateTime()+".html"));
		report = new ExtentReports();
		report.attachReporter(extent);
	}
	
	@BeforeMethod
	
	public void setup() 
	{
		driver=BrowserIntialize.startApp(driver, config.getBrowser(), config.getEnvironmentURL());
			
	}

	@AfterMethod

	public void tearDown() 

	{
		BrowserIntialize.quitBrowser(driver);
	
	}
	
	@AfterMethod
	public void tearDownMethod(ITestResult result)
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			Helper.captureScreentshot(driver);
		}
		report.flush();
		
	}
}

