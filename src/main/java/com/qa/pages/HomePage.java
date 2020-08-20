package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.baseclass.BaseClass;

public class HomePage extends BaseClass {

	@FindBy(xpath = "//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")
	WebElement SignIn;

	@FindBy(xpath = "//*[@id=\"header_logo\"]/a/img")
	WebElement Logo;

	@FindBy(xpath = "//*[@id=\"search_query_top\"]")
	WebElement SearchQuery;

	@FindBy(xpath = "//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a")
	WebElement Minicart;

	@FindBy(xpath = "//*[@id=\"contact-link\"]/a")
	WebElement contactlink;

	public HomePage() {
		PageFactory.initElements( driver, this);
	}

	public String validatetitle() {
	return driver.getTitle();	
	}
	public boolean validatelogo() {
		return Logo.isDisplayed();
	}
	public void validatesearch(String searchkey) {
		SearchQuery.sendKeys(searchkey);
	}
	
	public LoginPage login() {
		SignIn.click();		
		return new LoginPage();
	}

}
