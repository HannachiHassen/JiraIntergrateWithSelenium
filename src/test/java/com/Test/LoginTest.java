package com.Test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.PageObject.HomePage;
import com.PageObject.LoginPage;
import com.Utils.JiraPolicy;

public final class LoginTest extends BaseTest{

	public LoginTest() {
		
	}
	@JiraPolicy(logTicketReady = true)
	@Test(priority=1, enabled=true)
	public void verifyLoginPageTitleTest(){
		String title = page.getInstance(LoginPage.class).getLoginPageTitle();
		System.out.println(title);
		Assert.assertEquals(title, "HubSpot LoginXX");
	}
	
	@JiraPolicy(logTicketReady = true)
	@Test(priority=2, enabled=true)
	public void verfiyLoginPageHeaderTest() {
		String header=page.getInstance(LoginPage.class).getLoginPageHeader();
		System.out.println(header);
	    Assert.assertEquals(header,"Don't have an account?xxx");
	}
	
	/*
	@JiraPolicy(logTicketReady=true)
	@Test(priority=3)
	public void doLoginTest(){
		HomePage homePage = page.getInstance(LoginPage.class).doLogin("naveenanimation20@gmail.com", "Test@12345");
		String headerHome = homePage.getHomePageHeader();
		System.out.println(headerHome);
		Assert.assertEquals(headerHome, "Getting started with HubSpotXXXXX");
	}
	*/
}
