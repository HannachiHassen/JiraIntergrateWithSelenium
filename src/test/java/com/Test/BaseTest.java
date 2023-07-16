package com.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.PageObject.BasePage;
import com.PageObject.Page;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public BaseTest() {	}
	
	WebDriver driver;
	public Page page;
	
	@BeforeMethod
	@Parameters (value= {"browser"})
	public void setUpTest(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("ff")){
			WebDriverManager.chromedriver().setup();
			driver=new FirefoxDriver();
		}
		else {
			System.out.println("no browser is defined in xml file ...");
		}
		driver.get("https://app.hubspot.com/login");
		
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		page = new BasePage(driver);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
