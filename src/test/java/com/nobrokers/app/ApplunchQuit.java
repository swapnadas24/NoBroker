package com.nobrokers.app;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class ApplunchQuit {
    AndroidDriver<AndroidElement> driver;
	Properties props;

	@BeforeTest
	public void lunch() throws InterruptedException, IOException {

	 // Load the properties File
		props = new Properties();
		FileInputStream objfile = new FileInputStream(System.getProperty("user.dir") + "//application.properties");
		props.load(objfile);
 
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "W89DN7UGWWPBHUJZ");
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.0");
		caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.nobroker.app");
		caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.nobroker.app.activities.NBSplashScreen");
		caps.setCapability("unicodeKeyboard", "true");
		caps.setCapability("resetKeyboard", "false");

		// lunch app
		driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
		Thread.sleep(2000);		
    }
    @AfterTest
	public void quit() {
    	driver.quit();
		
	}


}