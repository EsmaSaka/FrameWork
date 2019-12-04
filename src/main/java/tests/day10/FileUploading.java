package tests.day10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

import java.util.concurrent.TimeUnit;

public class FileUploading {

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
        driver.findElement(By.linkText("File Upload")).click();
        BrowserUtils.wait(3);
        driver.findElement(By.id("file-upload")).sendKeys("C:/Users/esmab/Desktop/choropath.rtf");
        driver.findElement(By.id("file-submit")).click();
        String  actualFileName= driver.findElement(By.id("uploaded-files")).getText();
        String expected = "choropath.rtf";
        Assert.assertEquals(actualFileName, expected, " file name does not match");

    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }


}
