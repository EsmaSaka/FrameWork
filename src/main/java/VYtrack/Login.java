package VYtrack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.TestBase;
import utils.BrowserFactory;

import java.util.concurrent.TimeUnit;

public class Login  {
    public static void main(String[] args) throws InterruptedException {


        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://qa2.vytrack.com/user/login");
        driver.findElement(By.id("prependedInput")).sendKeys("user178");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        driver.findElement(By.id("_submit")).click();
        System.out.println(driver.getCurrentUrl());
        String ExpectedUrl= "https://qa2.vytrack.com/";
        //Thread.sleep(4000);
        String ActualUrl=driver.getCurrentUrl();
        if (ActualUrl.equals(ExpectedUrl)){
            System.out.println("true");
        }
        else{
            System.out.println("false");
            System.out.println(ActualUrl);
            System.out.println(ExpectedUrl);
        }
       // Thread.sleep(5000);
        driver.close();

    }
}
