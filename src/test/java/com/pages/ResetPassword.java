package com.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ResetPassword {
	
	
	WebDriver driver;
	
	public ResetPassword (WebDriver ldriver)
	
	{
		this.driver=ldriver;
		
	}

	@FindBy(name="password_current") WebElement opassword;
	
	@FindBy(name="password_1") WebElement npassword;
	
	@FindBy(name="password_2") WebElement cnpassword;
	
	
	@FindBy(name="save_account_details") WebElement ResetPassword;
	
	@FindBy(xpath="/html/body/section[2]/div/div/div/div/div/div[1]/div/div[2]/a[6]") 
	public WebElement LogoutButton;
	
	@FindBy(xpath="/html/body/section[2]/div/div/div/div/div/div[1]/div/div[2]/a[5]") 
	public WebElement MyAccountButton;
	
	@FindBy(xpath="/html/body/section[2]/div/div/div/div/div/div[2]/div/div/div/div/div/div")
	public WebElement SuccessMessage;
	
	
	public void resetPassword(String opasswordapp, String npasswordapp, String cnpasswordapp)
	
	{
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
		}
		
		opassword.sendKeys(opasswordapp);
		
		npassword.sendKeys(npasswordapp);
		
		cnpassword.sendKeys(cnpasswordapp);
		
		ResetPassword.click();
		
	}
	
	public void clickOnLogout()
	{
		LogoutButton.click();
	}
	
	public void clickOnMyAccount()
	{
		MyAccountButton.click();
	}
}
