 package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	
	
	WebDriver driver;
	
	public HomePage (WebDriver ldriver)
	
	{
		this.driver=ldriver;
		
	}

	@FindBy(name="username") WebElement uname;
	
	@FindBy(name="password") WebElement pass;
	
	@FindBy(xpath="//*[@id=\"customer_login\"]/div/div[1]/form/p[3]/button") WebElement LoginButton;
	
	@FindBy(xpath="/html/body/section[2]/div/div/div/div/div/div[1]/div/div[1]/h5/strong")
	public WebElement title; 
	
	@FindBy(xpath="/html/body/section[2]/div/div/div[1]/div/ul/li/strong[1]")
	public WebElement errormessage; 

	public void LoginToHome(String unameApp, String passApp)
	
	{
		
		uname.sendKeys(unameApp);
		
		pass.sendKeys(passApp);
		
		LoginButton.click();
		
	}
	
	
	
	
}
