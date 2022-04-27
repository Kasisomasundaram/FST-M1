import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ActivitiesCRM_7 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.get("http://alchemy.hguy.co/crm");
        driver.manage().window().maximize();
        driver.findElement(By.id("user_name")).sendKeys("admin");
        driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
        driver.findElement(By.id("bigbutton")).click();
        Thread.sleep(2999);
        WebElement categories = driver.findElement(By.xpath("/html/body/div[2]/nav/div/div[2]/ul/li[2]/span[2]/a"));
        WebElement subMenu = driver.findElement(By.xpath("/html/body/div[2]/nav/div/div[2]/ul/li[2]/span[2]/ul/li[5]/a"));
        Actions action = new Actions(driver);
        action.moveToElement(categories).perform();
        action.moveToElement(subMenu).perform();
        categories.click();
        subMenu.click();
        Thread.sleep(1999);
        WebElement Misinformation = driver.findElement(By.xpath("//*[@id=\"adspan_683f9f93-9423-1a6e-4a4d-5fd8a89ceaab\"]/span"));
        action.moveToElement(Misinformation).perform();
        Misinformation.click();
        Thread.sleep(1999);
        String phone = driver.findElement(By.xpath("/html/body/div[4]/div/div[7]/div[2]/span")).getText();
        Thread.sleep(1999);
        System.out.println(phone);
        driver.close();
    }
}
