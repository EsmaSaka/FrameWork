package tests.day03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class quitClose {
    public static void main(String[] args) throws InterruptedException {


      WebDriverManager.chromedriver().setup();
        ChromeDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/open_new_tab");
        Thread.sleep(4000);
        //driver.navigate().to("http://amazon.com");
   // String url= driver.getCurrentUrl();
     //   System.out.println(url);
        driver.close();
      //  driver.quit();

}
}
