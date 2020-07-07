package Mobile;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class udemyRegister {
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Udemy");
			cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
			cap.setCapability(MobileCapabilityType.NO_RESET, false);
			cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"com.udemy.android");
			cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.udemy.android.SplashActivity");
		
			AndroidDriver driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),cap);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Sign in\")")).click();
			driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"New here? Create an account\")")).click();
			driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Sign up with email\")")).click();
			driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Name\")")).sendKeys("SillyLilly");
			driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Email\")")).sendKeys("SillyLilly@gmail.com");
			driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Password (8+ characters)\")")).sendKeys("SillyLilly@gmail.com");
			driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Create account\")")).click();
			System.out.println("Udemy Account is created successfully");
			
			driver.quit();
	}		

}
