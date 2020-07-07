package Mobile;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class KhanAcademyTC1 {
	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, "abcd");
			cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
			cap.setCapability(MobileCapabilityType.NO_RESET, false);
			cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"org.khanacademy.android");
			cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "org.khanacademy.android.ui.library.MainActivity");
			
			AndroidDriver driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),cap);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Dismiss\")")).click();
			driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Dismiss\")")).click();
			driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Sign in\")")).click();
			driver.findElement(MobileBy.AccessibilityId("Continue with Facebook")).click();
			
			//With Native app
//			driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"Username\"]")).sendKeys("Silly@gmail.com");
//			driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"Password\"]")).sendKeys("Silly@gmail.com");
//			driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Log In\"]")).click();
			
			//without native app
			//Thread.sleep(10000);
//			System.out.println(driver.getContextHandles());
//			System.out.println("hello");
//			driver.context("NATIVE_APP");
//			System.out.println(driver.getContext());
//			driver.findElement(MobileBy.AccessibilityId("Username")).sendKeys("Lilly@gmail.com");
			
			driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().resourceId(\"m_login_email\")")).sendKeys("Lilly@gmail.com");
			driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().resourceId(\"m_login_password\")")).sendKeys("Lilly@gmail.com");
			driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Log In\")")).click();
	}
}