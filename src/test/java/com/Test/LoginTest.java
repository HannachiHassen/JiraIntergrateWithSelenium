package com.Test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.PageObject.LoginPage;

public final class LoginTest extends BaseTest{

	public LoginTest() {
		
	}
	
	@Test(priority=1, enabled=true)
	public void verifyLoginPageTitleTest(){
		String title = page.getInstance(LoginPage.class).getLoginPageTitle();
		System.out.println(title);
		Assert.assertEquals(title, "HubSpot LoginXX");
	}

}
