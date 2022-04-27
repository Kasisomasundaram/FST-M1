import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ActivitiesCRM_3 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.get("http://alchemy.hguy.co/crm");
        driver.manage().window().maximize();
        String footer = driver.findElement(By.xpath("/html/body/div[1]/div[3]/a[1]")).getText();
        System.out.println(footer);
        Thread.sleep(9999);
        driver.close();
    }
}
