package tests.day01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyFirstSeleniumScript
{
    public static void main(String[] args) {
        //we have to set up webdriver based on the browser  that we gonna use
        WebDriverManager.chromedriver().setup();
        //we need to create an object of approppriate class
        ChromeDriver driver=new ChromeDriver();
        //lets open google
        driver.get("http://google.com");

        //test1 verify the title of page is "Google"
        String actualResult=driver.getTitle();
        String expectedResult="Google";
        if(actualResult.equals(expectedResult)){
            System.out.println("test1 passed");

        }else{
            System.out.println("test failed");

        }



    }
}
