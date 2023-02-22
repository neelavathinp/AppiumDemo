package com.qa.pages;

import org.openqa.selenium.WebElement;

import com.qa.generic.BaseTest;
import com.qa.utilities.TestUtils;

import io.appium.java_client.pagefactory.AndroidFindBy;

public class StartPage extends BaseTest {
	@AndroidFindBy(xpath="//android.widget.EditText[@content-desc=\"input_email\"]")
	private WebElement emailField;//define WebElement

	@AndroidFindBy(xpath="//android.widget.TextView[@text='Continue']")
	private WebElement continueBtn;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Email']")
	private WebElement emailPlaceholder;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@content-desc='text_emailError']")
	private WebElement emailErrorMsg;
	
	public StartPage enterEmail(String email) {
		TestUtils.log().info("--Entering Email Adress--"+email);
		sendKeys(emailField, email);
		return this;
	}
	
	public RegistrationPage clickContinue(){
		click(continueBtn);
		return new RegistrationPage();
	}
	public String getErrorMsg() {
		return getAttribute(emailErrorMsg,"text");
	}
}
