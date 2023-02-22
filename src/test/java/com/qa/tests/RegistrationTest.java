package com.qa.tests;

import org.testng.annotations.Test;

import com.qa.generic.BaseTest;
import com.qa.pages.HomePage;
import com.qa.pages.Loginpage;
import com.qa.pages.RegistrationPage;
import com.qa.pages.StartPage;
import com.qa.pages.ValidationPage;

import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class RegistrationTest extends BaseTest {
	StartPage start;
	Loginpage login;
	RegistrationPage register;
	ValidationPage validation;
	HomePage home;
  
  @BeforeMethod
  public void beforeMethod() {
	 start=new StartPage();
	 register=new RegistrationPage();
	 login=new Loginpage();
	 validation=new ValidationPage();
	 home =new HomePage();
	 
  }
  @Test(priority=0)
  public void registrationScreenNavigation() {
	  start.enterEmail("testtia05@gmail.com");   
	 /*String actualText= register.getFirstNameText();
	 String expectedtext="First Name";
	 Assert.assertEquals(actualText, expectedtext);*/
  }
 @Test(priority=1)
  public void registrationFirstNameFieldErrorValidations() {
	  register.enterFirstName("A");
	  String actualerror= register.getfirstNameErrorMsg().trim();
	  String expectederror="Enter valid First Name";
	  Assert.assertEquals(actualerror, expectederror);
	   
  }
  /*@Test(priority=2)
  public void registrationLastNameFieldErrorValidations() {
	  register.enterLastName("Li");
	  String actualText= register.getlastNameErrorMsg().trim();
	  String expectedtext="Enter valid Last Name";
	  Assert.assertEquals(actualText, expectedtext);
	   
  }
  @Test(priority=3)
  public void navigationToPhoneNoFields() {
	  register.enterFirstName("Tia");
	  register.enterLastName("Lia");
	  register.clickNextBtn();
	  String actualText= register.getPhonetxt();
	  String expectedtext="Phone";
	  Assert.assertEquals(actualText, expectedtext);
	   
  }
  @Test(priority=4)
  public void phoneNoFieldErrorValidation() {
	 
	  register.enterPhoneNo("890");
	  String actualText= register.getPhoneErrorMsg().trim();
	  String expectedtext="Enter a valid Contact No";
	  Assert.assertEquals(actualText, expectedtext);
	   
  }
  @Test(priority=5)
  public void navigationToPwdFielValidation() {
	  register.enterPhoneNo("8912345677");
	  register.clickNextBtn();
	   
  }
  @Test(priority=6)
  public void pwdFieldErrorValdation() {
	  register.enterPwd("1234");
	  String actualText= register.getpwdErrorMsg().trim();
	  String expectedtext="Password should be minimum 9 characters";
	  Assert.assertEquals(actualText, expectedtext);
	   
  }
  @Test(priority=7)
  public void confirmpwdFieldErrorValdation() {
	  register.enterPwd("1234@4321");
	  register.enterConfirmPwd("1234@1234");
	  String actualText= register.getconfirmPwdErrorMsg().trim();
	  String expectedtext="Password and Confirm Password does not match";
	  Assert.assertEquals(actualText, expectedtext);
	   
  }
  @Test(priority=7)
  public void navigateToValidationScreen() {
	  register.enterPwd("1234@4321");
	  register.enterConfirmPwd("1234@4321");
	 register.clickSignUpBtn();
  }
	   
  @Test(priority=7)
  public void successfulRegistration() {
	  validation.clickVerifybtn();
	  //validation.clickResendbtn();
	 String actualHomeTxt=home.getHometext();
	  System.out.println("Actual text is -"+actualHomeTxt);
	  String expectedHomeTxt="Dashboard";
	  Assert.assertEquals(actualHomeTxt,expectedHomeTxt);
	   
  }*/

  @AfterMethod
  public void afterMethod() {
  }

}
