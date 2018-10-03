package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;


public class Loginpage extends TestBase {
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath="//font[contains(text),'Sign Up']")
	WebElement SignUplink;
	
	@FindBy(xpath="//img[@class='img-responsive']")
	WebElement  CrmLogo;
	
	
	public Loginpage()
	{
		PageFactory.initElements(driver, this);
	}
   public String validateLoginPageTitle()
   {
	  return driver.getTitle();
	  
   }
   public boolean validateCrmLogo()
   {
	  return CrmLogo.isDisplayed();
	  
   }
   public Homepage login(String un,String pwd)
   {
	   username.sendKeys(un);
	   password.sendKeys(pwd);
	   loginBtn.click();
	   return new Homepage();
   }
}
