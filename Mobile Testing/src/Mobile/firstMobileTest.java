package Mobile;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class firstMobileTest {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, "abc");
			//cap.setCapability(MobileCapabilityType."PLATFORM_NAME", "Android");
			cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
			cap.setCapability("platformName", "Android");
			cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"org.khanacedemy.org");
			cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "org.khanacedemy.ui.library.MainActivity");
			cap.setCapability("chromedriverExecutable", "C:\\Reskill Program\\Driver files\\chromedriver_win32\\chromedriver.exe");
			AndroidDriver driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),cap);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get("http://google.com");
			//driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input")).click();
		
	}

}
