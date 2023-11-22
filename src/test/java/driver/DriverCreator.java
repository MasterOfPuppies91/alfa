package driver;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverCreator {

    private static AndroidDriver<?> driver;

    public static AndroidDriver<?> getDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "android");
        capabilities.setCapability("deviceName", "Pixel 3 XL API 34");
        capabilities.setCapability("appPackage", "com.alfabank.qapp");
        capabilities.setCapability("appActivity", "com.alfabank.qapp.presentation.MainActivity");
        capabilities.setCapability("automationName", "UiAutomator2");

        driver = new AndroidDriver<MobileElement>(AppiumServerCreator.get(), capabilities);

        return driver;
    }
}
