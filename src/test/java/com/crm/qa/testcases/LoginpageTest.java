package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.Homepage;
import com.crm.qa.pages.Loginpage;

public class LoginpageTest extends TestBase {
	Loginpage loginpage;
	Homepage homepage;
	
	public LoginpageTest()
	{
		super();
	}
	
	@BeforeMethod	
		public void setUp()
		{
		Initialize();
		
		loginpage=new Loginpage();	
		}
	
	@Test
	public void LoginPageTitleTest()
	{
	String title=loginpage.validateLoginPageTitle();
	Assert.assertEquals(title,"#1 Free CRM software in the cloud for sales and service" );
	
	}
	@Test
	public void CRMlogoTest()
	{
	boolean flag=loginpage.validateCrmLogo();
	Assert.assertTrue(flag);
	}
	@Test
	public void LoginTest()
	{
		homepage= loginpage.login(prop.getProperty("username"),prop.getProperty("password") );
	
	
	}
	@AfterMethod
	public void tearDown()
	{
	driver.quit();
	}
	
		
	

}
