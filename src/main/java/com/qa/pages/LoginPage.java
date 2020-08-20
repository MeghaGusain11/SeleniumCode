package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.baseclass.BaseClass;

public class LoginPage extends BaseClass {

	@FindBy(xpath="//*[@id=\"email\"]")
	WebElement emailaddress;
	
	@FindBy(xpath="//*[@id=\"passwd\"]")
	WebElement password;
	
	@FindBy(xpath="//*[@id=\"SubmitLogin\"]")
	WebElement signinbttn;

	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}

	public MyAccountPage signin(String us, String pwd) {
		emailaddress.sendKeys(us);
		password.sendKeys(pwd);
		signinbttn.click();
		return new MyAccountPage();
	}
}
