package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigation {


        public static void main(String[] args) throws Throwable{
//to setup chrome driver
            WebDriverManager.chromedriver().setup();
            ChromeDriver driver=new ChromeDriver();
            String url="http://google.com";
            String url2="http://amazon.com";
// open brwoser
            driver.get(url);
//close browser
            Thread.sleep(3000);
// navigate
            driver.navigate().to(url2);
            //driver.close();

        }
    }

