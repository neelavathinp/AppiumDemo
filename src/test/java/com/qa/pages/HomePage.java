package com.qa.pages;

import org.openqa.selenium.WebElement;

import com.qa.generic.BaseTest;

import io.appium.java_client.pagefactory.AndroidFindBy;

public class HomePage extends BaseTest{
	@AndroidFindBy(xpath="//*[@text='Dashboard']")
	private WebElement dashboard;
	
	@AndroidFindBy(xpath="//*[@text='Show more']")
	private WebElement Showmoreopt;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='󰁍']")
	private WebElement backBtn;
	
	public HomePage clickBackBtn() {
		click(backBtn);
		return this;
	}
	
	public String getHometext() {
		return getAttribute(dashboard, "text");
	}
	public HomePage clickDashboardsTab() {
		click(dashboard);
		return this;
	}
	
	public void scrollToShowMoreElement() {
		scrollToVisiblityOfElement("Show more");
		
	}
}
	
	

