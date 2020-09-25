package com.qa.pages;

//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


import com.qa.baseclass.BaseClass;

public class RegistrationPage extends BaseClass{
	
	public String ftname, ltname;
	
	@FindBy(xpath="//*[@id=\"center_column\"]/h1")
	WebElement page_heading;
	
	@FindBy(xpath="//*[@id=\"id_gender1\"]")
	WebElement gender_male;
	
	@FindBy(xpath="//*[@id=\"id_gender2\"]")
	WebElement gender_female;
	
	@FindBy(xpath="//*[@id=\"customer_firstname\"]")
	WebElement customer_firstname;
	
	@FindBy(xpath= "//*[@id=\"customer_lastname\"]")
	WebElement customer_lastname;
	
	@FindBy(xpath="//*[@id=\"passwd\"]")
	WebElement customer_password;
	
	@FindBy(xpath="//*[@id=\"firstname\"]")
	WebElement reg_firstname;
	
	
	
	@FindBy(xpath="//*[@id=\"lastname\"]")
	WebElement reg_lastname;
	
	@FindBy(xpath="//*[@id=\"address1\"]")
	WebElement reg_address1;
	
	@FindBy(xpath="//*[@id=\"city\"]")
	WebElement reg_city;
	
	@FindBy(xpath ="//*[@id=\"postcode\"]")
	WebElement postcode;
	
	@FindBy(xpath="//*[@id=\"phone_mobile\"]")
	WebElement mobile;
	
	@FindBy(xpath="//*[@id=\"submitAccount\"]/span")
	WebElement submitaccount;
	
	public RegistrationPage()
	{
		PageFactory.initElements(driver, this);
	}

	
	public String getPageHeading() {
		String pageheading = page_heading.getText();
		return pageheading ;
	}
		
	public String checkfirstname(String firstname)
	{
		customer_firstname.sendKeys(firstname);	
		ftname = reg_firstname.getAttribute("value");
		return ftname;
	}
	
	public String checklastname(String lastname)
	{
		customer_lastname.sendKeys(lastname);
		ltname=reg_lastname.getAttribute("value");
	    return ltname;
	}
	
	public MyAccountPage createnewuser(String firstname, String lastname, String password, String address1, String city1, String postalcode,String mob, String statename)
	{
	gender_male.click();
	customer_firstname.sendKeys(firstname);	
	customer_lastname.sendKeys(lastname);
	customer_password.sendKeys(password);
	
	reg_address1.sendKeys(address1);
	reg_city.sendKeys(city1);
	Select statedrp = new Select(driver.findElement(By.xpath("//*[@id=\"id_state\"]")));
	statedrp.selectByVisibleText(statename);
	postcode.sendKeys(postalcode);
	mobile.sendKeys(mob);
	submitaccount.click();
	return new MyAccountPage();
	}
	
	
	
	

	
}
