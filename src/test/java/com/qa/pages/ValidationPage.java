package com.qa.pages;

import org.openqa.selenium.WebElement;

import com.qa.generic.BaseTest;

import io.appium.java_client.pagefactory.AndroidFindBy;

public class ValidationPage extends BaseTest {
	@AndroidFindBy(xpath="//android.widget.EditText[@index='1']")//index 2/3/4
	private WebElement otpfield1;
	
	@AndroidFindBy(xpath="//android.view.ViewGroup[@content-desc=\"button_verify_create\"]/android.widget.TextView")
	private WebElement verifyBtn;

	@AndroidFindBy(xpath="//android.widget.TextView[@text='Didn't receive code? Resend']")
	private WebElement resendLink;
	
	public HomePage clickVerifybtn() {
		click(verifyBtn);
		return new HomePage();//return object of next page/initialise object of the page
	}

	public HomePage clickResendbtn() {
		//click(resendBtn);
		return new HomePage();//return object of next page/initialise object of the page
	}

}
