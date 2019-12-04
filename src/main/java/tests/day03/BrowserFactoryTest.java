package tests.day03;


import com.google.gson.internal.bind.util.ISO8601Utils;
import org.openqa.selenium.WebDriver;
import utils.BrowserFactory;




public class BrowserFactoryTest {
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("firefox");
        driver.get("http://practice.cybertekschool.com/");
        System.out.println(driver.getPageSource());
        driver.quit();

    }
}
