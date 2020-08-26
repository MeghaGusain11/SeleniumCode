package com.qa.test;

import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.baseclass.BaseClass;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;

public class HomePageTest extends BaseClass {

	HomePage homepage;
	LoginPage loginpage;
	HomePageTest(){
		super();
	}
	@BeforeMethod
	public void setup()
	{
		initialization();
		 homepage = new HomePage();
		
	}
	
	@Test(priority=1)
		public void validatehomepagetitle() 
		{
		String st= homepage.validatetitle();
		Assert.assertEquals("My Store", st);
	
		}
	
	@Test(priority=2)
		public void validatehomepagelogo() {
		Boolean lg = homepage.validatelogo();
			Assert.assertTrue(lg);
		}
	
	/*@Test(priority=3)
		public void validatesearch()String searchkey) {
			SearchQuery.sendKeys(searchkey);
		}*/
		
	@Test(priority=3)
		public void validatelogin() {
				loginpage = homepage.login();		
		}
		
		@AfterMethod
	public void teardown()
	{
		driver.quit();
		
	}
}
