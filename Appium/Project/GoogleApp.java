package Testing;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class GoogleApp {

    AndroidDriver<MobileElement> driver;
    WebDriverWait wait;

    @BeforeClass
    public void beforeClass() throws MalformedURLException {
        // Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceId", "714ae71f");
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "com.google.android.apps.tasks");
        caps.setCapability("appActivity", ".ui.TaskListsActivity");
        caps.setCapability("noReset", true);

        // Instantiate Appium driver
        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(appServer, caps);
        wait = new WebDriverWait(driver, 10);
    }
    @Test
    public void googleApp() throws InterruptedException {

       /* //Get Started
        MobileElement getStarted = driver.findElementById("welcome_get_started");
        getStarted.click();*/
        //Click the button to add a new task.
        MobileElement newTask = driver.findElementById("tasks_fab");
        newTask.click();
        //Add Task Title - i.	Complete Activity with Google Tasks
        MobileElement addTask = driver.findElementById("add_task_title");
        addTask.click();
        addTask.sendKeys("Complete Activity with Google Tasks");
        driver.findElementById("add_task_done").click();

        newTask.click();
        //Add Task Title - ii.	Complete Activity with Google Keep
        addTask.click();
        addTask.sendKeys("Complete Activity with Google Keep");
        driver.findElementById("add_task_done").click();

        newTask.click();
        //Add Task Title - iii.	Complete the second Activity Google Keep
        addTask.click();
        addTask.sendKeys("Complete the second Activity Google Keep");
        driver.findElementById("add_task_done").click();

    }
}
