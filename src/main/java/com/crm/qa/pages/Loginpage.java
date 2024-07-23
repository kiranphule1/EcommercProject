package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.Base;

public class Loginpage extends Base {
// page factory //define object Repo;
	
	//Annotation
	
	@FindBy(id="user-name")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@class=\"submit-button btn_action\"]")
	WebElement loginbtn;
	
	@FindBy(xpath="//div[text()=\"Swag Labs\"]")
	WebElement crmlogo;
	  
	//Initialization of page object//method
	  public Loginpage()
	  {
	   PageFactory.initElements(driver, this);	// Initialize page factory with help of constructor  
	  }
	  //Action of the page
	  public String validateLoginPageTitle()
	  {
	  return driver.getTitle();
	  }
	  public boolean validatecrmLogoImage()
	  {
	    return crmlogo.isDisplayed();
      }
	  public Homepage Login(String un ,String pass)
	  {
		  username.sendKeys(un);
		  password.sendKeys(pass);
		  loginbtn.click();
		  return new Homepage();
	  }
}