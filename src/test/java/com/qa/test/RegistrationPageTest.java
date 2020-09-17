package com.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.baseclass.BaseClass;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.pages.MyAccountPage;
import com.qa.pages.RegistrationPage;
import com.qa.utilities.TestUtil;

public class RegistrationPageTest extends BaseClass {

	HomePage homepage;
	LoginPage loginpage;
	RegistrationPage registrationpage;
	String sheetname = "Register";
	String fstname;
	String lstname;
	RegistrationPageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialization();
		homepage = new HomePage();
		loginpage = homepage.login();
	}

	@Test(priority = 1)
	public void validatefirstlastname()

	{
		registrationpage = loginpage.createaccount("namita@yopmail.com");
		fstname = registrationpage.checkfirstname("Ana");
		lstname = registrationpage.checklastname("Jana");
		Assert.assertEquals(fstname, "Ana");
		Assert.assertEquals(lstname, "Jana");

	}

	@DataProvider
	public Object[][] getCRMTestData() {
		Object[][] data = TestUtil.getTestData(sheetname);
		return data;
	}

	@Test(priority = 2, dataProvider = "getCRMTestData")
	public void validateregistration(String emailId, String Firstname, String Lastname, String password, String Address,
			String district, String postcode, String mobile, String State) {
		registrationpage = loginpage.createaccount(emailId);
		MyAccountPage myaccountpage= registrationpage.createnewuser(Firstname, Lastname, password, Address, district, postcode, mobile, State);
		Assert.assertEquals(myaccountpage.getPageHeading(), "MY ACCOUNT");
		}

	
	
	 @AfterMethod 
	 public void teardown() 
	 { driver.quit(); }
	
	
}
