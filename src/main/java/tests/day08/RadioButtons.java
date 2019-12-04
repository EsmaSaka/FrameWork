package tests.day08;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;

import java.util.List;

public class RadioButtons {

    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver= BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        //to got Radio Button Page
        // linktext only works with element <a>
        // you copy the >"text"<

        driver.findElement(By.linkText("Radio Buttons")).click();
    }

    @Test(description = "verify that blue btn is selected")
    public void test1(){

        // find blue  radio btn
        WebElement Blue=driver.findElement(By.id("blue"));
        // if butn is selected it will return true, otherwise false
        Assert.assertTrue(Blue.isSelected());
    }
    @Test(description = "verify that red btn is not selected")
    public void test2(){
        WebElement red=driver.findElement(By.id("red"));
        Assert.assertFalse(red.isSelected());
    }
    @Test(description = "verify that green btn is diasbled")
    public void test3(){
        WebElement green=driver.findElement(By.id("green"));
        Assert.assertFalse(green.isEnabled());
    }
    @Test(description = "click on all radio btns")
    public void test4() throws InterruptedException {
       List <WebElement> RadioButtons=  driver.findElements(By.cssSelector("input[type='radio']"));
       for(WebElement button : RadioButtons){
           if(button.isEnabled()&& ! button.isSelected()){
               button.click();
               System.out.println("btn clicked : "+button.getAttribute("id"));
           }else{
               System.out.println("btn  not clicked : "+button.getAttribute("id"));
           }
          Thread.sleep(1000);
       }

    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }




}
