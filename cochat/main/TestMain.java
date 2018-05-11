package com.lenovo.cochat.main;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.javascript.host.Element;
import com.lenovo.cochat.im.Action;
import com.lenovo.cochat.im.Constants;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class TestMain extends Action{
	Constants constant = new Constants();
	
	@Test(description = "Step01_login")
	public void test_login() throws MalformedURLException, InterruptedException {
		driver = setDriver();
		Swipe4AndLogin(driver);
	}
	
	@Test(dependsOnMethods = {"test_login"}, description = "Step02_addOnTheTop")
	public void test_addOnTheTop() throws InterruptedException {
		Thread.sleep(2000);
		findElementAndClick(constant.ADD_BUTTON);
		Thread.sleep(3000);
		driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout[3]/android.widget.TextView").click();;
	}
	
}
