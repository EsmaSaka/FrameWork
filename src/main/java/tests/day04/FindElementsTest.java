package tests.day04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;

import java.util.concurrent.TimeUnit;

public class FindElementsTest {
    public static void main(String[] args) {
        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        WebElement button=driver.findElement(By.id("form_submit"));
        button.click();
        BrowserUtils.wait(3);
       String Actual= driver.getTitle();
       String expected="Practice";
       if(expected.equals(Actual)){
           System.out.println("test passed");
       }else{
           System.out.println(false);
           System.out.println("actual="+Actual);
           System.out.println("expected="+expected);
       }
        driver.close();


    }


}
