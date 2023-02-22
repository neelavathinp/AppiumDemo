package com.qa.pages;

import org.openqa.selenium.WebElement;

import com.qa.generic.BaseTest;

import io.appium.java_client.pagefactory.AndroidFindBy;

public class Loginpage extends BaseTest{
	
	@AndroidFindBy(accessibility="input_email")
	private WebElement emailField;//define WebElement

	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.EditText")
	private WebElement passwordField;
	
	@AndroidFindBy(xpath="//*[@text='Login']")
	private WebElement loginBtn;
		
	@AndroidFindBy(xpath="//android.widget.TextView[@content-desc='text_emailError']")
	private WebElement emailIdErrorMsg;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Enter a valid password' or @index='6']")
	private WebElement pwdErrorMsg;
	///hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button
	@AndroidFindBy(xpath="//android.widget.Button[@text='OK']")
	private WebElement alertOkBtnWrong;
//Actions/operations
//entering un and staying on same page so we need to return object of samePage/class no need to specifically intialise that page >>Fluent page object model
public Loginpage enterEmail(String email) {
sendKeys(emailField,email);
return this;
}
public Loginpage enterPassword(String pwd) {
sendKeys(passwordField,pwd);
return this;
}
public ValidationPage clickLoginButton() {
	click(loginBtn);
return new ValidationPage();//return object of next page/initialise object of the page
}

public String getEmailErrorMsg() {
	// TODO Auto-generated method stub
	return getAttribute(emailIdErrorMsg,"text");
}
public String getPwdErrorMsg() {
	// TODO Auto-generated method stub
	return getAttribute(pwdErrorMsg,"text");
}
public Loginpage clickAlertOKButton() {
	click(alertOkBtnWrong);
	return this;
	}

}
