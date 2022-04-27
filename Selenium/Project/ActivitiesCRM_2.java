import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ActivitiesCRM_2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.get("http://alchemy.hguy.co/crm");
        driver.manage().window().maximize();
      //WebElement getURL = driver.findElement(By.xpath("//img[@alt='SuiteCRM']"));
        //getAttribute() to get src of image
     //   System.out.println("Src attribute is: " + getURL.getAttribute("src"));
        //Get the url of the header image

        String url = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/form[1]/div[1]/img")).getAttribute("src");
        //Print the url to the console.
        System.out.println("url :"+url);
        Thread.sleep(9999);
        driver.close();
    }
}