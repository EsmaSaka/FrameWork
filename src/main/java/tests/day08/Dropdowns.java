package tests.day08;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Dropdowns {
    WebDriver driver;
    @BeforeMethod
    public void setup() {
        driver = BrowserFactory.getDriver("firefox");
        driver.get("http://practice.cybertekschool.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//        <a href="/checkboxes">Checkboxes</a>
        driver.findElement(By.linkText("Dropdown")).click();
    }
    @Test(description = "select option 2 from dropdown")
    public void test1() throws InterruptedException {
       WebElement dropdown= driver.findElement(By.id("dropdown"));
       // select class requires webelement obj as parameter
        Select select= new Select((dropdown));
        // to select any option by visible text
        select.selectByVisibleText("Option 2");
        Thread.sleep(1000);
        //how can we verify that we selected that option?
        // select.getFirstSelectedOption() --> to get selected option
        Assert.assertEquals(select.getFirstSelectedOption().getText(),"Option 2");

    }
    @Test(description = "all states")
    public void test2(){
        WebElement state= driver.findElement(By.id("state"));
        Select select=new Select(state);
        List <WebElement> states= select.getOptions();
        for (WebElement option:states) {
            System.out.println(option.getText());
        }
    }
    @Test(description = "Ga")
    public void test3() throws InterruptedException {
       // driver.findElement(By.id("state"));
        WebElement state = driver.findElement(By.id("state"));
        Select select = new Select(state);
        select.selectByValue("GA");
        Thread.sleep(2000);
        Assert.assertEquals(select.getFirstSelectedOption().getText(), "Georgia");
    }
    @AfterMethod
    public void teardown() {
        driver.quit();
    }

}
