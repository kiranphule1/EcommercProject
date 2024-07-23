package com.crm.qa.Testscases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.Base;
import com.crm.qa.pages.Loginpage;

public class LoginPageTest extends Base
{
Loginpage loginpage;
public  LoginPageTest() 
{
super();
}
@BeforeMethod
public void setup() 
{
initilization();
loginpage=new Loginpage(); 	
}

@Test(priority=1)
public void loginPageTilteTest() {
	String title=loginpage.validateLoginPageTitle();
	Assert.assertEquals(title,"Swag Labs");
	
}
@Test(priority=1)
public void loginTest()
{
loginpage.Login(prop.getProperty("username"),prop.getProperty("password"));	
}

@AfterMethod
public void tearDowan()
{
	driver.quit();
}
}

