package com.qa.generic;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qa.utilities.ExtentReportclass;
import com.qa.utilities.TestUtils;


import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

public class BaseTest {
	public AppiumDriverLocalService service;
	protected static ThreadLocal <AppiumDriver> driver = new ThreadLocal<AppiumDriver>();
   // private static Properties property;//create Properties object at class level
	protected static ThreadLocal <Properties> property = new ThreadLocal<Properties>();
    protected static ThreadLocal <String> deviceName = new ThreadLocal<String>();
    protected static ThreadLocal <String> udid = new ThreadLocal<String>();
    protected static ThreadLocal <String> platformName = new ThreadLocal<String>();
   FileInputStream fis;
  InputStream inputstream;

  
 public AppiumDriver getDriver() {
	  return driver.get();
  }
  
  public void setDriver(AppiumDriver driver2) {
	  driver.set(driver2);
  }
  public String getDeviceName() {
	  return deviceName.get();
  }
  
  public void setDeviceName(String deviceName2) {
	  deviceName.set(deviceName2);
  }
  public String getUDID() {
	  return udid.get();
  }
  
  public void setUDID(String udid2) {
	  udid.set(udid2);
  }
  public String getPlatform() {
	  return platformName.get();
  }
  
  public void setPlatform(String platformName2) {
	  platformName.set(platformName2);
  }
  public Properties getProps() {
	  return property.get();
  }
  
  public void setProps(Properties props2) {
	  property.set(props2);
  }
  public BaseTest() {
		PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
	}
  @BeforeSuite
	 public void StartServer() {
		//nodjs path/server path/AppiumMAinJSPAth
		service=AppiumDriverLocalService.buildService(new AppiumServiceBuilder().usingDriverExecutable(new File(TestUtils.NodeExePath))
				.withAppiumJS(new File(TestUtils.NodeJSPath)).usingPort(4723).withTimeout(Duration.ofSeconds(300))
				.withArgument(GeneralServerFlag.SESSION_OVERRIDE));
		//.withLogFile(new File("C:\\Users\\Treesa.Martin\\Desktop\\AppiumServerlog.txt")));
		 TestUtils.log().info("-------------Appium server has started successfully---------");
	   service.start();
	}
  @AfterSuite (alwaysRun = true)
	public void afterSuite() {
		service.stop();
		 TestUtils.log().info("-------------Appium server has stopped successfully---------");
		  }
  @Parameters({"platformName","deviceName","udid"})
     @BeforeClass
		public void intializeDriver(String platformName,String deviceName,String udid) throws Exception  {
	 /* property=new Properties();
		fis=new FileInputStream("D:\\Automation-Mobile\\CIPLAPOCDemoFramework1\\src\\main\\resources\\config.properties");
		//("D:\\Automation-Mobile\\AppiumDemoFramework\\src\\main\\resources\\config.properties");
		property.load(fis);*/
	  /*property= new Properties();
	  String propFileName= "config.properties";
	  inputstream=getClass().getClassLoader().getResourceAsStream(propFileName);
	  property.load(inputstream);*/
	  Properties property = new Properties();
	  String propFileName = "config.properties";
	  InputStream inputstream = getClass().getClassLoader().getResourceAsStream(propFileName);
	  property.load(inputstream);
	  setProps(property);
			AppiumDriver driver;
			setDeviceName(deviceName);
			setUDID(udid);
			setPlatform(platformName);
			 
  DesiredCapabilities caps=new DesiredCapabilities();
	caps.setCapability("ignoreHiddenApiPolicyError", true);//avoid server error
	caps.setCapability("platformName",platformName);
	caps.setCapability("deviceName",deviceName);
	
	caps.setCapability("udid",udid);
	caps.setCapability("automationName",property.getProperty("androidAutomationName"));
	caps.setCapability("appPackage", property.getProperty("androidAppPackage"));
	caps.setCapability("appActivity", property.getProperty("androidAppActivity"));
	//caps.setCapability("app", "D:\\MobileTestingFiles\\Cipla-Poc-31-Jan.apk");
	String appURL=System.getProperty("user.dir") + File.separator +"src\\test\\resources\\app\\Cipla-Poc-31-Jan.apk";
	System.out.println(appURL);
	caps.setCapability(MobileCapabilityType.APP,appURL);
	driver= new AndroidDriver(caps);
	setDriver(driver);
	
  }
  
	//driver commands/explicit waits  managing  in parentclass to reuse in codes
  public void waitForVisibilityOf(WebElement el)  {
	   try {
	      WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(TestUtils.WAIT));
	      wait.until(ExpectedConditions.visibilityOf(el));
	   } catch (TimeoutException ex) {
		   TestUtils.log().error("An exception occurred while waiting for visibility of element: " + ex);
		   throw ex; 
	   }
	}
public void click(WebElement el)  {
	try {
	
	waitForVisibilityOf(el);
	el.click();
	} catch (NoSuchElementException ex) {
		   TestUtils.log().error("An exception occurred while waiting for visibility of element: " + ex);
		   throw ex; 
	   }
}
public void sendKeys(WebElement el,String text)  {
	try {
	waitForVisibilityOf(el);
	el.sendKeys(text);
	 } catch (NoSuchElementException ex) {
		   TestUtils.log().error("An exception occurred while sending keys: " + ex);
		   throw ex; 
	      
	   }
}
	
public String getAttribute(WebElement el,String attribute){
	waitForVisibilityOf(el);
	return el.getAttribute(attribute);
}
public static void verifyErrorMsgTextAssert(String actualErrorMsg,String expectedErrorMsg) {
	try {
	Assert.assertEquals(actualErrorMsg.trim(),expectedErrorMsg.trim());
	}
	catch(AssertionError ex)  {
		 TestUtils.log().error("An Assertion occurred while verifying the error message",ex);
		throw ex; 
	}
}
public void scrollToVisiblityOfElement(String visibleText) {
	  getDriver().findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+visibleText+"\").instance(0))"));
		
	}
	//ss code
	   public String getScreenShotPaths(String testCaseName) throws IOException{
		   BaseTest base=new BaseTest();
			
			String timestamp = new SimpleDateFormat("dd_MM_yyy__hh_mm_ss").format(new Date());
			File source=base.getDriver().getScreenshotAs(OutputType.FILE);//file is created in raw format so keep destination
			String destination=System.getProperty("user.dir")+"//reports//"+testCaseName+" "+timestamp+".png";
			FileUtils.copyFile(source, new File(destination));//keep dest also in file format
			return destination;//capture ss and keep in flder/add it in extent report
			
		}
	@AfterClass
	public void quitDriver() {
		getDriver().quit();
		
	}
	
	
	
}


