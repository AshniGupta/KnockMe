package com.Testcase;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.pages.BaseClass;
import com.pages.HomePage;
import com.pages.ResetPassword;

public class LoginTest extends BaseClass{
	
	
	@Test(priority=1)
	public void loginApp()
	{
		logger = report.createTest("Login to KnockMe");
		
		HomePage loginTest = PageFactory.initElements(driver, HomePage.class);
		
		logger.info("Login using username and password");
		
		loginTest.LoginToHome(excel.getStringData("Login", 0, 0),excel.getStringData("Login", 0, 1));
			
		logger.info("Verifying the title");
		
		try
		{
			Assert.assertEquals(loginTest.title.getText(), "Hi","Title MisMatched");
		} 
		catch (Exception e) 
		{
			System.out.println("Unable to match the title"+e.getMessage());
		}
		
		ResetPassword resetTest = PageFactory.initElements(driver, ResetPassword.class);
		resetTest.clickOnLogout();
		logger.pass("Login Successful");
	}
	
		@Test(priority=2)
	
		public void verifyUnsuccessfulLoginErrorMessage()
		{
		logger = report.createTest("Login to KnockMe using Invalid details");
		
		HomePage loginTest = PageFactory.initElements(driver, HomePage.class);
		
		logger.info("Login using invalid username and password");
		
		loginTest.LoginToHome(excel.getStringData(1, 0, 0),excel.getStringData(1, 0, 1));
			
		logger.info("Verifying the error message");
		
		String errormessage1 = loginTest.errormessage.getText();
		
		try 
		{
			Assert.assertEquals(errormessage1, "ERROR");
		} 
		catch (Exception e) 
		{
			System.out.println("Unable to find error message");
		}
		
		logger.info("Login Failed - Error has occured");
	}
	
}
