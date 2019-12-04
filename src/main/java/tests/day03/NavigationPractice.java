package tests.day03;

import org.openqa.selenium.WebDriver;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class NavigationPractice {
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://google.com");
        driver.navigate().to("http://amazon.com");
        driver.navigate().forward();
        driver.navigate().refresh();//to reload
        BrowserUtils.wait(3);
        driver.quit();




    }
}
