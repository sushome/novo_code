package com.lenovo.cochat.im;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class Action extends Constants{
	
	public AndroidDriver<AndroidElement> driver;
	public int width;
	public int height;
	
	public AndroidDriver<AndroidElement> setDriver() throws MalformedURLException {
		File projectPathRoot = new File(System.getProperty("user.dir"));
		File app = new File(projectPathRoot, "cochat.apk");
		
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION,"7.1.1");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME,"ZY22477WL2");
		caps.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,600);
		driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),caps);
		return driver;
	}
	
	public AndroidDriver<AndroidElement> getDriver(){
		return driver;
	}
	
	public void findElementAndSendKeys(String id, String keys) {
		MobileElement mobileElement = driver.findElementById(id);
		mobileElement.sendKeys(keys);
	}
	
	public void findElementAndClick(String id) {
		MobileElement mobileElement = driver.findElementById(id);
		mobileElement.click();
	}
	
	public void tapElement(String id) {
		TouchAction action = new TouchAction((MobileDriver) driver);
		MobileElement mobileElement = driver.findElementById(id);
		action.tap(mobileElement);
	}
	
	public int getWidth(AndroidDriver<AndroidElement> driver) {
		width = driver.manage().window().getSize().width;
		return width;
	}
	
	public int getHeight(AndroidDriver<AndroidElement> driver) {
		height = driver.manage().window().getSize().height;
		return height;
	}
		
	public void Swipe4AndLogin(AndroidDriver<AndroidElement> driver) throws MalformedURLException {
		width = getWidth(driver);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		height = getHeight(driver);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		tapElement(START_PAGE);
		driver.swipe(width*9/10, height/2, width/10, height/2, 500);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.swipe(width*9/10, height/2, width/10, height/2, 500);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.swipe(width*9/10, height/2, width/10, height/2, 500);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.swipe(width*9/10, height/2, width/10, height/2, 500);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		findElementAndSendKeys(USERNAME_FIELD, USERNAME);
		findElementAndSendKeys(PASSWORD_FIELD, PASSWORD);
		findElementAndClick(LOGIN_BUTTON);
		}
}
