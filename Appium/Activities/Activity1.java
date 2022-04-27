package activity;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Activity1 {
    AndroidDriver<MobileElement> driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        //Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("deviceName", "Pixel4Emulator");
        caps.setCapability("appPackage","com.android.calculator2");
        caps.setCapability("appActivity", "Calculator");
        caps.setCapability("noReset", true);

        //Server URL
        URL serverURL = new URL("http://0.0.0.0:4723/wb/hub");
        driver = new AndroidDriver<MobileElement>(serverURL, caps);
    }

    @Test
    public void calculator(){
        MobileElement digit5 = driver.findElementById("digit_5");
        //Click 5
        digit5.click();
        //Find and click Multiplication
        driver.findElementByAccessibilityId("Multiply").click();
        //Find 5
        MobileElement digit6 = driver.findElementById("digit_6");
        digit6.click();
        //Click Equal sign

        driver.findElementByAccessibilityId("Equals").click();
        //Get Result
        String resultValue = driver.findElementById("result").getText();
        //Assertion
        Assert.assertEquals(resultValue,"30");
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
