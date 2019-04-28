package com.Testcase;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pages.BaseClass;
import com.pages.HomePage;
import com.pages.ResetPassword;

public class PasswordRequest extends BaseClass{
	
	@Test(priority=2)
	public void Password()
	{
		logger = report.createTest("Password reset");
		
		HomePage loginTest = PageFactory.initElements(driver, HomePage.class);
		
		logger.info("Login using username and password");
		
		loginTest.LoginToHome(excel.getStringData("Login", 0, 0),excel.getStringData("Login", 0, 1));
		
		driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);

		logger.info("Verifying the title");
		
		try 
		{
			Assert.assertEquals(loginTest.title.getText(), "Hi","Title MisMatched");
		}
		catch (Exception e) 
		{
			System.out.println("Unable to match the title"+e.getMessage());
		}
		
		logger.info("Click on my account button");
		ResetPassword resetTest = PageFactory.initElements(driver, ResetPassword.class);
		resetTest.clickOnMyAccount();
		
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		
		logger.info("Resetting password to new password");
		resetTest.resetPassword(excel.getStringData("Resetpassword", 0, 0),excel.getStringData("Resetpassword", 0, 1),excel.getStringData("Resetpassword", 0, 2));
		
	
		//Check Success Message
		logger.info("Verifying the success message");
		try {
			Assert.assertEquals(resetTest.SuccessMessage.getText(), "Account details changed successfully.","Error MisMatched");
		} catch (Exception e) {
			System.out.println("Unable to match the title"+e.getMessage());
		}
		
		
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		logger.info("Click on Logout");
		resetTest.clickOnLogout();
		
		
		//Revisit later - error
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		logger.info("Login using new password");
		loginTest.LoginToHome(excel.getStringData("Loginwithnewpasword", 0, 0),excel.getStringData("Loginwithnewpasword", 0, 1));	
		
		
		logger.info("Click on my account button");
		resetTest.clickOnMyAccount();
		
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
	
		logger.info("Resetting password to old password ");
		resetTest.resetPassword(excel.getStringData("Resettooldpassword", 0, 0),excel.getStringData("Resettooldpassword", 0, 1),excel.getStringData("Resettooldpassword", 0, 2));
		
		logger.info("Click on Logout");
		resetTest.clickOnLogout();
		
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		
		logger.info("Login using the old password");
		
		loginTest.LoginToHome(excel.getStringData("Login", 0, 0),excel.getStringData("Login", 0, 1));
		
		logger.info("Verifying the title");
		try {
			Assert.assertEquals(loginTest.title.getText(), "Hi","Title MisMatched");
		} catch (Exception e) {
			System.out.println("Unable to match the title"+e.getMessage());
		}
		
		logger.pass("Pass");
	
	}

	
	

}


