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

public class CheckBoxes {

    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver= BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        //to got Radio Button Page
        // linktext only works with element <a>
        // you copy the >"text"<

        driver.findElement(By.linkText("Checkboxes")).click();
    }

    @Test(description = "verify that if buttons are clickable ")
    public void test1() {
      List <WebElement> check=  driver.findElements(By.cssSelector("[type='checkbox']"));
              //                                        #checkboxes"  [type='checkbox']
      for(WebElement checkbox : check){
          if(checkbox.isEnabled() && ! checkbox.isSelected()){
              checkbox.click();
              System.out.println("clicked  "+ checkbox.getText()+",");
          }else{
              System.out.println(" not clicked  "+ checkbox.getText());
          }
      }

    }
    @Test(description = "verify that")
    public void test2(){

    }
    @Test(description = "")
    public void test3(){

    }
    @Test(description = "")
    public void test4() throws InterruptedException {

    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }


}
