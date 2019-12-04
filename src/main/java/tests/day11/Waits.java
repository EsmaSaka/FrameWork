package tests.day11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;

import java.util.concurrent.TimeUnit;

public class Waits {
    private WebDriver driver;

    @BeforeMethod
    public void setu(){
        driver=BrowserFactory.getDriver("Chrome");
        driver.get("http://practice.cybertekschool.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    @Test
    public void test1(){
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.linkText("Dynamic Loading")).click();
        driver.findElement(By.partialLinkText("Example 2:")).click();
        driver.findElement(By.tagName("button")).click();
        WebElement finishElement = driver.findElement((By.id("finish")));
        Assert.assertEquals(finishElement.getText(),"Hello World!","does not match");
        System.out.println("test passed");
    }
    @AfterMethod
    public void teardown(){
        driver.close();
    }

}
