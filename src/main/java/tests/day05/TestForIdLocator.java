package tests.day05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;

public class TestForIdLocator {
    public static void main(String[] args) {
        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
       WebElement button= driver.findElement(By.id("disappearing_button"));
       button.click();
       String text=driver.findElement(By.id("result")).getText();
       String Expected="Now it's gone!";
       if(text.equals(Expected)){
           System.out.println(text);
       }else{
           System.out.println(false);       }

    }


}
