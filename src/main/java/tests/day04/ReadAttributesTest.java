package tests.day04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;

import java.util.concurrent.TimeUnit;

public class ReadAttributesTest {
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("firefox");
        driver.get("http://practice.cybertekschool.com/forgot_password");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement input=driver.findElement(By.name("email"));
        System.out.println( input.getAttribute("pattern"));
        input.sendKeys("abc@gmail.com");
        System.out.println(input.getAttribute("value"));
        WebElement retrievePassword=driver.findElement(By.id("form_submit"));
        retrievePassword.submit();
        driver.close();

    }


}
