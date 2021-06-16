package com.cyient.test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class BigBasketLoginTest {

	
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
		
		driver.findElementByAndroidUIAutomator("UiSelector().descriptionContains(\"Open navigation\")").click();
		
		driver.findElementByAndroidUIAutomator("UiSelector().text(\"Login\")").click();
		
		driver.findElementByAndroidUIAutomator("UiSelector().text(\"Mobile Number (10-digit) / Email Address\")").sendKeys("1111111111");

		if(driver.isKeyboardShown()) 
		{
			driver.hideKeyboard();
		}
		
		
		driver.findElementByAndroidUIAutomator("UiSelector().text(\"Login Using OTP\")").click();
		
		
	
	
	}

}
