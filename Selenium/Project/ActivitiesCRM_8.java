import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class ActivitiesCRM_8 {


        public static void main(String[] args) throws InterruptedException {
            WebDriver driver = new FirefoxDriver();
            driver.get("http://alchemy.hguy.co/crm");
            driver.manage().window().maximize();
            driver.findElement(By.id("user_name")).sendKeys("admin");
            driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
            driver.findElement(By.id("bigbutton")).click();
            Thread.sleep(2999);
            WebElement categories1 = driver.findElement(By.xpath("/html/body/div[2]/nav/div/div[2]/ul/li[2]/span[2]/a"));
            WebElement subMenu1 = driver.findElement(By.xpath("//*[@id=\"moduleTab_9_Accounts\"]"));
            Actions action = new Actions(driver);
            action.moveToElement(categories1).perform();
            action.moveToElement(subMenu1).perform();
            categories1.click();
            subMenu1.click();
            Thread.sleep(1999);
            driver.close();
}
    }
