package tests.day10;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

import java.util.concurrent.TimeUnit;

public class AlertBoxes {
    private WebDriver driver;
    @BeforeMethod
    public void setup() {
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test(description = "verify that file was uploaded")
    public void test1(){
        driver.findElement(By.linkText("JavaScript Alerts")).click();
        BrowserUtils.wait(3);
        driver.findElement(By.xpath("//button[contains(text(),'Click for JS Alert')]")).click();
        BrowserUtils.wait(3);
        Alert alert = driver.switchTo().alert();
        alert.accept();
        BrowserUtils.wait(3);
    }
    @Test(description = "click on cancel")
    public void test2(){
        driver.findElement(By.linkText("JavaScript Alerts")).click();
        BrowserUtils.wait(3);
        driver.findElement(By.xpath("//button[2]")).click();

        BrowserUtils.wait(3);
        Alert alert = driver.switchTo().alert();
        // print popup text
        System.out.println(alert.getText());
        alert.dismiss();
        BrowserUtils.wait(3);

    }
    @Test(description = "type some text to the popup")
    public void test3(){
        driver.findElement(By.linkText("JavaScript Alerts")).click();
        BrowserUtils.wait(3);
        driver.findElement(By.xpath("//button[3]")).click();
        // css selector  ("button[onclick='jsPrompt']")

        BrowserUtils.wait(3);
      // Alert alert = driver.switchTo().alert();
       driver.switchTo().alert().sendKeys("esma");
        BrowserUtils.wait(3);
        // print popup text
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
        WebElement result= driver.findElement(By.id("result"));
        System.out.println(result.getText());
        String expected ="You entered: esma";
        Assert.assertEquals(result.getText(),expected,"does not match");
        BrowserUtils.wait(3);

    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
