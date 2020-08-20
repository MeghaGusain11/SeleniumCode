package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.baseclass.BaseClass;

public class MyAccountPage extends BaseClass {

	@FindBy(xpath="//*[@id=\"center_column\"]/h1")
	WebElement pagetitle ;
	
	@FindBy(xpath="//*[@id=\"center_column\"]/div/div[2]/ul/li/a")
	WebElement Wishlist;
	
	public MyAccountPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void ValidateWishlist() {
		Wishlist.click();
		
	}
}
