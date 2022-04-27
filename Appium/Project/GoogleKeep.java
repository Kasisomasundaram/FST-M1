package Testing;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
public class GoogleKeep {

        AndroidDriver<MobileElement> driver;
        String Title = "The First Title";
        String Note = "Mary had a little lamb, who's fleece was WHITE as SNOW";

        @BeforeClass
        public void setUp() throws MalformedURLException {
            //Desired Capabilities
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("platformName", "android");
            caps.setCapability("automationName", "UIAutomator2");
            //caps.setCapability("deviceName","AndroidTestEmulator");

            caps.setCapability("deviceName", "RZ8M54DFYWR");
            //caps.setCapability("appPackage","com.android.calculator2");
            //Using the Keep app in my Samsung A30 phone
            caps.setCapability("appPackage", "com.google.android.keep");

            caps.setCapability("appActivity", ".activities.BrowseActivity");
            caps.setCapability("noReset", true);

            //Server URL
            URL serverURL = new URL("http://localhost:4723/wd/hub");

            driver = new AndroidDriver<>(serverURL, caps);

        }

        @Test
        public void addNote(){
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            WebDriverWait wait = new WebDriverWait(driver, 20);
            MobileElement addNotes = driver.findElementById("new_note_button");
            addNotes.click();
            wait.until(ExpectedConditions.elementToBeClickable(driver.findElementById("editable_title")));
            driver.findElementById("editable_title").sendKeys(Title);
            wait.until(ExpectedConditions.elementToBeClickable(driver.findElementById("edit_note_text")));
            driver.findElementById("edit_note_text").sendKeys(Note);
            driver.navigate().back();
            driver.navigate().back();
            System.out.println("=======================================================");
            wait.until(ExpectedConditions.elementToBeClickable(driver.findElementById("index_note_title")));
            String postedTitle = driver.findElementById("index_note_title").getText();
            System.out.println("The Title of the note is: "+postedTitle);
            Reporter.log("The Title of the note is: "+postedTitle);
            String postedNote = driver.findElementById("index_note_text_description").getText();
            System.out.println("The Content of the note is: "+postedNote);
            Reporter.log("The Content of the note is: "+postedNote);
            System.out.println("=======================================================");
            Assert.assertEquals(postedTitle,Title);
            Assert.assertEquals(postedNote,Note);
        }



        @AfterClass
        public void tearDown() {
            driver.quit();
        }

    }

