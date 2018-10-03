package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.qa.util.Testutil;

public class TestBase {
	public static Properties prop;
public	static WebDriver driver;
	
	
	public TestBase()  {
		try {
	 prop=new Properties();
	 
	FileInputStream ip=new FileInputStream("D:\\Freecrmtest\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
	prop.load(ip);
	
	}catch(FileNotFoundException e) {
		e.printStackTrace();
	}catch(IOException e) {
		e.printStackTrace();
	}
		
	}
	
	public static void Initialize()
	{
    String browsername=prop.getProperty("browser");
    if (browsername.equals("chrome"))
    {
    	System.setProperty("webdriver.chrome.driver" ,"C:\\drivers\\chromedriver.exe");
    	driver=new ChromeDriver();
    }
    else if(browsername.equals("FireFox"))
    {
    	System.setProperty("webdriver.gecko.driver" ,"C:\\drivers\\geckodriver.exe");
    driver=new FirefoxDriver();
    }
    
    driver.manage().window().maximize();
    driver.manage().deleteAllCookies();
    driver.manage().timeouts().pageLoadTimeout(Testutil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
    driver.manage().timeouts().implicitlyWait(Testutil.IMPLICIT_WAIT, TimeUnit.SECONDS);
    
    driver.get(prop.getProperty("url"));
	}
	
	
	
	
	
	
	
	
}
