package Testing;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.CapabilityType;
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
public class Activity3 {



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
        public void addTaskInToDoList() throws InterruptedException {
            wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.view.View")));
            String UiScrollable = "UiScrollable(UiSelector().scrollable(true))";
            driver.findElement(MobileBy.AndroidUIAutomator(UiScrollable + ".flingToEnd(3)"));
            //scrollTo("To-Do List [] Elements get added at run time");
            driver.findElement(MobileBy.xpath("//android.view.View[contains(@text, 'To-Do List')]")).click();
            addTask("Task 1");
            Thread.sleep(3000);
            addTask("Task 2");
            Thread.sleep(3000);
            List<MobileElement> taskList= driver.findElementByXPath("//android.view.View[@resource-id='tasksList']").findElements(MobileBy.xpath("//android.view.View[contains(@text, 'Task')]"));
            for (MobileElement e:taskList) {
                e.click();
            }
            List<MobileElement> taskCard= driver.findElementByXPath("//android.view.View[@resource-id='tasksCard']").findElements(MobileBy.xpath("//android.view.View"));
            taskCard.get(taskCard.size()-1).click();

            List<MobileElement> taskListAfterDeletion= driver.findElements(MobileBy.xpath("//android.view.View[@resource-id='tasksList']"));
            // Assertion
            Assert.assertEquals(taskListAfterDeletion.size()-1, 0);
        }
        public void addTask(String taskName)
        {
            wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.widget.EditText[@resource-id='taskInput']")));
            driver.findElementByXPath("//android.widget.EditText[@resource-id='taskInput']").clear();
            driver.findElementByXPath("//android.widget.EditText[@resource-id='taskInput']").sendKeys(taskName);
            driver.findElementByXPath("//android.widget.Button[contains(@text, 'Add Task')]").click();
        }
        @AfterClass
        public void tearDown() {
            // Close app
            driver.quit();
        }
    }

