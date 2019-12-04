package tests.day06;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BrowserFactory;

public class BitrixLogin {
    public static void main(String[] args) {
        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.get("https://login1.nextbasecrm.com/stream/?login=yes");
        driver.findElement(By.xpath("//input[@placeholder='Login']")).sendKeys("helpdesk59@cybertekschool.com");
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("UserUser");
        driver.findElement(By.xpath("//input[starts-with(@onclick, 'BX')]")).click();
                 //    /             //*[@onclick='BX.addClass(this, 'wait');']

    }
}
