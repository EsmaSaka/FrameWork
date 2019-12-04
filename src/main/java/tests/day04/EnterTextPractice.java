package tests.day04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;

import java.util.concurrent.TimeUnit;

import static utils.BrowserFactory.getDriver;

public class EnterTextPractice {
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("firefox");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/forgot_password");
        WebElement Email=driver.findElement(By.name("email"));
        Email.sendKeys("abc@gmail.com");
        WebElement button=driver.findElement(By.id("form_submit"));
        button.click();
        String actualUrl=driver.getCurrentUrl();
        String expectedUrl="http://practice.cybertekschool.com/email_sent";
        if(actualUrl.equals(expectedUrl)){
            System.out.println("test passed");
        }else{
            System.out.println("test failed");
        }
       /* String ActualText=driver.findElement(By.name("confirmation_message")).getText();
        String ExpectedText="Your e-mail's been sent!\n";
        if (ActualText.equals(ExpectedText)) {
            System.out.println(true);
        }else{
            System.out.println(false);
        }*/

        //driver.close();


    }
}
