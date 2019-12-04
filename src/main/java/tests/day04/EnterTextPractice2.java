package tests.day04;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;

import java.util.concurrent.TimeUnit;

public class EnterTextPractice2 {
    public static void main(String[] args) {


        WebDriver driver = BrowserFactory.getDriver("firefox");
        driver.get("http://practice.cybertekschool.com/forgot_password");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        BrowserUtils.wait(2);
        WebElement Email = driver.findElement(By.name("email"));
        Email.sendKeys("abc@gmail.com",Keys.ENTER);
        WebElement button = driver.findElement(By.id("form_submit"));
        button.click();
      /*  String actualUrl=driver.getCurrentUrl();
        String expectedUrl="http://practice.cybertekschool.com/email_sent";
        if(actualUrl.equals(expectedUrl)){
            System.out.println("test passed");
        }else{
            System.out.println("test failed");
            System.out.println("actual= "+actualUrl);
            System.out.println("expected= "+expectedUrl);
        }*/
        String ActualText=driver.findElement(By.name("confirmation_message")).getText();
        String ExpectedText="Your e-mail's been sent!";
        if (ActualText.equals(ExpectedText)) {
            System.out.println("true");
        }else{
            System.out.println("false");
        }
        driver.close();


    }
}
