package tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BasicNavigation {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://google.com");
        driver.navigate().to("http://amazon.com");
        String url= driver.getCurrentUrl();
        System.out.println(url);
        if(url.equals("https://www.amazon.com/")){
            System.out.println(true);
        }else{
            System.out.println(false);

        }




    }
}
