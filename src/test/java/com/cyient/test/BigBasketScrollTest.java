package com.cyient.test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.ClickAction;
import org.openqa.selenium.remote.DesiredCapabilities;


import io.appium.java_client.android.AndroidDriver;

public class BigBasketScrollTest {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		DesiredCapabilities cap= new DesiredCapabilities();
		
		cap.setCapability("deviceName", "redmi");
		cap.setCapability("platformName", "Android");
		
		cap.setCapability("app", "C:\\Users\\pk59159\\Downloads\\com.bigbasket.mobileapp_2021-05-29.apk");
		
		
		AndroidDriver<WebElement> driver=new AndroidDriver<WebElement>(new URL("http://localhost:4723/wd/hub"), cap);
		
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

		
		driver.findElementByXPath("//*[@text='CHOOSE LOCATION']").click();
		driver.findElementByXPath("//*[@text='ALLOW']").click();
		Thread.sleep(5000);
		driver.findElementByXPath("//*[@text='EXPLORE BANGALORE STORE']").click();
		
		
	       
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		while(driver.findElementsByAndroidUIAutomator("UiSelector().resourceId(\"com.bigbasket.mobileapp:id/imgCategory\").index(0)").size()==0)
		{
			//scroll
			Map<String,String> map= new HashMap<String,String>();
			map.put("command", "input touchscreen swipe 1007 1323 1007 1167");
			driver.executeScript("mobile:shell", map);
		}
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		driver.findElementByAndroidUIAutomator("UiSelector().resourceId(\"com.bigbasket.mobileapp:id/imgCategory\").index(0)").click();
		Thread.sleep(5000);
		driver.findElementByAndroidUIAutomator("UiSelector().resourceId(\"com.bigbasket.mobileapp:id/imgCategory\").index(1)").click();
		
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		while(driver.findElementsByAndroidUIAutomator("UiSelector().text(\"Coconut - Medium\")").size()==0)
		{
			//scroll
			Map<String,String> map= new HashMap<String,String>();
			map.put("command", "input touchscreen swipe 1007 1323 1007 1167");
			driver.executeScript("mobile:shell", map);
		}
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElementByAndroidUIAutomator("UiSelector().text(\"Add\")").click();
		Thread.sleep(5000);
		driver.findElementByAndroidUIAutomator("UiSelector().resourceId(\"com.bigbasket.mobileapp:id/viewIncBasketQty\").index(2)").click();
		Thread.sleep(5000);
		driver.findElementByAndroidUIAutomator("UiSelector().descriptionContains(\"Remove\")").click();
		
		
		
		
	}
	

}
