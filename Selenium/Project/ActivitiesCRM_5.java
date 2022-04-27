import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ActivitiesCRM_5 {

        public static void main(String[] args) throws InterruptedException {
            WebDriver driver = new FirefoxDriver();
            driver.get("http://alchemy.hguy.co/crm");
            driver.manage().window().maximize();
            driver.findElement(By.id("user_name")).sendKeys("admin");
            driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
            driver.findElement(By.id("bigbutton")).click();
            Thread.sleep(9999);
            //String Header = driver.findElement(By.id("toolbar")).getCssValue("background-color");
            String colr = driver.findElement(By.xpath("//*[@id=\"toolbar\"]")).getCssValue("color");
            String Header = driver.findElement (By.xpath("/html/body/div[2]/nav/div/div[2]")).getText();
            System.out.println(colr);
            System.out.println(Header);

            driver.close();
        }
    }

