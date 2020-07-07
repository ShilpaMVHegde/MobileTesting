package Mobile;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class amazonSignUp {
		
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
	DesiredCapabilities cap = new DesiredCapabilities();
	cap.setCapability(MobileCapabilityType.DEVICE_NAME, "abc");
	cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
	
	cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.udemy.android");
	cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.udemy.android.SplashActivity");
	AndroidDriver <AndroidElement> driver = new AndroidDriver <AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"),cap);
		
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Sign in\")")).click();
	driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Sign in with Facebook\")")).click();
	
	driver.findElement(MobileBy.AccessibilityId("Username")).sendKeys("<username>");
	driver.findElement(MobileBy.AccessibilityId("Password")).sendKeys("<password>");
	driver.findElement(MobileBy.AccessibilityId("Log In")).click();
	driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"CONTINUE AS SHILPAHEGDE\")")).click();
	
	
	driver.quit();
	

}
}
