package arjun.test.appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class Testing {
	// https://www.science.co.il/language/Locale-codes.php   // locales
	static String platformName = "Android";

	public static void main(String[] args) throws Exception {
		Testing.run();
	}

	public static void run() throws Exception {
		AppiumDriver wb = null;
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities = getDesiredCaps();

		System.out.println("Creating driver");
		wb = LaunchDriver(capabilities);

		if (wb != null) {
			System.out.println("driver created ");
			Thread.sleep(5000);

		}

	}

	public static DesiredCapabilities getDesiredCaps() {

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("language", "en");
		capabilities.setCapability("locale", "en");
		capabilities.setCapability("appium:newCommandTimeout", 0);
		capabilities.setCapability("appium:launchTimeout", 90000);
		capabilities.setCapability("appium:udid", "RZ8R90JR1BX");
		capabilities.setCapability("appium:automationName", "UiAutomator2");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("appium:app", "E:\\Neonify-Resources\\injectapk\\inject.apk");
		capabilities.setCapability("appium:appPackage", "com.sssts.opkey.opkeysmartrecorder");
		capabilities.setCapability("appium:appActivity", "com.sssts.opkey.opkeysmartrecorder.MainActivity");
		return capabilities;

	}

	public static void switchContext(AppiumDriver wb, ArrayList<String> contextsList) {

		for (String str : contextsList) {
			if (str.contains("WEBVIEW")) {
				try {
					// wb.execute(MobileCommand.SWITCH_TO_CONTEXT, Map.of("name", str));
					System.out.println("context changed successfully");
					ArrayList<WebElement> eles = (ArrayList<WebElement>) wb.findElements(By.id("divLikeInput"));
					if (eles.size() >= 1) {
						System.out.println("eles found ");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		}

	}

	public static AppiumDriver LaunchDriver(DesiredCapabilities caps) throws MalformedURLException {
		URL url = new URL("http://127.0.0.1:4723/wd/hub/");
		AppiumDriver wb = null;
		try {
			wb = new AndroidDriver(url, caps);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return wb;
	}

}
