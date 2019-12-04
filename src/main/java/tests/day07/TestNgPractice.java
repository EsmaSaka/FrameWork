package tests.day07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserFactory;

public class TestNgPractice {

    @Test
    public void Test(){
        Assert.assertEquals("apple","apple","word is not correct");
    }
    @Test(description = "verifying title")
    public void test() {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com/");

        String expected = "Practice";
        String actual = driver.getTitle();
        Assert.assertEquals(actual, expected, "title is not matching");

        driver.quit();
    }
        @Test(description = "Verify that heading is displayed")
        public void verifyHeadingIsDisplayed(){
            WebDriver driver = BrowserFactory.getDriver("chrome");
            driver.get("http://practice.cybertekschool.com/");
            //if there is no element with this locator, we will get NoSuchElementException
            //and our program will stop on the findElement line
            WebElement heading = driver.findElement(By.xpath("//span[text()='Test Automation Practice']"));
            //to make sure that element is visible to user
            //because element can be present, but not visible
            //we need to make sure element is visible
            Assert.assertTrue(! heading.isDisplayed(),"heading is not being displayed");
            driver.quit();
        }

    }



