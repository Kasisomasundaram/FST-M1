package Testing;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
public class Activity4 {

    AndroidDriver<MobileElement> driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        // Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Pixel4Emulator");
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "com.android.chrome");
        caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
        //caps.setCapability(CapabilityType.BROWSER_NAME, "Chrome");
        //caps.setCapability(CapabilityType.VERSION, "69");
        caps.setCapability("noReset", true);

        // Instantiate Appium Driver
        URL appServer = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver<>(appServer, caps);
        wait = new WebDriverWait(driver, 20);
        driver.get("https://www.training-support.net/selenium");
    }
    public void scrollTo(String text)
    {
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+text+"\").instance(0))");
    }
    @Test
    public void loginWithValidCred() throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.view.View")));
        String UiScrollable = "UiScrollable(UiSelector().scrollable(true))";
        driver.findElement(MobileBy.AndroidUIAutomator(UiScrollable + ".scrollForward(20).scrollIntoView(textContains(\"Login Form\"))")).click();
        login("admin","password");
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.view.View[contains(@text, 'Welcome Back, admin')]")));
        boolean isDisplayed=driver.findElementByXPath("//android.view.View[contains(@text, 'Welcome Back, admin')]").isDisplayed();

        // Assertion
        Assert.assertTrue(isDisplayed);
    }
    @Test
    public void loginWithInValidCred() throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.view.View")));
        String UiScrollable = "UiScrollable(UiSelector().scrollable(true))";
        driver.findElement(MobileBy.AndroidUIAutomator(UiScrollable + ".scrollForward(20).scrollIntoView(textContains(\"Login Form\"))")).click();
        //driver.findElement(MobileBy.AndroidUIAutomator(UiScrollable + ".flingToEnd(1)"));
        login("admin","wrongpassword");
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.view.View[contains(@text, 'Invalid Credentials')]")));
        boolean isDisplayed=driver.findElementByXPath("//android.view.View[contains(@text, 'Invalid Credentials')]").isDisplayed();

        // Assertion
        Assert.assertTrue(isDisplayed);
    }
    public void login(String userName,String password)
    {
        //driver.findElement(MobileBy.xpath("//android.view.View[contains(@text, 'Login Form')]")).click();
        //driver.findElement(MobileBy.xpath("//android.widget.Button[contains(@text, 'Login')]")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.widget.EditText[@resource-id='username']")));
        driver.findElementByXPath("//android.widget.EditText[@resource-id='username']").sendKeys(userName);
        driver.findElementByXPath("//android.widget.EditText[@resource-id='password']").sendKeys(password);
        driver.findElementByXPath("//android.widget.Button[contains(@text, 'Log in')]").click();
    }
    @AfterClass
    public void tearDown() {
        // Close app
        driver.quit();
    }
}
