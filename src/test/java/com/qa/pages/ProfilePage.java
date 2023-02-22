package com.qa.pages;

import org.openqa.selenium.WebElement;

import com.qa.generic.BaseTest;

import io.appium.java_client.pagefactory.AndroidFindBy;

public class ProfilePage extends BaseTest {
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Profile']")
	private WebElement profileIconTab;	

	@AndroidFindBy(xpath="//*[@text='Logout']")
	private WebElement logoutopt;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Yes']")
	private WebElement logoutYesopt;	

	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView")
	private WebElement editicon;
	
	public ProfilePage clickEditIcon() {
		click(editicon);
		return this;
	}
	
	public ProfilePage clickProfile() {
		click(profileIconTab);
		return new ProfilePage();
	}
	
	public ProfilePage clickLogout() {
		click(logoutopt);
		return this;
	}
	public ProfilePage clickLogoutYes() {
		click(logoutYesopt);
		return new ProfilePage();
	}
	public void scrollToLogoutElement() {
		scrollToVisiblityOfElement("Logout");
		
	}
}




