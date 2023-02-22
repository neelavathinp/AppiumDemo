package com.qa.pages;

import org.openqa.selenium.WebElement;

import com.qa.generic.BaseTest;

import io.appium.java_client.pagefactory.AndroidFindBy;

public class HealthVitalsPage extends BaseTest{
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Weight']")
	private WebElement weightOpt;
	
	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button")
	private WebElement AlertOk;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Submit Weight']")
	private WebElement SubmitWeightBtn;

	@AndroidFindBy(xpath="//android.widget.TextView[@text='Submit your Weight details now.']")
	private WebElement measurementScaleTxt;
	
	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.HorizontalScrollView/android.view.ViewGroup")
	private WebElement  measurementScale;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Submit']")
	private WebElement submitbtn;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Close']")
	private WebElement closebtn;
	
	public HealthVitalsPage clickWeightvitals() {
		click(weightOpt);
		return new HealthVitalsPage();
	}
	public HealthVitalsPage clickAlertok() {
		click(AlertOk);
		return this;	
	}
	public String getMeasurementScaleTitle() {
		return getAttribute(measurementScaleTxt, "text");
	}
	public HealthVitalsPage clickSubmitWeightBtn() {
		click(SubmitWeightBtn);
		return this;	
	}
	public HealthVitalsPage clickSubmitBtn() {
		click(submitbtn);
		return this;	
	}
	public HealthVitalsPage clickCloseBtn() {
		click(closebtn);
		return this;
	}
}
	
	


