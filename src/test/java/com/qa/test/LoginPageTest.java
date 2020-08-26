package com.qa.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.baseclass.BaseClass;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.pages.MyAccountPage;

public class LoginPageTest extends BaseClass {
	LoginPage loginpage;
	HomePage homepage;
	MyAccountPage myaccountpage;
	public LoginPageTest() {
		super();
	}
	 @BeforeMethod
	 public void setup()
	 {
		 initialization();
		 homepage=new HomePage();
		 loginpage = homepage.login();
			 
	 } 
	 
	 @Test(priority=1)
	 public void testloginmethod()
		{
		     myaccountpage = loginpage.signin(prop.getProperty("username"), prop.getProperty("password"));
		
		} 	 
	 
	 
	 @AfterMethod
	 public void teardown()
	 {
		 driver.quit();
	 }
	 
	
	
}
