package com.qa.tests;

import org.testng.annotations.Test;

import com.qa.generic.BaseTest;
import com.qa.pages.HomePage;
import com.qa.pages.Loginpage;
import com.qa.pages.ProfilePage;
import com.qa.pages.StartPage;
import com.qa.pages.TipsPage;
import com.qa.pages.ValidationPage;


import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

public class LoginDataDrivenTest extends BaseTest {
	StartPage start;
	Loginpage login;
	ProfilePage profile;
	
	ValidationPage validation;
	HomePage home;
	TipsPage tips;
	@BeforeMethod
	  public void beforeMethod(Method m) {
		 start=new StartPage();
		 login=new Loginpage();
		 validation=new ValidationPage();
		 profile=new ProfilePage();
		 
		 System.out.println("Starting test ----"+m.getName());
		 
	}
  @Test(priority=1,dataProvider="getData")
  public void sucessfullLogin(String email,String pwd) throws InterruptedException {
	  start.enterEmail(email);
	  login.enterPassword(pwd);
	  login.clickLoginButton(); 
	  validation.clickVerifybtn();
	 profile.clickProfile();
  	  profile.scrollToLogoutElement();
  	  profile.clickLogout();
  	  profile.clickLogoutYes();
	  }
  @DataProvider
  public Object[][] getData() {
	 return new Object[][] {{"john@gmail.com","123456789"},{"testtia4@gmail.com","1234@4321"}};
  }
  
}
