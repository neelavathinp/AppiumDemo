package com.qa.pages;

import org.openqa.selenium.WebElement;

import com.qa.generic.BaseTest;

import io.appium.java_client.pagefactory.AndroidFindBy;

public class TipsPage extends BaseTest {
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Health Tips']")
	private WebElement  tipsTitle;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Tips']")
	private WebElement tipsTab;
	
	public String getHealthTitle() {
		// TODO Auto-generated method stub
		return getAttribute(tipsTitle,"text");
}
	public TipsPage clickTipsIcon() {
		click(tipsTab);
		return new TipsPage();
	}

	
}
