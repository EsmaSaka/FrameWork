package tests.day11;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class Example1 {
    private WebDriver driver;

    @BeforeMethod
    public void setu() {
        driver = BrowserFactory.getDriver("Chrome");
        driver.get("http://practice.cybertekschool.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void test1() {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.linkText("Dynamic Loading")).click();
        driver.findElement(By.partialLinkText("Example 1:")).click();
        driver.findElement(By.tagName("button")).click();
        // we find the element first
        // element can be present but not visible
        // within this period of time selenium will check every 500 milliseconds
        // if condition is met no need to wait
        // it will continue
        // how to apply condition |  ExpectedConditions.condition
        WebElement userNameInputBox = driver.findElement(By.id("username"));

        WebDriverWait wait = new WebDriverWait(driver, 30);
        // how to apply condition
        wait.until(ExpectedConditions.visibilityOf(userNameInputBox));
        userNameInputBox.sendKeys("tosmith");
        WebElement passwordInputBox = driver.findElement(By.id("pwd"));
       // WebDriverWait wait = new WebDriverWait(driver, 30);
        // how to apply condition
        wait.until(ExpectedConditions.visibilityOf(passwordInputBox));
        passwordInputBox.sendKeys("SuperSecretPassword");
        // this is a webelement that represents submit button
        WebElement submit = driver.findElement(By.xpath("//button[contains(text(),'Submit')]"));
                                        // cssSelector("button[type='submit']"
        wait.until(ExpectedConditions.elementToBeClickable(submit));
        submit .click();
        WebElement message= driver.findElement(By.tagName("h4"));
        wait.until(ExpectedConditions.visibilityOf(message));
        String expectedMessage= "Welcome to the Secure Area. When you are done click logout below.";
        String actualMessage =message.getText();


    }

    @Test
    public void test2(){
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.linkText("Dynamic Loading")).click();
        driver.findElement(By.partialLinkText("Example 5:")).click();
        WebDriverWait wait= new WebDriverWait(driver, 15);
        WebElement overlayScreen = driver.findElement(By.cssSelector("[class='fa fa-cog fa-spin']"));
        wait.until(ExpectedConditions.invisibilityOf(overlayScreen));
       // driver.findElement(By.tagName("button")).click();

        WebElement userNameInputBox = driver.findElement(By.id("username"));

       // WebDriverWait wait = new WebDriverWait(driver, 30);
        // how to apply condition
        wait.until(ExpectedConditions.visibilityOf(userNameInputBox));
        userNameInputBox.sendKeys("tosmith");
        WebElement passwordInputBox = driver.findElement(By.id("pwd"));
        // WebDriverWait wait = new WebDriverWait(driver, 30);
        // how to apply condition
        wait.until(ExpectedConditions.visibilityOf(passwordInputBox));
        passwordInputBox.sendKeys("SuperSecretPassword");
        // this is a webelement that represents submit button
        WebElement submit = driver.findElement(By.xpath("//button[contains(text(),'Submit')]"));
        // cssSelector("button[type='submit']"
        wait.until(ExpectedConditions.elementToBeClickable(submit));
        submit .click();
        WebElement message= driver.findElement(By.tagName("h4"));
        wait.until(ExpectedConditions.visibilityOf(message));
        String expectedMessage= "Welcome to the Secure Area. When you are done click logout below.";
        String actualMessage =message.getText();

    }
    @Test(description = "Fluent wait example")
    public void test4(){
        driver.findElement(By.linkText("Dynamic Loading")).click();
        driver.findElement(By.partialLinkText("Example 2")).click();
        driver.findElement(By.tagName("button")).click();
        Wait wait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(200))
                .ignoring(NoSuchElementException.class);
                //ignoring(ElementNotVisibleException.class);
        WebElement message = (WebElement) wait.until(new Function<WebDriver, WebElement>() {
                                                         @Override
                                                         public WebElement apply(WebDriver driver) {
                                                             return driver.findElement(By.id("finish"));
                                                         }
                                                     }
        );
    }


    @AfterMethod
    public void teardown() {
        driver.close();
    }
}