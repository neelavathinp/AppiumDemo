package com.qa.pages;

import org.openqa.selenium.WebElement;

import com.qa.generic.BaseTest;

import io.appium.java_client.pagefactory.AndroidFindBy;

public class RegistrationPage extends BaseTest{
	
	@AndroidFindBy(xpath="//android.widget.EditText[@text='First Name']")
	private WebElement firstnameFieldPlaceholder;

	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.EditText")
	private WebElement firstnameField;
	
	
	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView[3]")
	private WebElement firstnameFieldErrorMsg;
	
	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.widget.EditText")
	private WebElement lasttnameField;//define WebElement
	
	
	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView[6]")
	private WebElement lasttnameFieldErrorMsg;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Next']")
	private WebElement nextBtn;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Phone']")
	private WebElement phoneTxt;
	
	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.EditText")
	private WebElement PhonNoField;//define WebElement
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Enter a valid Contact No']")
	private WebElement PhonNoFieldErrorMsg;//define WebElement
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Next']")
	private WebElement nextPhnBtn;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Password']")
	private WebElement pwdTxt;
	

	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.EditText")
	private WebElement pwdField;//define WebElement
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Password should be minimum 9 characters']")
	private WebElement pwdFieldErrorMsg;//define WebElement
	
	
	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.widget.EditText")
	private WebElement confirmpwdField;//define WebElement
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Password and Confirm Password does not match']")
	private WebElement confirmPwdFieldErrorMsg;//define WebElement

	
	@AndroidFindBy(xpath="//android.view.ViewGroup[@content-desc='button_login']/android.widget.TextView")
	private WebElement loginLink;//define WebElement
	

	@AndroidFindBy(xpath="//android.widget.TextView[@text='Sign Up']")
	private WebElement signUpBtn;//define WebElement
	

	@AndroidFindBy(xpath="//android.widget.TextView[@text='Already have an account?']")
	private WebElement signUptxt;
	
	@AndroidFindBy(xpath="//android.widget.Button[@text='OK']")
	private WebElement okBtn;
	
	public RegistrationPage enterFirstName(String name) {
		sendKeys(firstnameField, name);
		return this;
	}
	public RegistrationPage enterLastName(String name) {
		sendKeys(lasttnameField, name);
		return this;
	}
	public RegistrationPage clickNextBtn() {
		click(nextBtn);
		return new RegistrationPage();
	}
	public RegistrationPage enterPhoneNo(String phn) {
		sendKeys(PhonNoField,phn);
		return this;
	}
	
	public RegistrationPage enterPwd(String pwd) {
		sendKeys(pwdField, pwd);
		return this;
	}
	public RegistrationPage enterConfirmPwd(String pwd) {
		sendKeys(confirmpwdField, pwd);
		return this;
	}
	public HomePage clicklogin() {
		click(loginLink);
		return new HomePage ();
	}

	public HomePage clickOkBtn() {
		click(okBtn);
		return new HomePage();
	}
	public HomePage clickSignUpBtn() {
		click(signUpBtn);
		return new HomePage();
	}
	//get attributes >>returns the value of a specified attribute on the element
public String getFirstNameText() {
	return getAttribute(firstnameFieldPlaceholder,"text");
}
public String getPhonetxt(){
	return getAttribute(phoneTxt,"text");
}
	//get error msg methods
	public String getfirstNameErrorMsg() {
		return getAttribute(firstnameFieldErrorMsg,"text");
	}
	public String getlastNameErrorMsg() {
		return getAttribute(lasttnameFieldErrorMsg,"text");
	}
	public String getPhoneErrorMsg() {
		return getAttribute(PhonNoFieldErrorMsg,"text");
	}
	
	public String getpwdErrorMsg() {
		return getAttribute(pwdFieldErrorMsg,"text");
	}
	public String getconfirmPwdErrorMsg() {
		return getAttribute(confirmPwdFieldErrorMsg,"text");
	}
	public String getsignUpScreenText() {
		return getAttribute(firstnameFieldPlaceholder,"text");
	}
	public void scrollToElement() {
		scrollToVisiblityOfElement("Sign Up");
		
	}
}



