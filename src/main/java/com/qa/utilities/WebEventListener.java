package com.qa.utilities;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.qa.baseclass.BaseClass;

public class WebEventListener extends BaseClass implements WebDriverEventListener {
	
	public void afterNavigateTo1(String url, WebDriver driver)
	{
		System.out.println("After navigating to: '" + url +"'" );
	}
	public void afterAlertAccept(WebDriver driver) {
		System.out.println("After alert accept");
		
	}

	public void afterAlertDismiss(WebDriver driver) {
		System.out.println("After alert dismiss");
		
	}

	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] arg2) {
		System.out.println("After changing value of:" +  element.toString());
		
	}

	public void afterClickOn(WebElement element, WebDriver driver) {
		System.out.println("After clicking on: '" + element.toString());
		
	}

	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println("After find by : " + by.toString() );
		
	}

	public <X> void afterGetScreenshotAs(OutputType<X> arg0, X arg1) {
		// TODO Auto-generated method stub
		
	}

	public void afterGetText(WebElement arg0, WebDriver arg1, String arg2) {
		// TODO Auto-generated method stub
		
	}

	public void afterNavigateBack(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	public void afterNavigateForward(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	public void afterNavigateRefresh(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	public void afterNavigateTo(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	public void afterScript(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	public void afterSwitchToWindow(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	public void beforeAlertAccept(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	public void beforeAlertDismiss(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	public void beforeChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {
		// TODO Auto-generated method stub
		
	}

	public void beforeClickOn(WebElement element, WebDriver driver) {
		System.out.println("Before clicking on:"+ element.toString()) ;
		
	}

	public void beforeFindBy(By arg0, WebElement arg1, WebDriver arg2) {
		// TODO Auto-generated method stub
		
	}

	public <X> void beforeGetScreenshotAs(OutputType<X> arg0) {
		// TODO Auto-generated method stub
		
	}

	public void beforeGetText(WebElement arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	public void beforeNavigateBack(WebDriver driver) {
		System.out.println("Navigating to previous page" );
		
	}

	public void beforeNavigateForward(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	public void beforeNavigateRefresh(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	public void beforeNavigateTo(String url, WebDriver driver) {
		System.out.println("Before navigating to: '" + url +"'" );
		
	}

	public void beforeScript(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	public void beforeSwitchToWindow(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	public void onException(Throwable error, WebDriver driver) {
	System.out.println( "Exception Occured : " + error);
	try {
		TestUtil.takeScreenshotAtEndOfTest();
		}
	catch(IOException e) {
		e.printStackTrace();
	}
		
	}

}
