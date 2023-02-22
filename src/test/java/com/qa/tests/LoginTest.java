package com.qa.tests;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;


import org.testng.annotations.BeforeMethod;
import java.lang.reflect.Method;

import org.testng.Assert;
import com.google.common.collect.ImmutableMap;
import com.qa.generic.BaseTest;
import com.qa.pages.HealthVitalsPage;
import com.qa.pages.HomePage;
import com.qa.pages.Loginpage;
import com.qa.pages.ProfilePage;
import com.qa.pages.RegistrationPage;
import com.qa.pages.StartPage;
import com.qa.pages.TipsPage;
import com.qa.pages.ValidationPage;
import com.qa.utilities.TestUtils;
public class LoginTest extends BaseTest {
	ExtentTest test;
	StartPage start;
	Loginpage login;
	RegistrationPage register;
	ValidationPage validation;
	HomePage home;
	TipsPage tips;
	ProfilePage profile;
	HealthVitalsPage health;
  
  @BeforeMethod
  public void beforeMethod(Method m) {
	 start=new StartPage();
	 register=new RegistrationPage();
	 login=new Loginpage();
	 validation=new ValidationPage();
	 home=new HomePage();
	 tips=new TipsPage();
	 profile=new ProfilePage();
	 health= new HealthVitalsPage();
	 TestUtils.log().info("Starting test ----"+m.getName());
	 
  }
  
  @Test(priority=0)
  public void loginScreenNavigation() {
	  TestUtils.log().info("-----------Navigating to login screen---------");
	  start.enterEmail("tia102@gmail.com");
	   
  }
@Test(priority=1)
  public void invalidcredentialslLogin()  {
	  login.enterPassword("1234567890");
	  login.clickLoginButton(); 
	  login.clickAlertOKButton();
	 
	  }
  @Test(priority=2)
  public void verifyErrorMsg_InvalidEmailId() throws InterruptedException {
	  Thread.sleep(2000);
	  login.enterEmail("Tizgmail.com");
	  String actualErrorMsg=login.getEmailErrorMsg();
	  TestUtils.log().info("Actual text is -"+actualErrorMsg.trim());
	  String expectedErrorMsg=" Enter a valid Ema ";
	  //Assert.assertEquals(actualErrorMsg,expectedErrorMsg);
	  verifyErrorMsgTextAssert(actualErrorMsg, expectedErrorMsg);
	
	  
	  
  }
  
 /* @Test(priority=4)
  public void  verifyErrorMsg_InvalidPassword() throws InterruptedException {
	  
	  login.enterPassword("1234e"); 
	  Thread.sleep(2000);
	  String actualErrorMsg=login.getPwdErrorMsg();
	  System.out.println("Actual text is -"+actualErrorMsg.trim());
	  String expectedErrorMsg=" Enter a valid password ";
	  Assert.assertEquals(actualErrorMsg,expectedErrorMsg);
  }
  
  @Test(priority=5)
  public void sucessfullLogin() throws InterruptedException {
	  
	  login.enterEmail("john@gmail.com");
	  login.enterPassword("123456789");
	  login.clickLoginButton(); 
	  validation.clickVerifybtn();
	 String actualHomeTxt=home.getHometext();
	  System.out.println("Actual text is -"+actualHomeTxt);
	  String expectedHomeTxt="Dashboard";
	  Assert.assertEquals(actualHomeTxt,expectedHomeTxt);
	  }
  
   @Test(priority=6)
    public void TipsPageNavigation() {
  	tips.clickTipsIcon();
  	String actualTitle=tips.getHealthTitle();
  	  System.out.println("Actual text is -"+actualTitle);
  	  String expectedTitle="Health Tips";
  	  Assert.assertEquals(actualTitle,expectedTitle);
  	
  }
  @Test(priority=7)
  public void addHealthVitals() {
	 home.clickDashboardsTab();
  	home.scrollToShowMoreElement();
  	health.clickWeightvitals();
  	health.clickAlertok();
  	health.clickSubmitWeightBtn();
  	String actualTitle=health.getMeasurementScaleTitle().trim();
	System.out.println("Actual text is -"+actualTitle);
	String expectedTitle="Submit your Weight details now.";
	Assert.assertEquals(actualTitle,expectedTitle);
	health.clickCloseBtn();
	home.clickBackBtn();
  }
  @Test(priority=8)
  public void naviagteToEditProfilScreen() {
	  profile.clickProfile();
	  profile.clickEditIcon();
	  home.clickBackBtn();
  }
  @Test(priority=9)
  public void logout() {
  	  profile.scrollToLogoutElement();
  	  profile.clickLogout();
  	  profile.clickLogoutYes();
  	
  }*/
}


