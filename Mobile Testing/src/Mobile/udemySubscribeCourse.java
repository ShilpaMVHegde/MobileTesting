package Mobile;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class udemySubscribeCourse {

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
			
			driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Browse\")")).click();
			driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Search\")")).click();
			driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Search all courses\")")).click();
			driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Search all courses\")")).sendKeys("Selenium");
			driver.hideKeyboard();
			driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"selenium\")")).click();
			
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[3]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.widget.ImageView\r\n" + 
					"")).click();
			
			TouchAction act = new TouchAction(driver);
			Dimension d = driver.manage().window().getSize();
			int width = d.width;
			int height = d.height;
			int x1 = width/2;
			int y1 = 4*height/4;
			int x2 = width/2;
			int y2 = height/4;
			
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			while(driver.findElements(MobileBy.AndroidUIAutomator("UiSelector().text(\"Add to Cart\")")).size()==0)
					{
						//act.press(PointOption.point(x1,y1)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(PointOption.point(x2,y2)).release().perform();
						driver.executeScript("mobile:shell", ImmutableMap.of("command", "input swipe "+x1+" "+y1+" "+x2+" "+y2));
					}
			driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Add to Cart\")")).click();
			driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Cancel\")")).click();
			
			driver.quit();
			
			
	}
}