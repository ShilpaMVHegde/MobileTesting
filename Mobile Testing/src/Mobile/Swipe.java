package Mobile;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import javax.xml.datatype.Duration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.PointOption;


public class Swipe {
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
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
			
			driver.findElement(MobileBy.AccessibilityId("Search tab")).click();
			driver.findElement(MobileBy.AccessibilityId("Search")).sendKeys("Math");
			
			driver.hideKeyboard();
			
			//driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Doodling in math: Stars\")")).click();
			//driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Doodling in math: Stars\")"));
			
			Thread.sleep(10000);
			TouchAction act = new TouchAction(driver);
			Dimension d = driver.manage().window().getSize();
			int width = d.width;
			int height = d.height;
			int x1 = width/2;
			int y1 = 4*height/5;
			int x2 = width/2;
			int y2 = height/5;
			
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			while(driver.findElements(MobileBy.AndroidUIAutomator("UiSelector().text(\"Math patterns: table\")")).size()==0)
					{
						//act.press(PointOption.point(x1,y1)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(PointOption.point(x2,y2)).release().perform();
						driver.executeScript("mobile:shell", ImmutableMap.of("command", "input swipe "+x1+" "+y1+" "+x2+" "+y2));
					}
			driver.openNotifications();
			driver.findElement(MobileBy.AccessibilityId("Airplane mode")).click();
			driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Gmail\")")).click();
	}
}
