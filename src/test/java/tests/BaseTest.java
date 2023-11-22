package tests;

import driver.AppiumServerCreator;
import driver.DriverCreator;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
    protected AndroidDriver<?> driver;

    @BeforeSuite
    public void setUpSuite(){
        AppiumServerCreator.init();
    }

    @BeforeClass
    public void setUp() {
        driver = DriverCreator.getDriver();
    }

    @AfterClass
    public void tearDown() {
        driver.closeApp();
    }

    @AfterSuite
    public void tearDownSuite() {
        AppiumServerCreator.stop();
    }
}
