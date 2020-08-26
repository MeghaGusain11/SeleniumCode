package com.qa.baseclass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.qa.utilities.TestUtil;

public class BaseClass {

	public static WebDriver driver;
	public static Properties prop;

	public BaseClass() {
		try {
			prop = new Properties();

			FileInputStream ip = new FileInputStream("C://Users//meghagusain//eclipse-workspace1/AID1/src/main/java/com/qa/config/config.properties");
			prop.load(ip);	
		} catch (FileNotFoundException e) {
			e.getMessage();
			e.printStackTrace();
		} catch (IOException ie) {
			ie.getStackTrace();
		}
	}

	public static void initialization() {
	
		String browsername = prop.getProperty("browser");
	
		if (browsername.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win321\\chromedriver.exe");
			driver = new ChromeDriver();
		
		}
		
		/*if (browsername.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\meghagusain\\eclipse-workspace\\DRIVEN_Java-DrivenMaster\\root\\Resources\\chromedriver.exe");
			driver = new ChromeDriver();
		}*/
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		}
}	