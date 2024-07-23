package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.qa.utility.Util;

public class Base {
	public static WebDriver driver;
	public static Properties prop;

public Base() // reading properties file in base class constructor
{
try
{
	 prop = new Properties();
	FileInputStream ip=new FileInputStream
(System.getProperty( "F:\\java_program_2024\\DemoEcommerse\\src\\main\\java\\com\\crm\\qa\\Config\\config.properties"));
	prop.load(ip);
}catch(FileNotFoundException e)
{
	e.printStackTrace();
}catch(Exception e)
{
	e.printStackTrace();
}

}
public static void initilization()
{
 String browsername=prop.getProperty("browser");
	
   if(browsername.equals("chrome"))
	{
	System.setProperty("webdriver.chrome.driver", "D:\\May_2024seleniumbatch\\chromedriver.exe");
	driver=new ChromeDriver();
	}
driver.manage().window().maximize();
driver.manage().deleteAllCookies();
driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Util.PAGE_LOAD_TIMEOUT));
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Util.IMPLICIT_WAIT));

driver.get(prop.getProperty("url"));
}

}

